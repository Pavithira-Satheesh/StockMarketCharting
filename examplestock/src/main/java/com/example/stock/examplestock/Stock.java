package com.example.stock.examplestock;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Stock {
	public String c_code;
	public String s_exc;
	public Integer c_price;
	public Date s_date;
	public Date s_time;
	
	
	public String getC_code() {
		return c_code;
	}
	public void setC_code(String c_code) {
		this.c_code = c_code;
	}
	public String getS_exc() {
		return s_exc;
	}
	public void setS_exc(String s_exc) {
		this.s_exc = s_exc;
	}
	
	public Integer getC_price() {
		return c_price;
	}
	public void setC_price(Integer c_price) {
		this.c_price = c_price;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getS_time() {
		return s_time;
	}
	public void setS_time(Date s_time) {
		this.s_time = s_time;
	}
	

}


