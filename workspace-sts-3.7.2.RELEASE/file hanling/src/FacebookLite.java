
public class FacebookLite {

	public Integer Likes = 0 ;
	
	// set current page likes
	
	public FacebookLite(Integer Likes){
		
		this.Likes = Likes ;
		
	}
	
	//Synchronized method call solve problem of Multi_thread problem
	
	public synchronized void plusOne() throws InterruptedException{
		Likes ++ ;
		System.out.println(Thread.currentThread().getName() + "Likes: " + Likes);
		
		Thread.sleep(100) ;
	}
}
