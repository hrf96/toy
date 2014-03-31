package org.hanrunfan.owner;

import org.hanrunfan.owner.service.WordService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boot {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		WordService wordService= (WordService)applicationContext.getBean("wordService");
		String word = wordService.getWordRamdom();
		System.out.println(word);
	}

}
