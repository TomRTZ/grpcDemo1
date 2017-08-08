//This CompaniesServer.java file is part of a grpc demo
//It utilizes the generated source files by grpc tools to run a server
//The generated source files are in the folder of target/generated-sources/protobuf
//The grpc tools generate some classes according to the messages defined in companies.proto
//These classes definitions are in the folder of target/generated-sources/protobuf/java
//The grpc tools also generate a classes according to the service defined in companies.proto
//This class definition is in the folder of target/generated-sources/protobuf/grpc-java
//In order to run the program, some grpc related libraries should be included in the project
//Therefore this project was set up as a Maven project and its pom.xml file includes suitable depencencies
//For further information, please refer to the grpc tutorials on http://www.grpc.io

package io.grpc.grpcDemo1;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
//import java.util.List;
//import java.util.logging.Level;
import java.util.logging.Logger;

public class CompaniesServer {
	
	private static final Logger logger = Logger.getLogger(CompaniesServer.class.getName());

	private final int port;
	private final Server server;
	private final CompanyService service;
	
	public CompaniesServer(int port) throws IOException {
	    this(port, CompaniesUtil.getDefaultCompaniesFile());
	}
	
	/** Create a company information server listening on {@code port} using {@code companiesFile} database. */
	public CompaniesServer(int port, URL companiesFile) throws IOException {
	  this(ServerBuilder.forPort(port), port, CompaniesUtil.parseCompanies(companiesFile));
	}	
	
	/** Create a company information server using serverBuilder as a base and companies as data. */
	public CompaniesServer(ServerBuilder<?> serverBuilder, int port, Collection<Company> companies) {
	  this.port = port;
	  this.service = new CompanyService(companies);
	  server = serverBuilder.addService(service).build();
	}
	
	/** Start serving requests. */
	public void start() throws IOException{
		server.start();
		System.out.println("Server started, listening on " + port);
//		logger.info("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
		    public void run() {
		      // Use stderr here since the logger may has been reset by its JVM shutdown hook.
		      System.err.println("*** shutting down gRPC server since JVM is shutting down");
		      CompaniesServer.this.stop();
		      System.err.println("*** server shut down");
		    }
		});
	}
	
	/** Stop serving requests and shutdown resources. */
	public void stop() {
	    if (server != null) {
	        server.shutdown();
	    }
	}
	
	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
	    if (server != null) {
	        server.awaitTermination();
	    }
	}
	
//	for debugging, print all the company data in the json database
	private void printData() {
		System.out.println(server.getServices().get(0));
		for(Company company : service.companies) {
			System.out.println("Company " + company.getName().getName() + 
					", founded in year " + company.getFoundingYear().getYear() + 
					", market value is " + company.getMarketValue());
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception{
		
		//		System.out.println("test");
		CompaniesServer server = new CompaniesServer(50051);
		server.printData();		//check if the data is ready and correct
		server.start();
		server.blockUntilShutdown();
	}
	
	private static class CompanyService extends CompaniesGrpc.CompaniesImplBase {
		private final Collection<Company> companies;
		
		CompanyService(Collection<Company> companies) {
		  this.companies = companies;
		}
		
		@Override
		public void getFoundingYear(Name request, StreamObserver<FoundingYear> responseObserver) {
			responseObserver.onNext(checkFoundingYear(request));
			responseObserver.onCompleted();
		}
		
		@Override
		public void listCompanies(FoundingYear request, StreamObserver<Name> responseObserver) {
			for(Company company : companies) {
				if(company.getFoundingYear().getYear() == request.getYear()) {
					responseObserver.onNext(company.getName());
				}
			}
			responseObserver.onCompleted();
		}
		
		@Override
		public StreamObserver<Name> calcAverageAge(final StreamObserver<AverageAge> responseObserver) {
			return new StreamObserver<Name>() {
				public int totalAge = 0;
				int count = 0;
				
//				@Override
		        public void onNext(Name name) {
		        	int age = 2017 - checkFoundingYear(name).getYear();
		        	System.out.println("age is " + age);
		        	if(age != 2017) {
		        		count++;
		        		totalAge += age;
		        	}
		        	System.out.println("Test1: total age is " + this.totalAge + ", count is " + this.count);
		        	System.out.println();
				}
		        
//		        @Override
		        public void onError(Throwable t) {
		        	System.out.println("Calculating average age cancelled");
				}
		        
//		        @Override
		        public void onCompleted() {
		        	System.out.println("total age is " + this.totalAge + ", count is " + this.count);
//		        	AverageAge anAge = AverageAge.newBuilder().setAge(1000).build();
//		        	System.out.println(responseObserver.toString());
//		        	responseObserver.onNext(anAge);
		        	if(count != 0) {
		        		int average = (int)(totalAge / count);
		        		System.out.println("average age " + average);
		        		responseObserver.onNext(AverageAge.newBuilder().setAge(average).build());
		        		responseObserver.onCompleted();
		        	}
		        	else {
		        		responseObserver.onNext(AverageAge.newBuilder().setAge(0).build());
		        		responseObserver.onCompleted();
		        	}
		        }
			}; 
		}
		
		@Override
	    public StreamObserver<Name> getCompanyInformation(final StreamObserver<Company> responseObserver) {
			return new StreamObserver<Name>() {
//				@Override
		        public void onNext(Name name) {
		        	boolean found = false;
		        	for(Company company : companies) {
		        		if(company.getName().getName().equals(name.getName())) {
		        			responseObserver.onNext(company);
		        			found = true;
		        			break;
		        		}
		        	}
		        	if(!found) {
		        		responseObserver.onNext(Company.newBuilder().setName(Name.newBuilder().setName("Not found").build())
		        				.setFoundingYear(FoundingYear.newBuilder().setYear(0).build())
		        				.setMarketValue(0).build());
		        	}
				}
		        
//		        @Override
		        public void onError(Throwable t) {
		        	System.out.println("Getting companies information cancelled");;
				}
		        
//		        @Override
		        public void onCompleted() {
		        	responseObserver.onCompleted();
		        }
			}; 
		}
		
		private FoundingYear checkFoundingYear(Name name) {
//			logger.info("input name " + name.getName());
			for(Company company : companies) {
//				logger.info("company name " + company.getName().getName());
				if(company.getName().getName().equals(name.getName())) {
//					logger.info("company name " + company.getName().getName());
					return company.getFoundingYear();
				}
			}
			
			FoundingYear returnYear = FoundingYear.newBuilder().setYear(0).build();
//			logger.info("Not found year " + returnYear.getYear());
			return returnYear;
		}
	}
}
