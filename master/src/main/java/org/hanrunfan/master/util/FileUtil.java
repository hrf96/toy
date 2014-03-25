package org.hanrunfan.master.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class FileUtil {
	/**
	 * @param sourcePath 例如：/repository-raw.txt
	 * @param targetPath 例如：/repository.txt
	 */
	public static void disposeRawFile(String sourceName,String targetName) {
		String sourcePath = File.separator + sourceName;
		String targetAbsolutePath = FileUtil.class.getResource(sourcePath).getPath().replace(sourceName, targetName);
		StringBuffer targetString = new StringBuffer();
		Reader reader = null;
		Writer writer = null;
		int readedChar;
		try {
			reader = new InputStreamReader(FileUtil.class.getResourceAsStream(sourcePath));
			while((readedChar = reader.read())!=-1){
				if(readedChar==10||readedChar==13){
					targetString.append("");
				}else if(readedChar==32){
					targetString.append(",");
				}else{
					targetString.append((char)readedChar);
				}
			}
			File targetFile = new File(targetAbsolutePath);
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
}
