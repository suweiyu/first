package com.su.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.su.dao.ReceiveMessageDao;
import com.su.dao.SendMessageDao;
import com.su.util.MybatisUtil;
import com.su.vo.ReceiveMessage;
import com.su.vo.SendMessage;

public class SendMessageService {
	public void sendMessage(SendMessage send,Integer[] empids) {
		try(SqlSession session=MybatisUtil.getSqlSession();){
			
			SendMessageDao dao=session.getMapper(SendMessageDao.class);
			ReceiveMessageDao dao1=session.getMapper(ReceiveMessageDao.class);
			
			dao.insert(send);
			for(Integer i:empids) {
				ReceiveMessage receive=new ReceiveMessage();
				receive.setSendId(send.getSendId());
				receive.setEmpId(i);
				dao1.insert(receive);
			}
			
			session.commit();
			
		}
	}
	
	public List<SendMessage> getSendMessge(Map<String,Object> map){
		List<SendMessage> list=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			
		SendMessageDao dao=session.getMapper(SendMessageDao.class);
			
			list=dao.getSendMessge(map);
			
		}
		return list;
	}
	
	public  List<SendMessage> updateSendMessageState(Integer[] sendId,Map<String,Object> map) {
		List<SendMessage> list=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			SendMessageDao dao=session.getMapper(SendMessageDao.class);
				dao.updateSendMessageState(sendId);
				list=dao.getSendMessge(map);
				session.commit();
			}
		return list;
	}
	
	public SendMessage sendMessgeDetail(Integer sendId,Integer empId) {
		SendMessage send=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			
			SendMessageDao dao=session.getMapper(SendMessageDao.class);
				send=dao.sendMessgeDetail(sendId, empId);
			}
		return send;
	}

}
