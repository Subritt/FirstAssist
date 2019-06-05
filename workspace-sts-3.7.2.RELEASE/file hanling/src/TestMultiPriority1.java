
public class TestMultiPriority1 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("running thread name is : " + Thread.currentThread().getName());
		System.out.println("running thread priority is : " + Thread.currentThread().getPriority());
		
	}

	public static void main(String[] args) {
		
		TestMultiPriority1 n1 = new TestMultiPriority1() ;
		TestMultiPriority1 n2 = new TestMultiPriority1() ;
		n1.setPriority(Thread.MIN_PRIORITY) ;
		n2.setPriority(Thread.MAX_PRIORITY);
		n1.start() ;
		n2.start();
		
	}
	
}
