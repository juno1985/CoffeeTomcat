package ftp.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class FTPServer {

	private static final int backlog = 10;
	private static final int port = 8888;
	private static final InetAddress bindAddr;
	
	private static Log logger = LogFactory.getLog(FTPServer.class);

	static {
		try {
			bindAddr = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw new RuntimeException("Binding local address failed");
		}
	}

	public static void startup() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port, backlog, bindAddr);
			if(serverSocket != null) {
				logger.info("Server started at " + port);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Socket socket;
		InputStream inputStream;
		OutputStream outputStream;
		while (true) {

			if (serverSocket != null) {

				try {
					socket = serverSocket.accept();
					inputStream = socket.getInputStream();
					outputStream = socket.getOutputStream();
					
					String t = "Congratulations! You have establised connection to Server";
					outputStream.write(t.getBytes());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				logger.error("Server Socket is null and cannot be in listening state");
				break;
			}

		}

	}

}
