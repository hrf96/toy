package org.hanrunfan.owner;

import java.util.List;

import org.hanrunfan.owner.service.WordService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boot {
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {
		printAWordRandom();
	}

	
	
	public static void printAllWords(){
		WordService wordService= getWordService();
		List<String> wordList = wordService.listAll();
		for(String word:wordList){
			System.out.println(word);
		}
	}
	
	public static void printAWordRandom(){
		WordService wordService= getWordService();
		String word = wordService.getWordRandom();
		System.out.println(word);
	}
	
	public static WordService getWordService(){
		return (WordService)getApplicationContext().getBean("wordService");
	}
	
	public static ApplicationContext getApplicationContext(){
		if(applicationContext==null){
			applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		}
		return applicationContext;
	}
}
