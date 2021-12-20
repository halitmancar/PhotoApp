package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountTypeRestModel {
	private String accountName;
	private double price;
	private String description;
}
