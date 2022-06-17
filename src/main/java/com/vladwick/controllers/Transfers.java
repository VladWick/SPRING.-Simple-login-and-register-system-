package com.vladwick.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladwick.model.TransferBalance;
import com.vladwick.service.TransferService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "/transfers", tags = "transfers", description = "Set of methods for managing transfers between users")
public class Transfers {
	
	@Autowired
	private TransferService transferService;
	
	@ApiOperation(value = "Get all transfers", notes = "Returns all transfers")
	@GetMapping("/transfers")
	public ResponseEntity<List<BigDecimal>> getBalances() {
		return ResponseEntity.ok(transferService.getBalances());
	}
	
	@ApiOperation(value = "Get transfer by id", notes = "Returns transfer by id")
	@GetMapping("/transfers/{accountId}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long accountId) {
		return ResponseEntity.ok(transferService.getBalance(accountId));
    }

	@ApiOperation(value = "Add money to the user", notes = "Returns money that needs to be added")
    @PostMapping("/transfers/add")
    public ResponseEntity<BigDecimal> addMoney(@RequestBody TransferBalance transferBalance) {
    	return ResponseEntity.ok(transferService.addMoney(transferBalance.getTo(), transferBalance.getAmount()));
    }

	@ApiOperation(value = "Transfer money from one user to another", notes = "Transfer money from one user to another")
    @PostMapping("/transfers/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance) {
    	transferService.makeTransfer(transferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return "MAMA, YA SLOMALSYA";
    }
    
}
