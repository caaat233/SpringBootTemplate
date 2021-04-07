package com.springboottemplate.thread;

/**
 * 首先给出结论：t.join()方法只会使主线程(或者说调用t.join()的线程)进入等待池并等待t线程执行完毕后才会被唤醒。
 * 并不影响同一时刻处在运行状态的其他线程。
 */
public class TestJoin {
	public static void main(String[] args) {
		MyThread my=new MyThread();
		my.start();

		try {
			my.join();//把这个线程合并到主线程中
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		for(int i=0;i<10;i++) {
			System.out.println("i am 最主线程");
		}

	}

}
class MyThread extends Thread{

	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("i am"+getName());
			 yield();
			try {
				MyThread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}


	}


}
