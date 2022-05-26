package com.vladwick.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vladwick.model.TransferBalance;
import com.vladwick.service.TransferService;

@Controller
@RequestMapping("/api/v1")
public class TransferApiController {
	
	@Autowired
	private TransferService transferService;
	
	@GetMapping("/transfer")
	public ResponseEntity<List<BigDecimal>> getBalances() {
		return ResponseEntity.ok(transferService.getBalances());
	}
	
	@GetMapping("transfer/{accountId}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long accountId) {
		return ResponseEntity.ok(transferService.getBalance(accountId));
    }

    @PostMapping("transfer/add")
    public ResponseEntity<BigDecimal> addMoney(@RequestBody TransferBalance transferBalance) {
    	return ResponseEntity.ok(transferService.addMoney(transferBalance.getTo(), transferBalance.getAmount()));
    }

    @PostMapping("transfer/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance) {
    	transferService.makeTransfer(transferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return "MAMA, YA SLOMALSYA";
    }
    
}
