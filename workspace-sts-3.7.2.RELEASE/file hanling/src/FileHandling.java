import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
	public static void main( String[] args) throws IOException{
		
//		FileOutputStream fout = new FileOutputStream("E:\\stud.txt");
//		String str = "Java developers in Nepal." ;
//		byte[] b = str.getBytes();
//		fout.write(b);
//		fout.close();
//		System.out.println("Information is added in the file.");
		
//		FileInputStream fin = new FileInputStream("E:\\rookie.txt") ;
//		BufferedInputStream bin = new BufferedInputStream(fin) ;
//		int i ;
//		while((i = bin.read()) != -1){
//			System.out.print((char)i);
//		}
//		bin.close();
//		fin.close();
		
		/*----FileWriter-----*/
		
		FileWriter fw = new FileWriter("E:\\fileWriter.txt") ;
		fw.write("Java developer of Nepal. \nRunning Chapter: File Handling, FileWriter.") ;
		fw.close() ;
		
		/*----FileReader----*/
		
		FileReader fr = new FileReader("E:\\fileWriter.txt") ;
		int j ;
		while((j = fr.read()) != -1){
			System.out.print((char)j);
		}
		fr.close();
		
	}

}
