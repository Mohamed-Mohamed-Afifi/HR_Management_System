package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.main.controller.EmployeeController;

//import com.example.Orders;
@SpringBootApplication
@ComponentScan("com.example")
public class OrdersManagementSystemApplication {
	public static void main(String[] args) {
		var ctx=SpringApplication.run(OrdersManagementSystemApplication.class, args);
		Department dept=ctx.getBean(Department.class);
		dept.deptOrders();
		dept.getEnv();
//        EmployeeController emp=ctx.getBean(EmployeeController.class);
//        emp.getEmployeeCount();
	}


}
