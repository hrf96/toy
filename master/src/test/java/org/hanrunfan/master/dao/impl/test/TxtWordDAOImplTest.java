package org.hanrunfan.master.dao.impl.test;

import junit.framework.TestCase;

import org.hanrunfan.master.util.FileUtil;

public class TxtWordDAOImplTest extends TestCase {

	public void testList() {
		FileUtil.disposeRawFile("repository-raw.txt","repository.txt");
	}

	public void testAdd() {
		fail("Not yet implemented");
	}

}
