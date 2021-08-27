package com.deng.newOA.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "process")
public class Process {
	@Id
	@GeneratedValue
	@Column(name = "p_id")
	private Long processId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deal_time", nullable = false)
	private Date dealTime;
	
	@Column(nullable = false)
	private String result;
	
	@Column
	private String comment;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
	private ClaimVoucher claimVoucher;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "handler_id", referencedColumnName = "uid")
	private Employee handler;
}
