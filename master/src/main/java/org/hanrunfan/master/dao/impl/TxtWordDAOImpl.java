package org.hanrunfan.master.dao.impl;

import java.io.InputStream;
import java.util.List;

import org.hanrunfan.master.dao.WordDAO;

public class TxtWordDAOImpl implements WordDAO {

	public List<String> list() {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("/repository.txt");
		return null;
	}
	

	public void add(String word) {
		// TODO Auto-generated method stub

	}

}
