package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.account;
import engineeringthesis.androidrestapi.repository.accountRepository;
import engineeringthesis.androidrestapi.service.accountService;

@Service
@Transactional
public class accountServiceImpl implements  accountService {

	@Autowired
	accountRepository accountRepository;

	@Override
	public List<account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public account saveAccount(account acc) {
		return accountRepository.save(acc);
	}

	@Override
	public account getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<account> getOneById(Integer accountId) {
		return accountRepository.findById(accountId);
	}

	@Override
	public void deleteAccount(Integer accountId) {
		accountRepository.deleteById(accountId);
	}
}
