package com.study.webApi.repository.mybatis.interf;

import com.study.infrastructure.exception.DatabaseException;
import com.study.infrastructure.repositroy.IRepository;
import com.study.webApi.repository.pojo.AccountLevel;

public interface IAccountLevelRepository extends IRepository<AccountLevel, Integer>{
	AccountLevel init(int id) throws DatabaseException;
}
