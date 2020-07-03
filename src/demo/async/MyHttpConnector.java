package demo.async;

public class MyHttpConnector extends Thread {
	

	@Override
	public void run() {
		MyHttpProcessor processor = createProcessor();
		Object socket = new Object();
		processor.assign(socket);
	}
	
	private MyHttpProcessor createProcessor() {
		return new MyHttpProcessor();
	}

}
