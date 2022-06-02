import java.io.IOException;
import java.net.*;

//Author: Calum Bird
//Age: 17
//School: Mount Allison University

public class HelloWorld
{
	public static void main(String[] args) throws Exception
	{
		String val = pingHost("http://www.google.com");
		
		if(val.equals("200"))
		{
			System.out.println("Hello World!");
		}
		else
		{
			System.out.println("hola world");
		}
	}
	
	public static String pingHost(String host)
	{
		HttpURLConnection connection = null;
	    try {
	        URL u = new URL(host);
	        connection = (HttpURLConnection) u.openConnection();
	        connection.setRequestMethod("HEAD");
	        int code = connection.getResponseCode();
	        return "" + code;
	        // You can determine on HTTP return code received. 200 is success.
	    } catch (MalformedURLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return e.getMessage();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return e.getMessage();
	    } finally {
	        if (connection != null) {
	            connection.disconnect();
	        }
	    }
	}
}