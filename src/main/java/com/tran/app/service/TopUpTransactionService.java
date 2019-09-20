package com.tran.app.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tran.app.model.BankAccount;
import com.tran.app.model.History;
import com.tran.app.model.Wallet;
import com.tran.app.repository.BankAccountRepository;
import com.tran.app.repository.HistoryRepository;
import com.tran.app.repository.WalletRepository;
//import static com.mongodb.client.model.Filters.eq;

@Service
public class TopUpTransactionService {

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private HistoryRepository historyRepository;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public int topUpPerform(int id, int amount) {

			

		BankAccount bankAccount = bankAccountRepository.getBankAccountByUserId(id);
		Wallet wallet = walletRepository.getWalletByUserId(id);

		if (bankAccount.getBalance() > amount) {
			bankAccount.setBalance(bankAccount.getBalance() - amount);
			Random random = new Random();
			History history = new History(random.nextInt(), amount, "Debit", id);
			wallet.setBalance(wallet.getBalance() + amount);

			try {


				 //Run As Transaction
				 historyRepository.insert(history);
				 walletRepository.save(wallet);
				 bankAccountRepository.save(bankAccount);


			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}

			return amount;
		}

		return -1;

	}
}
