
public class SynchronizeFbLike {

	public static void main(String[] args) {
		
		// Facebook Page: Everest, Current Likes: 0
		final FacebookLite everestFbPagePiclike = new FacebookLite(0) ;
		
		Thread user1 = new Thread() {
			public void run(){
				try {
					everestFbPagePiclike.plusOne() ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
		};
		
		Thread user2 = new Thread() {
			public void run(){
				try {
					everestFbPagePiclike.plusOne() ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
		};
		
		Thread user3 = new Thread() {
			public void run(){
				try {
					everestFbPagePiclike.plusOne() ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
		};
		
		Thread user4 = new Thread() {
			public void run(){
				try {
					everestFbPagePiclike.plusOne() ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
		};
		
		user1.start();
		user2.start();
		user3.start();
		user4.start();
	}
}
