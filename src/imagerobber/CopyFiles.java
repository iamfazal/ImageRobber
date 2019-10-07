package imagerobber;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Stack;

public class CopyFiles {
	private String neglectPartition;


	public String getNeglectPartition() {
		return neglectPartition;
	}

	public void setNeglectPartition(String neglectPartition) {
		this.neglectPartition =new String(neglectPartition);

	}

	public Stack getPartition(File path){

		File[] file= path.listFiles();
		Stack<File> fileNamesRe = new Stack<File>();
		for(File fileName: file)
			if(!fileName.getName().equalsIgnoreCase(neglectPartition))
				fileNamesRe.push(fileName);

		return fileNamesRe;
	}

	
	public void copyImages(String paste,File root){
		try{
			File storedFiles [] =root.listFiles() ;
			for(File listFiles : storedFiles){
				if(listFiles.isDirectory()){
					copyImages(paste, listFiles);
				}
				else {
					if(listFiles.getName().substring(listFiles.getName().length()-4).equalsIgnoreCase(".jpg"))
						try { 
								File pasteHere= new File(paste+listFiles.getName());
								Files.copy(listFiles.toPath(), pasteHere.toPath(), StandardCopyOption.REPLACE_EXISTING);
						} catch (Exception e) {
							System.out.println(e);
						}
				}
			}
		}
		catch(Exception e){

		}
	}



	
}