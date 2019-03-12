package com.su.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.su.vo.SendMessage;

public interface SendMessageDao {

	public void insert(SendMessage send);
	
	public List<SendMessage> getSendMessge(Map<String,Object> map);
	public SendMessage sendMessgeDetail(@Param("sendId")Integer sendId,@Param("empId")Integer empId);
	
	public void updateSendMessageState(Integer[] sendId);
}
