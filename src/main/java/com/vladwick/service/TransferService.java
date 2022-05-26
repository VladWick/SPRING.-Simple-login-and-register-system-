package com.vladwick.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladwick.model.TransferBalance;
import com.vladwick.model.TransferLog;
import com.vladwick.model.User;
import com.vladwick.repository.TransferLogRepository;
import com.vladwick.repository.TransferRepository;

@Service
public class TransferService {
	
	@Autowired
	private TransferRepository transferRepository;
		
	@Autowired 
	private TransferLogRepository transferLogRepository;
	
	@Autowired
	private UserService userService;
	
	public List<BigDecimal> getBalances(){
		return transferRepository.getBalances();
	}

	public BigDecimal getBalance(Long accountId) {
		BigDecimal balance = transferRepository.getBalanceForId(accountId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
	}

	public BigDecimal addMoney(Long to, BigDecimal amount) {
		BigDecimal currentBalance = transferRepository.getBalanceForId(to);
        if (currentBalance == null) {
        	transferRepository.save(to, amount);
            return amount;
        } else {
            BigDecimal updatedBalance = currentBalance.add(amount);
            transferRepository.save(to, updatedBalance);
            return updatedBalance;
        }
	}

	public void makeTransfer(TransferBalance transferBalance) {
		BigDecimal fromBalance = transferRepository.getBalanceForId(transferBalance.getFrom());
        BigDecimal toBalance = transferRepository.getBalanceForId(transferBalance.getTo());
        
        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException("User has no balance!");
        if (transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("Not enough money!");

        BigDecimal updatedFromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updatedToBalance = toBalance.add(transferBalance.getAmount());
        
        transferRepository.save(transferBalance.getFrom(), updatedFromBalance);
        transferRepository.save(transferBalance.getTo(), updatedToBalance);
        
        /* ----- ----- */
        
        TransferLog transferLog = new TransferLog(1L, transferBalance.getFrom(), transferBalance.getTo(), transferBalance.getAmount());
        transferLogRepository.save(transferLog);
        
        /* ----- ----- */
        
        User userFrom = transferRepository.getUserById(transferBalance.getFrom());
        User userTo = transferRepository.getUserById(transferBalance.getTo());
		userFrom.setBalance(updatedFromBalance);
		userTo.setBalance(updatedToBalance);

		userService.updateUser(userFrom);
		userService.updateUser(userTo);
	}
}
