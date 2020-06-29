package com.file.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


import com.file.bo.FileHandlerBO;
import com.file.boimpl.FileHandlerBoImpl;
import com.file.model.FileHandler;

public class FileHandlerMain {
public static void main(String[] args) throws IOException
	{
		System.out.println("Welcome to your File Handler");
		Scanner sc = new Scanner(System.in);
		FileHandlerBO fileBO = new FileHandlerBoImpl() ;
		int ch = 0;
		int ch1 = 0;
		do {
			System.out.println("1. View Existing Files");
			System.out.println("2. Create & Modify file");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			ch = Integer.parseInt(sc.nextLine());
			
			switch(ch) {
			case 1:
				System.out.println("List of exisiting files");
				List<FileHandler> fileHandlerList = fileBO.getAllFiles();
//				for (FileHandler h1 : fileHandlerList) {
//					System.out.println(h1);
//				}
				break;
				
			case 2:
				do {
					System.out.println("------------------------");
					System.out.println("File Handling Menu");
					System.out.println("------------------------");
					System.out.println("1. create file");
					System.out.println("2. Read file");
					System.out.println("3. Write file");
					System.out.println("4. Append file");
					System.out.println("5. Delete file");
					System.out.println("6. Search by name");
					System.out.println("7. Return to the main menu");
					//System.out.println("5. Size of the file");
//					System.out.println("5. Get file by name");
//					System.out.println("6. Get all files");
//					System.out.println("7.Exit");
					System.out.println("Enter your choice");
					ch1 = Integer.parseInt(sc.nextLine());
					
					switch(ch1) {
					
					case 1:
						
						System.out.println("Enter the file name");
						String name1 = sc.nextLine();
						FileHandler file1 = new FileHandler(name1);
						file1 = fileBO.createFile(file1);
						break;
						
					case 2:
						
						System.out.println("Enter the file name");
						String name2 = sc.nextLine();
						FileHandler file2 = new FileHandler(name2);
						file2 = fileBO.readFile(file2);
						break;
						
					case 3:
						
						System.out.println("Enter the file name");
						String name3 = sc.nextLine();
						
						System.out.println("Enter your message");
						String message = sc.nextLine();
						
						FileHandler file3 = new FileHandler(name3);
						file3 = fileBO.writeFile(file3,message);
						break;
						
					case 4:
						
						System.out.println("Enter the file name");
						String name4 = sc.nextLine();
						FileHandler file4 = new FileHandler(name4);
						System.out.println("Enter your message");
						String message4 = sc.nextLine();
						file4 = fileBO.appendFile(file4,message4);
						break;
					
					case 5:
						
						System.out.println("Enter the file name");
						String name5 = sc.nextLine();
						FileHandler file5 = new FileHandler(name5);
						fileBO.deleteFile(file5);
						break;
						
					case 6:
						System.out.println("Enter the file name");
						String name6 = sc.nextLine();
						FileHandler file6 = new FileHandler(name6);
						fileBO.searchByName(file6);
						break;
						
					case 7:
						System.out.println("Return to main menu");
						break;
						
					}
				}while(ch1!=7);
				break;
				
			case 3:
				System.out.println("Thank you for using the app!");
				break;
			}
			
		}while(ch!=3);
		
	}
}
