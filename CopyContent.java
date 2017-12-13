package StMarys.AdvComm.GetContent;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class CopyContent {

//	  public static void main (String[] args) {
	  public static void GetContent(String args) {
		
		 HttpClient client = HttpClientBuilder.create().build();

		 HttpGet request = new HttpGet(args);
		 byte[] content = new byte[1024];
		 
	        try {
	            HttpResponse response = client.execute(request);
	            HttpEntity entity = response.getEntity();
	            Header []headerDet = response.getHeaders("Content-Disposition");
//	            String fname = "test.pdf";
	            String fname = headerDet[0].getValue();

	            fname = fname.substring(fname.indexOf("\"")+1, fname.indexOf("\"", fname.indexOf("\"")+1));
	            
	            // Read the contents of an entity and return it as a byte[].
	            content = EntityUtils.toByteArray(entity);
	            
	            String strFilePath = "C://SocketProg_Demo//"+ fname +"";
	            FileOutputStream fos = new FileOutputStream(strFilePath);

	            fos.write(content);
	            fos.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
//	        return content;
   }
}
