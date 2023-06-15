package com.restcalls;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {

	@Id
	private Integer proId;
	private String proName;
	private String proType;
	private String proCategory;
	private Double proPrice;
}
