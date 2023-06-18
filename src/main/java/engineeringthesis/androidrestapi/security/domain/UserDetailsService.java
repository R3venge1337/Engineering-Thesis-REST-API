package engineeringthesis.androidrestapi.security.domain;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.account.domain.AccountMapper;
import engineeringthesis.androidrestapi.account.domain.AccountRepository;
import engineeringthesis.androidrestapi.account.dto.AccountDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		AccountDTO account = accountMapper.mapOfEntity(accountRepository.findByAccountName(username));
		AuthorizationUser customUserDetails = null;
		if (account != null) {
			customUserDetails = new AuthorizationUser(account);
			//System.out.println("Wywolano");
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return customUserDetails;
	}

}
