package com.su.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.su.dao.ReceiveMessageDao;
import com.su.dao.SendMessageDao;
import com.su.util.MybatisUtil;
import com.su.vo.ReceiveMessage;

public class ReceiveMessageService {
	public List<Map<String,Object>> getReceiveMessage(Map<String,Object> map){
		List<Map<String,Object>> list=null;
		
		try(SqlSession session=MybatisUtil.getSqlSession();){
	
				ReceiveMessageDao dao=session.getMapper(ReceiveMessageDao.class);
		
				list=dao.getReceiveMessage(map);				
		
		}
		return list;
		
	}

	
	public Map<String,Object> getReceiveMessageDetail(Integer receiveId){
		
		Map<String,Object> list=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			
			ReceiveMessageDao dao=session.getMapper(ReceiveMessageDao.class);
			dao.updateOpenDate(receiveId);
			list=dao.getReceiveMessageDetail(receiveId);
			session.commit();
	
		}
		return list;
	}
	
	public List<Map<String,Object>> delete(Integer[] receiveIds,Map<String,Object> map){
		List<Map<String,Object>> list=null;
		
		try(SqlSession session=MybatisUtil.getSqlSession();){
			
			ReceiveMessageDao dao=session.getMapper(ReceiveMessageDao.class);
			dao.delete(receiveIds);
			list=dao.getReceiveMessage(map);
			session.commit();
	
		}
		return list;
	}
}
