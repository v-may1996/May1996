package com.nals.restapi.demo.workmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_work")
public class Work {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name_work")
	private String nameWork;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "status_id")
	private String status;	

	public long getId() {
		return id;
	}
	
	public Work() {
		
	}

	public Work(String nameWork, Date startDate, Date endDate, String status) {
		super();
		this.nameWork = nameWork;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameWork() {
		return nameWork;
	}

	public void setNameWork(String nameWork) {
		this.nameWork = nameWork;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatusId() {
		return status;
	}

	public void setStatusId(String status) {
		this.status = status;
	}
	

}
