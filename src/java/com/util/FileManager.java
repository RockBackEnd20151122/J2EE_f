package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	private String nasPath;

	public List<String> uploadFileList(List<File> files,
			List<String> filesFileName, List<String> fileContentType)
			throws IOException {
		List<String> filesNameList = new ArrayList<String>();
		InputStream inputStream;
		File destFile;
		OutputStream os;
		if (files != null && files.size() > 0) {
			inputStream = new FileInputStream(files.get(0));
			destFile = new File(nasPath, filesFileName.get(0));
			os = new FileOutputStream(destFile);
			byte[] buffer = new byte[2048];
			int length = 0;
			while ((length = inputStream.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			inputStream.close();
			os.close();
			filesNameList.add(filesFileName.get(0));
		}
		return filesNameList;
	}

	public String getNasPath() {
		return nasPath;
	}

	public void setNasPath(String nasPath) {
		this.nasPath = nasPath;
	}
	
	
}
