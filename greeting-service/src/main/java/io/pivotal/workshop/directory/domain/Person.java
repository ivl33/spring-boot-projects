package io.pivotal.workshop.directory.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class Person {

	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

	private String id;

	@NotNull
	private String name;

	@NotNull
	private String email;

	@NotNull
	private String password;

	private Date birthdayDate;

	private Date createdDate;

	private Date modifiedDate;

	public Person() {
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.createdDate = new Date();
		this.modifiedDate = new Date();
	}

	public Person(String name, String email, String password, Date birthdayDate) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthdayDate = birthdayDate;
	}

//	public SimpleDateFormat getDate() {
//		return date;
//	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}
}
