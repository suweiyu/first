package com.su.vo;

import java.sql.Date;
import java.util.List;

public class SendMessage {
	Integer sendId;
	List<ReceiveMessage> receive;

	public List<ReceiveMessage> getReceive() {
		return receive;
	}
	public void setReceive(List<ReceiveMessage> receive) {
		this.receive = receive;
	}
	public Integer getSendId() {
		return sendId;
	}
	@Override
	public String toString() {
		return "SendMessage [sendId=" + sendId + ", empId=" + empId + ", messageTitle=" + messageTitle
				+ ", messageContent=" + messageContent + ", createDate=" + createDate + ", priority=" + priority
				+ ", messageState=" + messageState + "]";
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
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getMessageState() {
		return messageState;
	}
	public void setMessageState(Integer messageState) {
		this.messageState = messageState;
	}
	Integer empId;
	String messageTitle;
	String messageContent;
	Date createDate;
	Integer priority;
	Integer messageState;

}
