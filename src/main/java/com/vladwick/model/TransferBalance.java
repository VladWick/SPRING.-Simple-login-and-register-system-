package com.vladwick.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class TransferBalance { 
	
	@ApiModelProperty(notes = "Id of the user from which money was taken", example = "1", required = true) 
    private Long from;
	
	@ApiModelProperty(notes = "Id of the user to which money was transfered", example = "3", required = true) 
    private Long to;
	
	@ApiModelProperty(notes = "Amount of money that needs to be transfered", example = "100", required = true) 
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
