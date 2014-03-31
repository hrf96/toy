package org.hanrunfan.owner.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public static String read(Reader reader) {
		StringBuffer sb = new StringBuffer();
		try {
			char[] chars = new char[1024];
			while((reader.read(chars))!=-1){
				sb.append(chars);
			}
		} catch (IOException e) {
			e.printStackTrace();
			sb = new StringBuffer();
		}
		return sb.toString();
	}
	
	
}
