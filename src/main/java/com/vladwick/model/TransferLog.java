package com.vladwick.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="transfers")
public class TransferLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Transfer ID", example = "1", required = true) 
	private Long transferId;
	
	@Column(name="transferFrom")
	@ApiModelProperty(notes = "Id of the user from which money was taken", example = "3", required = true) 
	private Long transferFrom;
	
	@Column(name="transferTo")
	@ApiModelProperty(notes = "Id of the user to which money was transfered", example = "1", required = true) 
	private Long transferTo;
	
	@Column(name="transferAmount")
	@ApiModelProperty(notes = "Amount of money that needs to be transfered", example = "100", required = true) 
	private BigDecimal amount;
	
	public TransferLog() {
		
	}
	public TransferLog(Long id, Long from, Long to, BigDecimal amount) {
		super();
		this.transferFrom = from;
		this.transferTo = to;
		this.amount = amount;
	}
	public Long getTransferId() {
		return this.transferId;
	}
	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}
	public Long getFrom() {
		return transferFrom;
	}
	public void setFrom(Long from) {
		this.transferFrom = from;
	}
	public Long getTo() {
		return transferTo;
	}
	public void setTo(Long to) {
		this.transferTo = to;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
