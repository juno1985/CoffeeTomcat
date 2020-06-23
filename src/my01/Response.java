package my01;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

/*
  HTTP Response = Status-Line
    *(( general-header | response-header | entity-header ) CRLF)
    CRLF
    [ message-body ]
    Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
*/

public class Response {

  private static final int BUFFER_SIZE = 1024;
  Request request;
  OutputStream output;

  public Response(OutputStream output) {
    this.output = output;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public void sendStaticResource() throws IOException {
    byte[] bytes = new byte[BUFFER_SIZE];
    FileInputStream fis = null;
    try {
      File file = new File(HttpServer.WEB_ROOT, request.getUri());
      if (file.exists()) {
    setHeaderForChrome(file);
    	  
        fis = new FileInputStream(file);
        
        int ch = fis.read(bytes, 0, BUFFER_SIZE);
        while (ch!=-1) {
        	
          output.write(bytes, 0, ch);
          ch = fis.read(bytes, 0, BUFFER_SIZE);
          
        }
      }
      else {
        // file not found
        String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
          "Content-Type: text/html\r\n" +
          "Content-Length: 23\r\n" +
          "\r\n" +
          "<h1>File Not Found</h1>";
        output.write(errorMessage.getBytes());
      }
    }
    catch (Exception e) {
      // thrown if cannot instantiate a File object
      System.out.println(e.toString() );
    }
    finally {
      if (fis!=null)
        fis.close();
    }
  }
  
  private void setHeaderForChrome(File file) {
	  long filesize = file.length();
		/*
		 * String header = "HTTP/1.1 200 OK\r\n"+ "Content-Type: text/html\r\n"
		 * + "Content-Length: " + filesize + "\r\n";
		 */
	  
	  String header = "HTTP/1.1 200 OK\r\n" +
	          "Content-Type: text/html\r\n" +
	          "Content-Length: "+filesize+"\r\n" +
	          "\r\n" ;
	  
	  byte[] b = header.getBytes();
	  System.out.println("--> " + header);
	  try {
		output.write(b);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
 
}