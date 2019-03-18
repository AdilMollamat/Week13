package com.selenium.customlibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TextFileManager {

	private String fileName;

	public TextFileManager(String filePathName) {
		fileName = filePathName;
	}

	public String readFile() {
		String finalText = null;
		String line = null;
		// reading the file
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			StringBuffer sb = new StringBuffer();
			while ((line = bufferReader.readLine()) != null) {
				sb.append(line);
			}
			finalText = sb.toString();
			bufferReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalText;
	}

	public void writeFile(String inputData) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(inputData);
			bufferWriter.close();
			System.out.println("File Created: " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		//TextFileManager txtmanager = new TextFileManager("target/data/testData1.txt");
		//txtmanager.writeFile("I like programming. because it is fun. and it makes me think more!");		
		
		TextFileManager txtmanager = new TextFileManager("target/data/testData1.txt");
		String msg = txtmanager.readFile();
		System.out.println("msg: " + msg);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
