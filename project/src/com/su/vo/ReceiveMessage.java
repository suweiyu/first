package com.su.vo;

import java.sql.Date;

public class ReceiveMessage {
	Integer receiveId;
	Integer sendId;
	Integer empId;
	Integer messageState;
	Date openDate;
	Emp emp;
	
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Integer getReceiveId() {
		return receiveId;
	}
	@Override
	public String toString() {
		return "ReceiveMessage [receiveId=" + receiveId + ", sendId=" + sendId + ", empId=" + empId + ", messageState="
				+ messageState + ", openDate=" + openDate + "]";
	}
	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getMessageState() {
		return messageState;
	}
	public void setMessageState(Integer messageState) {
		this.messageState = messageState;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

}
