package org.hanrunfan.owner.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.hanrunfan.owner.dao.WordDAO;
import org.hanrunfan.owner.service.WordService;

public class TxtWordServiceImpl implements WordService {
	@Resource
	private WordDAO wordDAO; 
	public String getWordRandom() {
		List<String> wordList = wordDAO.list();
		Random random = new Random();
		int index = random.nextInt(wordList.size());
		return wordList.get(index);
	}
	
	public List<String> listAll(){
		return wordDAO.list();
	}

}
