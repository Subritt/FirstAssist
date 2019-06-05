
public class TestSleepMethod1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i = 1 ; i < 5 ; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}
	
	public static void main(String[] args) {
		
		TestSleepMethod1 t1 = new TestSleepMethod1() ;
		TestSleepMethod1 t2 = new TestSleepMethod1() ;
		TestSleepMethod1 t3 = new TestSleepMethod1() ;

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t3.start();
	}
	
	

}
