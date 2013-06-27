package com.doucome.stockop.biz.core.model;

import com.doucome.stockop.biz.core.annotation.CPlusType;
import com.doucome.stockop.biz.core.annotation.Type;

public class Employee1 extends NativeStruct {

	@CPlusType(value=Type.STRING,length=20)
	private String name ;
	
	@CPlusType(Type.INT)
	private int id ;
	
	@CPlusType(Type.FLOAT)
	private float salary ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
}
