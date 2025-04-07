package com.oee.entity.id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;


@MappedSuperclass
@Getter @Setter @ToString 
public abstract class BaseEntity {

	@Id
	@GeneratedValue(generator = "custom-generator", strategy = GenerationType.IDENTITY)
	@GenericGenerator(
			name = "custom-generator",
			strategy = "com.oee.entity.id.BaseIdentifierGenerator")
	protected String id;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false, nullable = false)
	protected Instant createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	protected Instant modifiedAt;

	@Column
	@Version
	protected int version;
	
	@Column(name = "is_deleted")
	protected String isdeleted;

	/**
	 * Indicates whether the object has already been persisted or not
	 *
	 * @return true if the object has not yet been persisted
	 */
	public boolean isNew() {
		return getId()==null;
	}
	
	@Column(name = "modified_by")
	protected String modifiedBy;
	
	@Column(name = "modified_from" , length = 500)
	protected String modifiedFrom;
	
	@Column(name = "created_by")
	protected String createdBy;
	
}