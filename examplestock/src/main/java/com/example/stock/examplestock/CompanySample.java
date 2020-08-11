package com.example.stock.examplestock;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanySample {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer Id;
	public String c_name;
	public String t_over;
	public String ceo;
	public String director;
	public String stock;
	public String sector;
	public String descr;
	public Integer s_code;
	
	
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
	public String getT_over() {
		return t_over;
	}
	public void setT_over(String t_over) {
		this.t_over = t_over;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Integer getS_code() {
		return s_code;
	}
	public void setS_code(Integer s_code) {
		this.s_code = s_code;
	}
	
	
}

