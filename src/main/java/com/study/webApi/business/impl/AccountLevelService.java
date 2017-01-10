package com.study.webApi.business.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.study.infrastructure.exception.DatabaseException;
import com.study.webApi.business.interf.IAccountLevelService;
import com.study.webApi.business.message.GetAccountLevelReq;
import com.study.webApi.business.message.ResponseWrapper;
import com.study.webApi.repository.mybatis.interf.IAccountLevelRepository;
import com.study.webApi.repository.pojo.AccountLevel;

@Service
public class AccountLevelService implements IAccountLevelService {

	private static final Logger log = LoggerFactory.getLogger(AccountLevelService.class);
	
	@Inject IAccountLevelRepository repository;
	@Override
	public ResponseWrapper<AccountLevel> findAccountLevel(GetAccountLevelReq req) {
		ResponseWrapper<AccountLevel> response = null;
		try {
			AccountLevel result = repository.find(req.getId());
			if(result != null) {
				response = new ResponseWrapper<AccountLevel>(result);
			}else {
				response = ResponseWrapper.ERROR_RESPONSE();
			}
		} catch (DatabaseException e) {
			response = ResponseWrapper.ERROR_RESPONSE();
			log.debug("Did not find account-level with id [ "+req.getId()+" ]", e);
		}
		return response;
	}

}
