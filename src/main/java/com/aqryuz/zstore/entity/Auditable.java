package com.aqryuz.zstore.entity;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Where(clause = "DELETED = true")
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class Auditable{
	@CreatedBy
	@ManyToOne(optional = false)
    @JoinColumn(name="created_by", nullable=false)
	protected User createdBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@LastModifiedBy
	@ManyToOne(optional = false)
    @JoinColumn(name="last_modified_by", nullable=false)
	protected User lastModifiedBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;

	protected boolean deleted = false;

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted() {
		this.deleted = true;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}


	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



}
