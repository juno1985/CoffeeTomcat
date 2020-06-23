package ftp.common;

public class ByteStringUtils {

	public static String getString(byte[] arr, int size) {

		if (size < 1)
			return null;
		StringBuffer strBuff = new StringBuffer();

		for (int i = 0; i < size; i++) {
			strBuff.append((char) arr[i]);
		}
		return strBuff.toString();
	}
}
