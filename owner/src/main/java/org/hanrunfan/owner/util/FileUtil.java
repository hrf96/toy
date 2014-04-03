package org.hanrunfan.owner.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class FileUtil {
	/**
	 * @param sourcePath 例如：C:\Users\hanrunfan\git\toy\master\src\main\resource\repository-raw.txt
	 * @param targetName 例如：repository.txt
	 */
	public static void disposeRawFile(String sourcePath,String targetName) {
		StringBuffer targetString = new StringBuffer();
		Reader reader = null;
		Writer writer = null;
		int readedChar;
		try {
			reader = new FileReader(new File(sourcePath));
			while((readedChar = reader.read())!=-1){
				if(readedChar==10||readedChar==13){
					targetString.append("");
				}else if(readedChar==32){
					targetString.append(",");
				}else{
					targetString.append((char)readedChar);
				}
			}
			File targetFile = new File(targetName);
			if(!targetFile.exists()){
				targetFile.createNewFile();
			}
			writer = new FileWriter(targetFile);
			writer.append(targetString);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(reader!=null){
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(writer!=null){
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	


	public static String read(InputStream inputStream) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			char[] chars = new char[1024];
			int readedSize = 0;
			while((readedSize = bufferedReader.read(chars))!=-1){
				sb.append(chars,0,readedSize);
			}
		} catch (IOException e) {
			e.printStackTrace();
			sb = new StringBuffer();
		}
		return sb.toString();
	}
	
	public static String read1(InputStream inputStream) {
		StringBuffer sb = new StringBuffer();
		try {
			byte[] bytes = new byte[1024];
			while((inputStream.read(bytes))!=-1){
				String string = new String(bytes,"UTF-8");
				sb.append(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
			sb = new StringBuffer();
		}
		return sb.toString();
	}

	
	
	
}
