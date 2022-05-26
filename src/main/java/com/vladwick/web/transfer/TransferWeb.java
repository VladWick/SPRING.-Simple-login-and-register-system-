package com.vladwick.web.transfer;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vladwick.model.TransferBalance;
import com.vladwick.model.UserRegistrationDto;
import com.vladwick.service.TransferService;
import com.vladwick.service.UserService;

@Controller
public class TransferWeb {
	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/transfer")
	public String transfer() {
		return "/transfer/transfer";
	}
	
	@GetMapping("/transfer/make_transfer")
	public String makeTransfer(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "/transfer/make_transfer";
	}
	
	@ModelAttribute("transferBalance")
	public TransferBalance userRegistrationDto() {
		return new TransferBalance();
	}
	
	@PostMapping("/transfer/make_transfer")
	public String makeTransfer(@ModelAttribute("transferBalance") TransferBalance transferBalance) {
		transferService.makeTransfer(transferBalance);
		return "redirect:/transfer/make_transfer?success";
	}
	
}
