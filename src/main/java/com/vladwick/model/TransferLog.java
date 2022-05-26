package com.vladwick.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transfers")
public class TransferLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transferId;
	
	@Column(name="transferFrom")
	private Long transferFrom;
	
	@Column(name="transferTo")
	private Long transferTo;
	
	@Column(name="transferAmount")
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
