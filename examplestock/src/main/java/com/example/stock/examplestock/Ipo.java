package com.example.stock.examplestock;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ipo {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer Id;
	public String c_name;
	public String s_exg;
	public Integer price;
	public Date o_date;
	public String remark;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getS_exg() {
		return s_exg;
	}
	public void setS_exg(String s_exg) {
		this.s_exg = s_exg;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getO_date() {
		return o_date;
	}
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
