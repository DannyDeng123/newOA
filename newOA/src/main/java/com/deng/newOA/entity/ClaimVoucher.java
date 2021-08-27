package com.deng.newOA.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "claim_voucher")
public class ClaimVoucher {
	@Id
	@GeneratedValue
	@Column(name = "cv_id")
	private Long cvId;
	
	@Column(nullable = false)
	private String title;
	
	@Column(name = "total_amount", nullable = false)
	private Long totalAmount;
	
	@Column(nullable = false)
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false)
	private Date createTime;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "creater_id", referencedColumnName = "uid")
	private Employee creater;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "next_signer_id", referencedColumnName = "uid")
	private Employee nextSigner;
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "item_id")
	private List<ClaimVoucherItem> items;
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "process_id")
	private List<Process> process;
}
