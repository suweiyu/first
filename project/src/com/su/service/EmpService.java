package com.su.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.su.dao.EmpDao;
import com.su.util.MybatisUtil;
import com.su.vo.Emp;

public class EmpService {
	
	public List<Map<String,Object>> getAllName(){
		List<Map<String,Object>> list=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			list=dao.getAllName();
		}
		return list;
	}
	
	public Emp getUser(String empNo,String password) {
		Emp emp=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			emp=dao.getUser(empNo, password);
		}
		return emp;
	}
	
	public List<Emp> getAllEmp(Map<String,Object> map){
		List<Emp> list=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			list=dao.getAllEmp(map);
		}
		return list;
	}
	
	public void deleteEmp(Integer[] empId) {
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			dao.deleteEmp(empId);
			session.commit();
		}
	}
	
	public List<String> getAllEmpType(){
		List<String> list=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			list=dao.getAllEmpType();
		}
		return list;
	}
	
	
	public List<String> getAllJob(){
		List<String> list=null;
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			list=dao.getAllJob();
		}
		return list;
	}
	
	public void addEmp(Emp emp) {
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			dao.addEmp(emp);
			session.commit();
		}
	}
	
	public Emp getEmpById(Integer empId) {
		Emp emp=new Emp();
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			emp=dao.getEmpById(empId);
		}
		return emp;
	}
	
	public void saveUpdateEmp(Emp emp) {
		try(SqlSession session=MybatisUtil.getSqlSession();){
			EmpDao dao=session.getMapper(EmpDao.class);
			dao.saveUpdateEmp(emp);
			session.commit();
		}
	}

}
