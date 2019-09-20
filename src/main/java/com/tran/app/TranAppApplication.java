package com.tran.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.tran.app.model.BankAccount;
import com.tran.app.model.User;
import com.tran.app.model.Wallet;
import com.tran.app.repository.BankAccountRepository;
import com.tran.app.repository.UserRepository;
import com.tran.app.repository.WalletRepository;

@SpringBootApplication
public class TranAppApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BankAccountRepository bankRepository;
	@Autowired
	private WalletRepository walletRepository;

	public static void main(String[] args) {
		SpringApplication.run(TranAppApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TranAppApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		bankRepository.deleteAll();
		userRepository.deleteAll();
		walletRepository.deleteAll();

		User user1 = new User(1, "Subhas Kumar", "subhas@gmail.com");
		User user2 = new User(2, "Arun Pasha", "arun@gmail.com");
		User user3 = new User(3, "Sourav Sinha", "sourav@gmail.com");
		User user4 = new User(4, "Maya Chinnu", "maya.c@gmail.com");

		BankAccount bank1 = new BankAccount(1111, 60000d, 1);
		BankAccount bank2 = new BankAccount(1112, 65000d, 2);
		BankAccount bank3 = new BankAccount(1113, 77000d, 3);
		BankAccount bank4 = new BankAccount(1114, 33000d, 4);

		Wallet wallet1 = new Wallet(1, 0d, 1);
		Wallet wallet2 = new Wallet(2, 0d, 2);
		Wallet wallet3 = new Wallet(3, 0d, 3);
		Wallet wallet4 = new Wallet(4, 0d, 4);

//		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		List<BankAccount> bankAccList = new ArrayList<BankAccount>();
		bankAccList.add(bank1);
		bankAccList.add(bank2);
		bankAccList.add(bank3);
		bankAccList.add(bank4);

		List<Wallet> walletList = new ArrayList<Wallet>();
		walletList.add(wallet1);
		walletList.add(wallet2);
		walletList.add(wallet3);
		walletList.add(wallet4);

		userRepository.insert(userList);
		bankRepository.insert(bankAccList);
		walletRepository.insert(walletList);

	}

}
