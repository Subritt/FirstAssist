
public class ThreadClass extends Thread {
	
	

	public static void main(String[] args) {
		
		
		
		ThreadClass t = new ThreadClass() ;
		t.start();
		System.out.println("ThreadClass : Main");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("ThreadClass>Run> Hello");
	}
}
