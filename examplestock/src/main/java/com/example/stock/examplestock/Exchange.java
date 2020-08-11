package com.example.stock.examplestock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exchange {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer Id;
	public String s_exg;
	public String brief;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getS_exg() {
		return s_exg;
	}
	public void setS_exg(String s_exg) {
		this.s_exg = s_exg;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String address;
	public String remarks;

}
