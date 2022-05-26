package com.vladwick.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vladwick.model.User;
import com.vladwick.service.UserService;

@Repository
public class TransferRepository {
	
	@Autowired
	private UserService userService;
	
	public List<BigDecimal> getBalances(){
		List<BigDecimal> balances = new ArrayList<>();;
		for(User user : userService.getAllUsers()) {
			balances.add(user.getBalance());
		}
		return balances;
	}
	
	public BigDecimal getBalanceForId(Long accountId) {
		return userService.getUserById(accountId).getBalance();
	}

	public void save(Long id, BigDecimal updatedBalance) {
		userService.getUserById(id).setBalance(updatedBalance);
	}
	
}
