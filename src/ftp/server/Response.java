package ftp.server;
import ftp.common.StreamHolder;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class Response extends Thread {
	
	//private StreamHolder streamHolder;
	private static final Log logger = LogFactory.getLog(Response.class);
	private Socket socket;

	public Response(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		String t = "Congratulations! You have establised connection to Server";
		InputStream inputStream;
		OutputStream outputStream;
		try {
			logger.info(Thread.currentThread().getName() + " is serving at Server End");
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			outputStream.write(t.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
				logger.info(Thread.currentThread().getName() + " shutdown socket");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	
}
