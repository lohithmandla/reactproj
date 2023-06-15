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
public class Charges {

	@Id
	private String proCategory;
	private Double discount;
	private Double gst;
	private Double delCharges;
}
