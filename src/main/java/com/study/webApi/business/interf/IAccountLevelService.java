package com.study.webApi.business.interf;

import com.study.webApi.business.message.GetAccountLevelReq;
import com.study.webApi.business.message.ResponseWrapper;
import com.study.webApi.repository.pojo.AccountLevel;

public interface IAccountLevelService {
	ResponseWrapper<AccountLevel> findAccountLevel(GetAccountLevelReq req);
}