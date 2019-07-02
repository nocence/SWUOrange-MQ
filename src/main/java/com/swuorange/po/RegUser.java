package com.swuorange.po;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class RegUser {
	
	private int user_id;
	private String account;
	private String tel;
	private String password;
	private String email;
	private String realname;
	private Timestamp regist_time;	
	private Timestamp update_time;
	private BigDecimal total_account;
	private BigDecimal balance;
	private int role_id;
	private int companyinfo_id;
	
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Timestamp getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Timestamp regist_time) {
		this.regist_time = regist_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public BigDecimal getTotal_account() {
		return total_account;
	}
	public void setTotal_account(BigDecimal total_account) {
		this.total_account = total_account;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getCompanyinfo_id() {
		return companyinfo_id;
	}
	public void setCompanyinfo_id(int companyinfo_id) {
		this.companyinfo_id = companyinfo_id;
	}
	
	
	
	
	
	
	
	
}
