package com.su.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.su.util.MybatisUtil;
import com.su.vo.ReceiveMessage;

public interface ReceiveMessageDao {
	public void insert(ReceiveMessage receive);
	
	public List<Map<String,Object>> getReceiveMessage(Map<String,Object> map);
	public Map<String,Object> getReceiveMessageDetail(@Param("receiveId")Integer receiveId);
	public void updateOpenDate(@Param("receiveId")Integer receiveId);
	public void delete(Integer[] receiveIds);
	
			
}
