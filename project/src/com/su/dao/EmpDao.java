package com.su.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.su.vo.Emp;

public interface EmpDao {
	public List<Map<String,Object>> getAllName();
	public Emp getUser(@Param("empNo")String empNo,@Param("password")String password);
	public List<Emp> getAllEmp(Map<String,Object> map);
	public void deleteEmp(Integer[] empId);
	public List<String> getAllEmpType();
	public List<String> getAllJob();
	public void addEmp(Emp emp);
	public Emp getEmpById(@Param("empId")Integer empId);
	public void saveUpdateEmp(Emp emp);
}
