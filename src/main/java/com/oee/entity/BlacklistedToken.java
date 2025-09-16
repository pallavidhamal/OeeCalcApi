package com.oee.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "blacklisted_tokens")
public class BlacklistedToken {

	@Id
	@GeneratedValue(generator = "custom-generator", strategy = GenerationType.IDENTITY)
	@GenericGenerator(
			name = "custom-generator",
			strategy = "com.oee.entity.id.BaseIdentifierGenerator")
	protected String id;

    @Column(nullable = false, unique = true, length = 512)
    private String token;

    @Column(nullable = false)
    private Date expiryDate;
}