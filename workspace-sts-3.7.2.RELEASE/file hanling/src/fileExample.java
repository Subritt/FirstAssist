import java.io.File;

public class fileExample {

	public static void main(String[] args) {
		
		// Initiate File
		File file = new File("E:\\stud.txt") ;
		
		// Check if above path us Directory ?
		boolean isDirectory = file.isDirectory();
		System.out.println("stud.txt is directory : " + isDirectory );
		
		// File exist or not
		boolean isFileExists = file.exists();
		System.out.println("File exists : " + isFileExists);
		
		// Create Directory
		File fdir = new File("E:\\Java Training") ;
		boolean dirCreated = fdir.mkdir() ;
		if( dirCreated ){
			System.out.println("Java Training successfully created. ");
		}
		
		// List name of  all files in the directory
		String[] fileNames = fdir.list() ;
		for( String fileName: fileNames ) {
			System.out.println( fileName);
		}
		
		// List of files with location 
		File[] files = fdir.listFiles();
		for( File file2: files ){
			System.out.println(file2.getAbsolutePath() + " " +file2.isDirectory());
		}
	}
}
