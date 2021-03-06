package com.aqryuz.zstore.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Where(clause = "DELETED = true")
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public class Auditable{
	@CreatedBy
	@ManyToOne(optional = false)
    @JoinColumn(name="created_by")
	protected User createdBy;

	@CreatedDate
//	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime createdDate;

	@LastModifiedBy
	@ManyToOne(optional = false)
    @JoinColumn(name="last_modified_by", nullable=false)
	protected User lastModifiedBy;

	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
	protected LocalDateTime lastModifiedDate;

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

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



}
