package org.navin.ocbr.examples;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdfconnection.RDFConnection; 
import org.apache.jena.rdfconnection.RDFConnectionRemote;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;  

public class MyExample {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		//RDFConnectionRemoteBuilder builder = RDFConnection.create()
	   //         .destination("http://localhost:3030/vacations/query");
		
		//org.apache.jena.rdfconnection.RDFConnectionRemote
		
		//RDFConnectionRemoteBuilder c = RDFConnectionRemote.create();  
		
		
		RDFConnection conn0 = RDFConnectionRemote.create().destination("http://localhost:3030/vacations/")
		            .queryEndpoint("query")
		            .acceptHeaderSelectQuery("application/sparql-results+json, application/sparql-results+xml;q=0.9")
		            .build();
		  
		            // Set a specific accept header; here, sparql-results+json (preferred) and text/tab-separated-values
		            // The default is "application/sparql-results+json, application/sparql-results+xml;q=0.9, text/tab-separated-values;q=0.7, text/csv;q=0.5, application/json;q=0.2, application/xml;q=0.2, */*;q=0.1" 
		            
		        
		        //Query query = QueryFactory.create("SELECT * { BIND('Hello'as ?text) }");
		        Query query = QueryFactory.create("SELECT ?x ?y ?z WHERE {?x ?y ?z}");

		        // Whether the connection can be reused depends on the details of the implementation.
		        // See example 5.
		        try ( RDFConnection conn = conn0 ) { 
		            conn.queryResultSet(query, ResultSetFormatter::out);
		        }
	}

}
