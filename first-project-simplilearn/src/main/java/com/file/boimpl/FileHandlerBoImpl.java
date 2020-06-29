package com.file.boimpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.file.bo.FileHandlerBO;
import com.file.model.FileHandler;

public class FileHandlerBoImpl implements FileHandlerBO {

	private static Map<String, FileHandler> fhMap = new Hashtable<String, FileHandler>();
	
	public FileHandler createFile(FileHandler file) throws FileNotFoundException {
		System.out.println("creating file");
		File filename = new File(file.getName());
		String name = file.getName();
		try
		{
			
			 boolean check = filename.createNewFile();
		     if (check){
		          System.out.println("File has been created successfully");
		          fhMap.put(name, file);
		     }
		     else{
		          System.out.println("File already present at the specified location");
		     }
		}
		catch(Exception e){
			System.out.println(e);
		
	}
		return null;
	}

	public FileHandler readFile(FileHandler file) throws IOException {
		System.out.println("reading file contents");
		File filename = new File(file.getName());
		if(!filename.exists())
		{
			System.out.println("File does not exist");
		}
		else{
			FileInputStream fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			StringBuilder sb = new StringBuilder();
			
				
				try {
					if(bis.available() == 0)
					{
						System.out.println("File is empty");
					}
					while (bis.available() != 0) {
						sb.append((char) bis.read());
					}
					
					
					//System.out.println(sb.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						bis.close();
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(sb.toString());
				
		}
		 
		return null;
	}

	public FileHandler writeFile(FileHandler file, String message) {
		System.out.println("writing file");
		File filename = new File(file.getName());
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		if(!filename.exists())
		{
			System.out.println("File does not exist");
			
		}
		else {
			String msg = message;
			byte b[]=msg.getBytes();
			try {
				fos=new FileOutputStream(filename);
				bos=new BufferedOutputStream(fos);
				bos.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					bos.flush();
					bos.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}

	public FileHandler appendFile(FileHandler file, String message) {
		System.out.println("appending to existing content of the file");
		File filename = new File(file.getName());
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		if(!filename.exists())
		{
			System.out.println("File does not exist");
			
		}
		else {
			String msg = message;
			byte b[]=msg.getBytes();
			try {
				fos=new FileOutputStream(filename, true);
				bos=new BufferedOutputStream(fos);
				bos.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					bos.flush();
					bos.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public void deleteFile(FileHandler file)
	{
		
		      try{
		        
		    	  System.out.println("deleting file ");
		  		File filename = new File(file.getName());
		  		if(!filename.exists())
		  		{
		  			System.out.println("File does not exist");
		  		}
		  		else{
		  			if(filename.delete()){
			    	    System.out.println(file.getName() + " is deleted!");
		  			}
			       }
		      }catch(Exception e){
			           System.out.println("Exception occurred");
			    	   e.printStackTrace();
			    	}
		      
		      
		  		}
	
	public void searchByName(FileHandler file)

	{
		System.out.println("checking for the file");
		File filename = new File(file.getName());
		String name = file.getName();
		if(!filename.exists())
		{
			System.out.println("File does not exist");
		}
		else {
			
				System.out.println("File exist");
			
		}
	}

	
	public FileHandler getFileBySize(FileHandler file) {
		System.out.println("check file size");
		return null;
	}

	public FileHandler getByName(String name) {
		System.out.println("Get by name");
		return null;
	}

	public List<FileHandler> getAllFiles() {
		System.out.println("getting all files");
		File filename = new File("C:\\Users\\dhwaniprincess\\Desktop\\SimpliLearn BNP\\Live-Class Notes\\bnp_simplilearn(24-06-2020)\\first-project-simplilearn");
		if(!filename.exists())
		{
			System.out.println("File does not exist");
		}
//		else {
//			List<String> fhList = new ArrayList<>(fhMap.keySet());
//			for(int i = 0; i <fhList.size();i++) {
//				System.out.println(i);
		ArrayList<String> l = new ArrayList<String>(); 
		
		
		String[] s = filename.list();
		
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
		
			
//		}
		return null;
	}
	
}
