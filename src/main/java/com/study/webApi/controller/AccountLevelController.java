package com.study.webApi.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.webApi.business.interf.IAccountLevelService;
import com.study.webApi.business.message.GetAccountLevelReq;
import com.study.webApi.business.message.ResponseWrapper;
import com.study.webApi.repository.pojo.AccountLevel;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/account")
public class AccountLevelController extends BaseController {
	
	@Inject IAccountLevelService accountLevelService;
	
	@ApiOperation("Use an id to find an account level.  ")
	@RequestMapping(value = "/find-account-level", method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapper<AccountLevel> findAccountById(@RequestBody GetAccountLevelReq req) {
		return accountLevelService.findAccountLevel(req);  
	}
}
