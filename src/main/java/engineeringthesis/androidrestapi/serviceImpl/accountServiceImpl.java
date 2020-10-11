package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.dto.AccountDTO;
import engineeringthesis.androidrestapi.entity.AccountEntity;
import engineeringthesis.androidrestapi.mapper.AccountMapper;
import engineeringthesis.androidrestapi.repository.AccountRepository;
import engineeringthesis.androidrestapi.service.AccountService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements  AccountService {

	
	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;

	@Override
	public List<AccountDTO> getAllAccounts() {
		
		return accountMapper.mapOfCollection(accountRepository.findAll());
	}

	@Override
	public AccountDTO saveAccount(AccountDTO account) {
		
		AccountEntity accountEntity = accountMapper.mapOfDTO(account);
		AccountEntity savedEntity = accountRepository.save(accountEntity);
		return accountMapper.mapOfEntity(savedEntity);
	}

	@Override
	public AccountDTO getOneByName(String name) {
		
		return null;
	}

	@Override
	public AccountDTO getOneById(Integer accountId) {
		
		return accountMapper.mapOfEntity(accountRepository.findById(accountId).get());
	}
	
	@Override
	public AccountDTO updateAccount(Integer accountId, AccountDTO account) {
		
		Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
		AccountEntity savedEntity = accountEntity.get();
		savedEntity.setAccountName(account.getAccountName());
		savedEntity.setAccountPassword(account.getAccountPassword());
		savedEntity.setAccountEmail(account.getAccountEmail());
		savedEntity.setAccountCreatedDate(account.getAccountCreatedDate());
		accountRepository.save(savedEntity);
		AccountDTO dto = accountMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteAccount(Integer accountId) {
		
		accountRepository.deleteById(accountId);
	}

	
}
