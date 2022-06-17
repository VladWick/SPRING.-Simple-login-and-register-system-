package com.vladwick.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladwick.model.TransferLog;
import com.vladwick.repository.TransferLogRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "/logs", tags = "logs", description = "Information about existing transfers")
public class Logs {
	
	@Autowired
	private TransferLogRepository transferLogRepository;
	
	@ApiOperation(value = "Get all transfers", notes = "Returns all transfers")
	@GetMapping("/logs")
	public ResponseEntity<List<TransferLog>> allTranfers(){
		return ResponseEntity.ok(transferLogRepository.findAll());
	}
	
	
}
