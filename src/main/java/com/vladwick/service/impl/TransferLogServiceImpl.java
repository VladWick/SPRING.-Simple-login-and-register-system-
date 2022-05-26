package com.vladwick.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vladwick.model.TransferLog;
import com.vladwick.repository.TransferLogRepository;
import com.vladwick.service.TransferLogService;

public class TransferLogServiceImpl implements TransferLogService {
	
	@Autowired
	private TransferLogRepository transferLogRepository;

	@Override
	public List<TransferLog> getAllTransfers() {
		return transferLogRepository.findAll();
	}

	@Override
	public TransferLog getTransferLogById(Long id) {
		return transferLogRepository.getById(id);
	}
	
	@Override
	public TransferLog addTransferLog(TransferLog transferLog) {
		return transferLogRepository.save(transferLog);
	}
	
	
}
