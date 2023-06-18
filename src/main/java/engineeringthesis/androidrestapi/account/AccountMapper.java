package engineeringthesis.androidrestapi.account;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class AccountMapper implements Mapper<AccountDTO,AccountEntity>{

	@Override
	public AccountDTO mapOfEntity(AccountEntity entity) {
		
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
	public AccountEntity mapOfDTO(AccountDTO dto) {
		
		AccountEntity accountEntity = AccountEntity.builder()
				.accountId(dto.getAccountId())
				.accountName(dto.getAccountName())
				.accountPassword(dto.getAccountPassword())
				.accountEmail(dto.getAccountEmail())
				.accountCreatedDate(dto.getAccountCreatedDate())
				.role(dto.getRole())
				.build();
		return accountEntity;
	}

}
