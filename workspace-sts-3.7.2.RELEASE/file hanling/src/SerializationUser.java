import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationUser {

	public static void main(String[] args) throws IOException {
		
		User usr = new User( 1, "Ghane", "bicchhu") ;
		
		File file = new File("E:\\User.txt") ;
		FileOutputStream fos = new FileOutputStream(file) ;
		
		ObjectOutputStream out = new ObjectOutputStream(fos) ;
		
		out.writeObject(usr);
		out.flush() ;
		out.close();
		
		System.out.println("User object is saved in file " + file.getAbsolutePath());
		
	}
}
