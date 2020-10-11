package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.AccountDTO;
import engineeringthesis.androidrestapi.entity.AccountEntity;

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
				.build();
		return accountEntity;
	}

}
