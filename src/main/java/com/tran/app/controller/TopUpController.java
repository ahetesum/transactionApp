package com.tran.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tran.app.model.BankAccount;
import com.tran.app.model.Wallet;
import com.tran.app.repository.BankAccountRepository;
import com.tran.app.repository.UserRepository;
import com.tran.app.repository.WalletRepository;
import com.tran.app.service.TopUpTransactionService;

@RestController
@RequestMapping("/api")
public class TopUpController {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private TopUpTransactionService topUpService;
	
	@GetMapping("/wallet")
	public Wallet getWallet(@RequestParam int id)
	{
		return walletRepository.findById(id).get();
	}
	
	@GetMapping("/recharge")
	public String recharge(@RequestParam int id, @RequestParam int amount)
	{
		int value=topUpService.topUpPerform(id,amount);
		if(value==-1)
		{
			return  "Insuficient Balance ";

		}
		else
		{
			return value+" Added in your Wallet";

		}
		
		
	}
	

}
