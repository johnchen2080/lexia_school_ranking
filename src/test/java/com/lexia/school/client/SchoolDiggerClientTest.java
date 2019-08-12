package com.lexia.school.client;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TestPropertySource(locations="classpath:application.properties")
public class SchoolDiggerClientTest {
	
	@Autowired
	ApplicationContext context;
	
	
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	@Test
	public void contextLoads() {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Execution of Junit test done.");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSchools() {
		
		String state= "MA";
		int ranking_year = 2018;
		
		SchoolDiggerClient schoolDiggerClient=	context.getBean(SchoolDiggerClient.class);
		
		schoolDiggerClient.getSchools(state, ranking_year);
	}

}
