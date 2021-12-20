package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.findById;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.AccountTypeListRestModel;
import com.appsdeveloperblog.photoapp.api.account.persistance.AccountTypeRepository;

@Component
public class FindAccountTypesByIdQueryHandler {

	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public FindAccountTypesByIdQueryHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@QueryHandler
	public AccountTypeListRestModel findAccountTypeById(FindAccountTypesByIdQuery findAccountTypesByIdQuery) {
		AccountType accountType = this.accountTypeRepository.getById(findAccountTypesByIdQuery.getAccountTypeId());
		AccountTypeListRestModel accountTypeListRestModel = new AccountTypeListRestModel();
		BeanUtils.copyProperties(accountType, accountTypeListRestModel);
		return accountTypeListRestModel;
	}
	
	
}
