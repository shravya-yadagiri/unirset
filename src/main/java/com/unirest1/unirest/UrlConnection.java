package com.unirest1.unirest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class UrlConnection
{

	// HTTP GET request
	 private void sendingGetRequest() throws Exception {
	 
	  String urlString = "https://api.stlouisfed.org/fred/series?series_id=GNPCA&api_key=abcdefghijklmnopqrstuvwxyz123456&file_type=json";
	  
	  URL url = new URL(urlString);
	  HttpURLConnection con = (HttpURLConnection) url.openConnection();
	 
	  // By default it is GET request
	  con.setRequestMethod("GET");
	 
		/*
		 * //add request header con.setRequestProperty("User-Agent", USER_AGENT);
		 */
	 
	  int responseCode = con.getResponseCode();
	  System.out.println("Sending get request : "+ url);
	  System.out.println("Response code : "+ responseCode);
	 
	  // Reading response from input Stream
	  BufferedReader in = new BufferedReader(
	          new InputStreamReader(con.getInputStream()));
	  String output;
	  StringBuffer response = new StringBuffer();
	 
	  while ((output = in.readLine()) != null) {
	   response.append(output);
	  }
	  in.close();
	 
	  //printing result from response
	  System.out.println(response.toString());
	 
	 }
	
	
	
}
