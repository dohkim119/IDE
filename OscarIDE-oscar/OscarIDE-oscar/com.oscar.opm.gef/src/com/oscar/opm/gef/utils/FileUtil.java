package com.oscar.opm.gef.utils;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileUtil {
	public static final FileUtil INSTANCE = new FileUtil();
	
	private FileUtil() {}
	
	public File openFile() throws Exception {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		int returnValue = jfc.showOpenDialog(null);
		
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			return selectedFile;
		}
		else throw new FileNotFoundException();
	}
}
