package org.hanrunfan.owner.dao.impl;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.hanrunfan.owner.dao.WordDAO;
import org.hanrunfan.owner.util.FileUtil;

public class TxtWordDAOImpl implements WordDAO {

	public List<String> list() {
		InputStream inputStream = this.getClass().getResourceAsStream("/repository.txt");
		String[] wordArray = FileUtil.read(inputStream).split(",");
		return Arrays.asList(wordArray);
	}
	

	public void add(String word) {
		
	}

}
