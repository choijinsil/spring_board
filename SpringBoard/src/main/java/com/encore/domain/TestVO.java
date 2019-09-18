package com.encore.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TestVO {
	private String name;// setName(request.getParameter("name"));
	private int age;// setAge(Integer.parseInt(request.getParameter("age")));
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cdate;// setCdate(request.getParameter("cdate"));

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "TestVO [name=" + name + ", age=" + age + ", cdate=" + cdate + "]";
	}

	
	
}
