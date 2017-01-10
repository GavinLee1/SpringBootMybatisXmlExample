package com.study.webApi.repository.mybatis.impl;

import java.util.List;

import com.study.infrastructure.exception.DatabaseException;
import com.study.webApi.repository.mybatis.interf.IAccountLevelRepository;
import com.study.webApi.repositroy.pojo.AccountLevel;

import java.sql.Timestamp;

public class AccountLevelRepository extends Repository<AccountLevel, Integer> implements IAccountLevelRepository{

	protected AccountLevelRepository(Class<AccountLevel> typeClass, String columnName, String tableName) {
		super(typeClass, columnName, tableName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AccountLevel init(int id) throws DatabaseException {
		if(id < 0) {
			return null;
		}
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		AccountLevel entity = new AccountLevel(id, timeStamp, timeStamp, 0, 0);
		boolean success = false; //TODO: = this.create(entity);
		
		return success?entity:null;
	}
	
	protected Object[] getColumnValues(AccountLevel entity) {
		return new Object[] {
				entity.getId(),
				entity.getCreateTime(),
				entity.getUpdateTime(),
				entity.getLevel(),
				entity.getPoint()
		};
	}
	
	protected String[] getColumnNames(AccountLevel entity) {
		return new String[] {
				entity.COLUMN_ID,
				entity.COLUMN_CREATE_TIME,
				entity.COLUMN_UPDATE_TIME,
				entity.COLUMN_LEVEL,
				entity.COLUMN_POINT
		};
	}
}
