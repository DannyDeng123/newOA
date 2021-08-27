package com.deng.newOA.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "claim_voucher_item")
public class ClaimVoucherItem {
	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long itemId;
	
	@Column(nullable = false)
	private String item;
	
	@Column(nullable = false)
	private String comment;
	
	@Column(nullable = false)
	private long amount;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
	private ClaimVoucher claimVoucher;
}
