package demo.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BytesReader {
	
	private static final String fileName = "worknote.txt";
	private static final String folderPath = "webroot";
	private static final String filePath = System.getProperty("user.dir") + "\\" + folderPath + "\\" + fileName;
	private static final int buff_size = 1024;
	private static byte[] buff = new byte[buff_size];
	
	public static void main(String[] args) {
		
		File file = new File(filePath);
		int count = 0;
		int pos = 0;
		InputStream input;
		try {
			input = new FileInputStream(filePath);
			count = input.read(buff, 0, buff.length);
			while(true) {
				
				if(pos >= count) {
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!read once more!!!!!!!!!!!!!!!!!!!!!!");
					pos = 0;
					count = input.read(buff, 0, buff.length);
					if(count ==-1) break;
				}
				
				else {
					char out = (char)buff[pos++];
					System.out.print(out);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
