package com.vladwick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vladwick.model.TransferLog;
import com.vladwick.repository.TransferLogRepository;

@Controller
@RequestMapping("/api/v1")
public class LogController {
	
	@Autowired
	private TransferLogRepository transferLogRepository;
	
	@GetMapping("/logs")
	public ResponseEntity<List<TransferLog>> allTranfers(){
		return ResponseEntity.ok(transferLogRepository.findAll());
	}
	
	
}
