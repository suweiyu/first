package com.su.test;

import java.util.List;

import com.su.service.EmpService;

public class Test {

	public static void main(String[] args) {
		EmpService emp=new EmpService();
		List<String> list=emp.getAllEmpType();
		System.out.println(list);

	}

}
