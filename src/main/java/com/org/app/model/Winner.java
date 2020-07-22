package com.org.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Winner")
public class Winner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long winnerId;
	@ManyToOne
	private Employee employee;
	@Column
	private Date winningDate;

	public Winner() {}

	/**
	 * @param employee
	 * @param winningDate
	 */
	public Winner(Employee employee, Date winningDate) {
		this.employee = employee;
		this.winningDate = winningDate;
	}

	/**
	 * @return the winnerId
	 */
	public Long getWinnerId() {
		return winnerId;
	}

	/**
	 * @param winnerId the winnerId to set
	 */
	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the winningDate
	 */
	public Date getWinningDate() {
		return winningDate;
	}

	/**
	 * @param winningDate the winningDate to set
	 */
	public void setWinningDate(Date winningDate) {
		this.winningDate = winningDate;
	}

	@Override
	public String toString() {
		return "Winner [winnerId=" + winnerId + ", employee=" + employee + ", winningDate=" + winningDate + "]";
	}
	
	

}
