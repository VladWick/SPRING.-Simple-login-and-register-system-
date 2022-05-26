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
	private Long id;
	
	@Column(name="from")
	private Long from;
	
	@Column(name="to")
	private Long to;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	public TransferLog() {
		
	}
	public TransferLog(Long from, Long to, BigDecimal amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	}
	public Long getTransferId() {
		return this.id;
	}
	public void setTransferId(Long transferId) {
		this.id = transferId;
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
