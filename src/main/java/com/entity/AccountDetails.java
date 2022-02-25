package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "accountinfo")
public class AccountDetails {
	
	@Id
	@GenericGenerator(name = "custom_account_number", strategy = "com.service.CustomIdGenerator")
	@GeneratedValue(generator = "custom_account_number")
	@Column(name="account_number")
	private Long accountNumber;
	private Long amount;
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private UserInfo userinfo;

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
