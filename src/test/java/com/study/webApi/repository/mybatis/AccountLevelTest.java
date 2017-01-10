package com.study.webApi.repository.mybatis;

import javax.inject.Inject;

import com.study.webApi.repository.mybatis.impl.AccountLevelRepository;
import org.junit.Before;
import org.junit.Test;

import com.study.infrastructure.exception.DatabaseException;
import com.study.webApi.repository.mybatis.interf.IAccountLevelRepository;
import com.study.webApi.repository.pojo.AccountLevel;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
public class AccountLevelTest {
//	@Inject
	IAccountLevelRepository repository;
	
	@Before
	public void setUp() {
		repository = new AccountLevelRepository();
	}
	
	@Test
	public void testFindAcountLevel() {
		try {
			AccountLevel test = repository.find(111);
			assertEquals(test.getId().intValue(),111);
			assertEquals(test.getPoint(),10);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
}
