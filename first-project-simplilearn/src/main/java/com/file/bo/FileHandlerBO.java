package com.file.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.file.model.FileHandler;

public interface FileHandlerBO {
	public FileHandler createFile(FileHandler file) throws FileNotFoundException;
	public FileHandler readFile(FileHandler file) throws FileNotFoundException, IOException;
	public FileHandler writeFile(FileHandler file, String message);
	public FileHandler appendFile(FileHandler file,String message);
	public void deleteFile(FileHandler file);
	public void searchByName(FileHandler file);
//	public FileHandler getFileBySize(FileHandler file);
//	public FileHandler getByName(String name);
	public List<FileHandler> getAllFiles();
	
}

