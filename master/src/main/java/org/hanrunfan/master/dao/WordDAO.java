package org.hanrunfan.master.dao;

import java.util.List;

public interface WordDAO {
	public List<String> list();
	public void add(String word);
}
