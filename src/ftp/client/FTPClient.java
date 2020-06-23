package ftp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ftp.common.ByteStringUtils;

public class FTPClient {
	
	private InetAddress serverAdd;
	private int port;
	
	private static final Log logger = LogFactory.getLog(FTPClient.class);
	
	
	public FTPClient(InetAddress serverAdd, int port) {
		this.serverAdd = serverAdd;
		this.port = port;
	}



	public void connect() {
		Socket socket = null;
		InputStream inputStream;
		OutputStream outputStream;
		try {
			 socket = new Socket(serverAdd, port);
			 inputStream = socket.getInputStream();
			 outputStream = socket.getOutputStream();
			 byte[] byte_buffer = new byte[8096];
			 int size;
			 while((size = inputStream.read(byte_buffer)) != -1) {
				 String out = ByteStringUtils.getString(byte_buffer, size);
				 logger.info(out);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
