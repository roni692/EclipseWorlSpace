package StMarys.AdvComm.HttpGet;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class GetResponse {

	public static String HTTPResp(String u1) {
		
		 HttpClient client = HttpClientBuilder.create().build();

	        HttpGet request = new HttpGet(u1);
	        String content = "";
		 
	        try {
	            HttpResponse response = client.execute(request);
	            HttpEntity entity = response.getEntity();

	            // Read the contents of an entity and return it as a String.
	            content = EntityUtils.toString(entity);
	            System.out.println(content); 
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	        return content;
   }
}
