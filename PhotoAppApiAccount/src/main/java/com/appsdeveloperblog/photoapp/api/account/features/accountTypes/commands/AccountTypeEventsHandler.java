package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create.AccountTypeCreatedEvent;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete.AccountTypeDeletedEvent;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update.AccountTypeUpdatedEvent;
import com.appsdeveloperblog.photoapp.api.account.persistance.AccountTypeRepository;

@Component
public class AccountTypeEventsHandler {
	private AccountTypeRepository accountTypeRepository;

	public AccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@EventHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		AccountType accountType = new AccountType();
		BeanUtils.copyProperties(accountTypeCreatedEvent, accountType);
		this.accountTypeRepository.save(accountType);
	}
	
	@EventHandler
	public void onDelete(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		AccountType accountType = this.accountTypeRepository.getById(accountTypeDeletedEvent.getAccountTypeId());
		this.accountTypeRepository.delete(accountType);
	}
	
	@EventHandler
	public void onUpdate(AccountTypeUpdatedEvent accountTypeUpdatedEvent) {
		
		AccountType accountTypeNew = new AccountType();
		BeanUtils.copyProperties(accountTypeUpdatedEvent, accountTypeNew);
		
		this.accountTypeRepository.save(accountTypeNew);
	}
	
}
