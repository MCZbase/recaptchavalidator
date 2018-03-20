/**
 * 
 */
package edu.harvard.mcz.recaptchavalidate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * @author mole
 *
 */
public class RecaptchaValidate {
	
	private static final String SECRET = "PUT SECRET KEY HERE";

	public static boolean validate(String response, String remoteip) {
		
		boolean retval = false; 
		
	    JsonObject jsonResponse = null;
	    InputStream is = null;
	    String charset = java.nio.charset.StandardCharsets.UTF_8.name();

	    String verifyUrl = "https://www.google.com/recaptcha/api/siteverify";
	    
	    try {            
	        String query = String.format("secret=%s&response=%s&remoteip=%s", 
	        URLEncoder.encode(SECRET, charset), 
	        URLEncoder.encode(response, charset),
	        URLEncoder.encode(remoteip, charset));

	        URLConnection connection = new URL(verifyUrl + "?" + query).openConnection();
	        is = connection.getInputStream();
	        JsonReader rdr = Json.createReader(is);
	        jsonResponse = rdr.readObject();

	    } catch (IOException ex) {
	    }
	    finally {
	        if (is != null) {
	            try {
	                is.close();
	            } catch (IOException e) {
	            }

	        }
	    }
	    
	    if (jsonResponse!=null) { 
	    	if (jsonResponse.containsKey("success")) { 
	    	   boolean success = jsonResponse.getBoolean("success");
	    	   if (success) { 
	    		  retval = true;
	    	   }
	    	}
	    }
	    
	    return retval;
	}	
	
	
}
