package demo.async;

public class MyHttpProcessor extends Thread {
	
	boolean available = false;
	Object socket = new Object();

	synchronized void assign(Object socket) {
		while(available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = true;
		this.socket = socket;
		notifyAll();
	}
	
	synchronized Object await() {
		
		while(!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		available = false;
		//返回一个新的变量，为了this.socket在assign中又可以赋值了
		Object object = this.socket;
		notifyAll();
		return object;
	}

}
