//This CompaniesClient.java file is part of a grpc demo
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

//import com.google.protobuf.Message;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
//import io.grpc.grpcDemo1.CompaniesGrpc.CompaniesBlockingStub;
//import io.grpc.grpcDemo1.CompaniesGrpc.CompaniesStub;
import io.grpc.stub.StreamObserver;
//import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompaniesClient {
	
	private static final Logger logger = Logger.getLogger(CompaniesClient.class.getName());
	
	private final ManagedChannel channel;
	private final CompaniesGrpc.CompaniesBlockingStub blockingStub;
	private final CompaniesGrpc.CompaniesStub asyncStub;
	
	/** Construct client for accessing company information server at {@code host:port}. */
	public CompaniesClient(String host, int port) {
	  this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true));
	}
	
	/** Construct client for accessing company information server using the existing channel. */
	public CompaniesClient(ManagedChannelBuilder<?> channelBuilder) {
	  channel = channelBuilder.build();
	  blockingStub = CompaniesGrpc.newBlockingStub(channel);
	  asyncStub = CompaniesGrpc.newStub(channel);
	}
	
	public void shutdown() {
	  channel.shutdown();
	}
	
	/**
	   * Blocking unary call example.  Calls getFoundingYear() of a stub and prints the response.
	*/
	public void getFoundingYear(String name) {
		System.out.println("----------- Get founding year --------------");
		System.out.println("Inquire the founding year of the company: " + name);
//		info("----------- Get founding year --------------");
//		info("Inquire the founding year of the company: {0}", name);
		Name companyName = Name.newBuilder().setName(name).build();
		FoundingYear foundingYear;
		
		try {
			foundingYear = blockingStub.getFoundingYear(companyName);
		} catch(StatusRuntimeException e) {
			System.out.println("getFoundingYear RPC failed: {0}" + e.getStatus());
//			warning("getFoundingYear RPC failed: {0}", e.getStatus());
			return;
		}
		
		int year = foundingYear.getYear();
		if(year != 0) {
			System.out.println("The company " + name + " was founded in the year of " + year);
			System.out.println();
//			info("The company {0} was founded in the year of {1}", name, year);
		}
		else {
			System.out.println("There is no company called " + name + " in the database");
			System.out.println();
//			info("There is no company called {0} in the database", name);
		}
	}
	
	/**
	   * Blocking server-streaming example. Calls listCompanies with a founding year. Prints each
	   * response company name as it arrives.
	*/
	public void listCompanies(int year) {
		System.out.println("----------- List companies --------------");
		System.out.println("Search the companies founded in the year of " + year);
		FoundingYear foundingYear = FoundingYear.newBuilder().setYear(year).build();
		Iterator<Name> names;
		
		try {
			names = blockingStub.listCompanies(foundingYear);
			System.out.println("Below are the companies: ");
			for (int i = 1; names.hasNext(); i++) {
		        Name name = names.next();
		        System.out.println("Company " + i + " is " + name.getName());
		    }
		} catch(StatusRuntimeException e) {
			System.out.println("listCompanies RPC failed: {0}" + e.getStatus());
			return;
		}
		
		System.out.println("End of the company list");
		System.out.println();
	}
	
	/**
	   * Async client-streaming example. Sends some company names to the server,
	   * Prints the average existing years of those companies.
	   * For simplicity, the company names are hard coded in this method.
	*/
	public void calcAverageAge() {
		System.out.println("----------- Calculate average age --------------");
		System.out.println("Calculate the average existing years of the companies sent to the server");
		
//		create some company names
		ArrayList<Name> companyNames = new ArrayList<Name>();
		companyNames.add(Name.newBuilder().setName("ABC Telecom").build());
		companyNames.add(Name.newBuilder().setName("DEF Telecom").build());
		companyNames.add(Name.newBuilder().setName("GHI Telecom").build());
		companyNames.add(Name.newBuilder().setName("JKL Telecom").build());
		companyNames.add(Name.newBuilder().setName("MNO Telecom").build());

		StreamObserver<AverageAge> responseObserver = new StreamObserver<AverageAge>() {
//			private int test = 0;
//			
//			public int getTest(){
//				return test;
//			}
			
//			@Override
		    public void onNext(AverageAge averageAge) {
		    	System.out.println("The average age of the companies is: " + averageAge.getAge());
			}
		    
//		    @Override
		    public void onError(Throwable t) {
		    	System.out.println("Calculating average age failed: " + Status.fromThrowable(t));
		    }
		    
//		    @Override
		    public void onCompleted() {
		    	System.out.println("Finished calculating average age");
		    	System.out.println();
		    }
		};
		
//		System.out.println(responseObserver);
//		System.out.println(responseObserver.getTest());
//		responseObserver.onNext(AverageAge.newBuilder().setAge(100).build());
		StreamObserver<Name> requestObserver = asyncStub.calcAverageAge(responseObserver);
//		System.out.println(requestObserver);
//		requestObserver.onNext(Name.newBuilder().setName("ABC Food").build());
//		System.out.println("total age is " + requestObserver.totalAge + ", count is " + requestObserver.count);
		
		try {
			for(Name name : companyNames) {
				System.out.println("Send company name: " + name.getName());
				requestObserver.onNext(name);
			}
		} catch(RuntimeException e) {
			// Cancel RPC
		    requestObserver.onError(e);
		    throw e;
		}
		// Mark the end of requests
	    requestObserver.onCompleted();
	}
	
	/**
	   * Bi-directional example, which can only be asynchronous. 
	   * Send some company names to the server, and receive their information from the server.
	   * For simplicity, the company names are hard coded in this method.
	*/
	public void getCompanyInformation() {
		System.out.println("----------- Get company information --------------");
		System.out.println("Get the companies' information corresponding to the company names");
		
//		create some company names
		ArrayList<Name> companyNames = new ArrayList<Name>();
		companyNames.add(Name.newBuilder().setName("ABC Garment").build());
		companyNames.add(Name.newBuilder().setName("DEF Telecom").build());
		companyNames.add(Name.newBuilder().setName("MNO Technologies").build());

		StreamObserver<Company> responseObserver = new StreamObserver<Company>() {
//			@Override
		    public void onNext(Company company) {
		    	System.out.println("Received from server: Company " + company.getName().getName() + 
		    			" was founded in the year of " + company.getFoundingYear().getYear() + 
		    			", and its market value is " + company.getMarketValue());
			}
		    
//		    @Override
		    public void onError(Throwable t) {
		    	System.out.println("Getting company information failed: " + Status.fromThrowable(t));
		    }
		    
//		    @Override
		    public void onCompleted() {
		    	System.out.println("Finished Getting company information");
		    	System.out.println();
		    }
		};
		
		StreamObserver<Name> requestObserver = asyncStub.getCompanyInformation(responseObserver);
		
		try {
			for(Name request : companyNames) {
				System.out.println("Sending company name: " + request.getName());
				requestObserver.onNext(request);
			}
		} catch(RuntimeException e) {
			// Cancel RPC
		    requestObserver.onError(e);
		    throw e;
		}
		
		// Mark the end of requests
	    requestObserver.onCompleted();
	}
	
	/** Issues several different requests and then exits. */
	public static void main(String[] args) {
		
		CompaniesClient client = new CompaniesClient("localhost", 50051);
		
		try {
//			get the founding year of a given company
			client.getFoundingYear("ABC Something");
			
//			list the companies founded in a given year
			client.listCompanies(1874);
			
//			calculate the average existing years of some companies
			client.calcAverageAge();
			
//			get some companies' information form the server
			client.getCompanyInformation();
		} finally {
			client.shutdown();
		}
	}
	
	private void info(String msg, Object... params) {
	    logger.log(Level.INFO, msg, params);
	}

	private void warning(String msg, Object... params) {
	  logger.log(Level.WARNING, msg, params);
	}
}
