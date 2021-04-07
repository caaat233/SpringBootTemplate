package com.springboottemplate.mysql;

public class User2 {

	long id;


	long sid;

	String name;
	String sex;

	int age;
	String job;

	String username;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User2{" +
				"id=" + id +
				", sid=" + sid +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				", job='" + job + '\'' +
				'}';
	}
}
