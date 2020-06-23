package ftp.common;
import java.io.InputStream;
import java.io.OutputStream;
public class StreamHolder {
	
	private static final ThreadLocal<InputStream> inputLocalThread = new ThreadLocal<>();
	private static final ThreadLocal<OutputStream> outputLocalThread = new ThreadLocal<>();
	
	public StreamHolder(InputStream input, OutputStream output) {
		inputLocalThread.set(input);
		outputLocalThread.set(output);
	}
	
	public static void setInput(InputStream input) {
		inputLocalThread.set(input);
	}
	
	public static void setOutput(OutputStream output) {
		outputLocalThread.set(output);
	}
	
	public static InputStream getInput() {
		return inputLocalThread.get();
	}
	
	public static OutputStream getOutput() {
		return outputLocalThread.get();
	}

}
