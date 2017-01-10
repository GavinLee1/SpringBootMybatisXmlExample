package com.study.webApi.mybatis.interf;

import com.study.infrastructure.exception.DatabaseException;
import com.study.infrastructure.repositroy.IRepository;
import com.study.webApi.repositroy.pojo.AccountLevel;

public interface IAccountLevelRepositroy extends IRepository<AccountLevel, Integer>{
	AccountLevel init(int id) throws DatabaseException;
}
