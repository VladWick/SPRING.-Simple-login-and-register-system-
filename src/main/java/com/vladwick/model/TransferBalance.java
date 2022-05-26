package com.vladwick.model;

import java.math.BigDecimal;

public class TransferBalance { 
	
    private Long from;
    private Long to;
    private BigDecimal amount;
    
    public TransferBalance() {
    	
    }
	public TransferBalance(Long from, Long to, BigDecimal amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	}
	public Long getFrom() {
		return from;
	}
	public void setFrom(Long from) {
		this.from = from;
	}
	public Long getTo() {
		return to;
	}
	public void setTo(Long to) {
		this.to = to;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
