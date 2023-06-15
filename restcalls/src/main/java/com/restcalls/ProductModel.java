package com.restcalls;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

	private Integer proId;
	private String proName;
	private String proType;
	private String proCategory;
	private Double proPrice;
	private Double discount;
	private ProCharges charges;
	private Double fprice;
}
