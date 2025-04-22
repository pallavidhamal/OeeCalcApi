package com.oee.entity;
import java.time.Instant;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "refreshtoken")
public class RefreshToken extends BaseEntity {

	
	  @OneToOne
	  @JoinColumn(name = "user_id", referencedColumnName = "id")
	  private UserInfoEntity user;

	  @Column(nullable = false, unique = true)
	  private String token;

	  @Column(name= "expiry_date", nullable = false)
	  private Instant expiryDate;
}
