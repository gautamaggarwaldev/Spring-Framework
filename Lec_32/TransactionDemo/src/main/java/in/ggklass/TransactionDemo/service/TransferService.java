package in.ggklass.TransactionDemo.service;

import in.ggklass.TransactionDemo.entity.Account;
import in.ggklass.TransactionDemo.entity.TransferRecord;
import in.ggklass.TransactionDemo.repository.AccountRepository;
import in.ggklass.TransactionDemo.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository,
                           TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void  transfer(Long fromTransactionId, Long toTransactionId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromTransactionId)
                .orElseThrow(()->new RuntimeException("User not found"));
        Account toAccount = accountRepository.findById(toTransactionId)
                .orElseThrow(()->new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
        toAccount.creditAccount(amount);

        transferRepository.save(new TransferRecord(
                fromTransactionId,
                toTransactionId,
                amount,
                LocalDate.now()
        ));
    }
}
