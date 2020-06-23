package ftp.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import ftp.server.FTPServer;

public class FTPClientStarter {

	public static void main(String[] args) throws UnknownHostException {
		
		
		InetAddress serverAdd = InetAddress.getByName("127.0.0.1");
		int port = 8888;
		
	
		for(int i = 0 ; i < 3 ; i++) {
			new Thread() {

				@Override
				public void run() {
					FTPClient ftpClient = new FTPClient(serverAdd, port);
					ftpClient.connect();
				}
				
			}.start();
		}
		
	}

}
