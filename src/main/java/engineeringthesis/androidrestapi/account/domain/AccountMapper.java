package engineeringthesis.androidrestapi.account.domain;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.account.dto.AccountDTO;
import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class AccountMapper implements Mapper<AccountDTO, Account>{

	@Override
	public AccountDTO mapOfEntity(Account entity) {
		
		AccountDTO accountDTO = AccountDTO.builder()
				.accountId(entity.getAccountId())
				.accountName(entity.getAccountName())
				.accountPassword(entity.getAccountPassword())
				.accountEmail(entity.getAccountEmail())
				.accountCreatedDate(entity.getAccountCreatedDate())
				.role(entity.getRole())
				.build();
		return accountDTO;
	}

	@Override
	public Account mapOfDTO(AccountDTO dto) {
		
		Account account = Account.builder()
				.accountId(dto.getAccountId())
				.accountName(dto.getAccountName())
				.accountPassword(dto.getAccountPassword())
				.accountEmail(dto.getAccountEmail())
				.accountCreatedDate(dto.getAccountCreatedDate())
				.role(dto.getRole())
				.build();
		return account;
	}

}
