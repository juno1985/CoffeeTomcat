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
		//����һ���µı�����Ϊ��this.socket��assign���ֿ��Ը�ֵ��
		Object object = this.socket;
		notifyAll();
		return object;
	}

}
