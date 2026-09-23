package in.ggklass.TransactionDemo.service;

import in.ggklass.TransactionDemo.entity.Account;
import in.ggklass.TransactionDemo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }
}
