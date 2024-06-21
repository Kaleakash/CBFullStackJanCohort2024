package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.AccountService;

@RestController
@RequestMapping("account")			// http://localhost:8383/account/*
public class AccountController {

	@Autowired
	AccountService accountService;
}
