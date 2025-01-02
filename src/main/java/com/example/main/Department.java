package com.example.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:custom.properties")
public class Department {
	
	@Value("${my.app.deptName}")
	private String deptName;
	
	@Value("${my.app.id}")
	private int deptId;
	
// Field injection
//@Autowired
//@Qualifier("secondOrder")
private Orders orders;

@Autowired
private Environment env;

// Method injection
//@Autowired
//public void injectDep(@Qualifier("secondOrder") Orders order) {
//	this.orders = order;
//}

// setter injection
//@Autowired
//public void setOrders(@Qualifier("secondOrder") Orders orders) {
//	this.orders = orders;
//}

// Constructor injection
Department(@Qualifier("secondOrder") Orders orders) {
	this.orders = orders;
}
//
public void deptOrders() {
	System.out.println("Department orders: "+orders.getOrders());
}

public void getEnv() {
	System.out.println("Department environment: " + env.getProperty("spring.application.name"));
	System.out.println(deptName + " " + deptId);
}

}
