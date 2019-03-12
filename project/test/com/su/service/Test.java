package com.su.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.su.vo.Emp;

class Test {
	static EmpService emp;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emp=new EmpService();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@org.junit.jupiter.api.Test
	void testGetUser() {
		Emp e=emp.getUser("1001", "888");
		Assert.assertNotNull(e);
		//Assert.assertNull(e);
		
	}

}
