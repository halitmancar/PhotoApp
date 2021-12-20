package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.SequenceNumber;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class DeleteAccountTypeAggregate {
	
	
	private String accountTypeId;
	
	@AggregateIdentifier
	private String identifier = UUID.randomUUID().toString();
	

	public DeleteAccountTypeAggregate() {
		
	}
	
	@CommandHandler
	public DeleteAccountTypeAggregate(DeleteAccountTypeCommand deleteAccountTypeCommand) {
	
		AccountTypeDeletedEvent accountTypeDeletedEvent = new AccountTypeDeletedEvent();
		BeanUtils.copyProperties(deleteAccountTypeCommand, accountTypeDeletedEvent);
		AggregateLifecycle.apply(accountTypeDeletedEvent);
	}
	
	@EventSourcingHandler
	public void onDelete(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		this.accountTypeId = accountTypeDeletedEvent.getAccountTypeId();
	}
	
}
