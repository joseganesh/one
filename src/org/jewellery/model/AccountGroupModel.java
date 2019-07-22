package org.jewellery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="jewellery", name="accountgroup")
public class AccountGroupModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccountGroupId")
	private Integer AccountGroupId;
	
	@Column(name="AccountName")
	private String AccountName;

	@Column(name="Status")
	private String Status;
	
	@Column(name="AccountHead")
	private String AccountHead;
	
	@Column(name="GroupCode")
	private String GroupCode;
	
	@Column(name="Date")
	private Date date;

	public Integer getAccountGroupId() {
		return AccountGroupId;
	}

	public String getAccountName() {
		return AccountName;
	}

	public String getStatus() {
		return Status;
	}

	public String getAccountHead() {
		return AccountHead;
	}

	public String getGroupCode() {
		return GroupCode;
	}

	public Date getDate() {
		return date;
	}

	public void setAccountGroupId(Integer accountGroupId) {
		AccountGroupId = accountGroupId;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public void setAccountHead(String accountHead) {
		AccountHead = accountHead;
	}

	public void setGroupCode(String groupCode) {
		GroupCode = groupCode;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
