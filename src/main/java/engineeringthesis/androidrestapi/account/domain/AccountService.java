package engineeringthesis.androidrestapi.account.domain;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.account.AccountFacade;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.account.dto.AccountDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AccountService implements AccountFacade {

	
	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;
	private final  PasswordEncoder bcryptEncoder;
	
	@Override
	public List<AccountDTO> getAllAccounts(Integer page, Integer size, Sort.Direction sort) {
		int pageNumber = page != null && page > 0 ? page : 0;
		Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
		return accountMapper.map(accountRepository.findAll(PageRequest.of(pageNumber,size,Sort.by(sortDirection,"accountId")))).toList();
	}

	@Override
	public AccountDTO saveAccount(AccountDTO account) {
		
		Account accountEntity = accountMapper.mapOfDTO(account);
		accountEntity.setAccountPassword(bcryptEncoder.encode(account.getAccountPassword()));
		accountEntity.setAccountCreatedDate(LocalDateTime.now());
		Account savedEntity = accountRepository.save(accountEntity);
		return accountMapper.mapOfEntity(savedEntity);
	}

	@Override
	public AccountDTO getOneByName(String name) {
		
		return accountMapper.mapOfEntity(accountRepository.findByAccountName(name));
	}

	@Override
	public AccountDTO getOneById(Integer accountId) {
		return accountMapper.mapOfEntity(accountRepository.findById(accountId).orElseThrow());
	}
	
	@Override
	public AccountDTO updateAccount(Integer accountId, AccountDTO account) {
		
		Optional<Account> accountEntity = accountRepository.findById(accountId);
		Account savedEntity = accountEntity.get();
		savedEntity.setAccountName(account.getAccountName());
		//bcryptEncoder.encode
		if(account.getAccountPassword().equals(null) || account.getAccountPassword().equals(" ") || account.getAccountPassword().isEmpty())
		{
			savedEntity.setAccountPassword(savedEntity.getAccountPassword());
		}
		else if(account.getAccountPassword().trim().length() > 0)
		{
		 savedEntity.setAccountPassword(bcryptEncoder.encode(account.getAccountPassword()));
		}
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

	@Override
	public List<AccountDTO> getExpiredAccounts(Integer accountExpiredAge) {
		return accountMapper.mapOfCollection(accountRepository.findExpiredAccounts(accountExpiredAge));
	}

}