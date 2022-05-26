package com.vladwick.service;

import java.util.List;

import com.vladwick.model.TransferLog;

public interface TransferLogService {
	
	public List<TransferLog> getAllTransfers();
	public TransferLog getTransferLogById(Long id);
	TransferLog addTransferLog(TransferLog transferLog);
	
}
