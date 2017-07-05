package io.grpc.grpcDemo1;

import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;


/**
 * Common utilities for the grpcDemo1.
 */
public class CompaniesUtil {
	
//	this main() method is just for testing and debugging
	public static void main(String[] args) throws Exception{
		List<Company> companies = parseCompanies(getDefaultCompaniesFile());
		
		for(Company company : companies) {
        	System.out.println(company);
        }
	}
	
	public static URL getDefaultCompaniesFile() {
		return CompaniesServer.class.getResource("companies_db.json");
	}
	
	public static List<Company> parseCompanies(URL file) throws IOException {
		InputStream input = file.openStream();
	    try {
	      Reader reader = new InputStreamReader(input);
	      try {
	        CompanyDatabase.Builder database = CompanyDatabase.newBuilder();
	        JsonFormat.parser().merge(reader, database);
//	        List<Company> companyList = database.getCompanyList();
//	        for(Company company : companyList) {
//	        	System.out.println(company);
//	        }
//	        return companyList;
	        return database.getCompanyList();
	      } finally {
	        reader.close();
	      }
	    } finally {
	      input.close();
	    }
	}

}
