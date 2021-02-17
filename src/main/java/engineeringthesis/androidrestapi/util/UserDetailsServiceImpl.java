package engineeringthesis.androidrestapi.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.dto.AccountDTO;
import engineeringthesis.androidrestapi.mapper.AccountMapper;
import engineeringthesis.androidrestapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		AccountDTO account = accountMapper.mapOfEntity(accountRepository.findByAccountName(username));
		CustomUserDetails customUserDetails = null;
		if (account != null) {
			customUserDetails = new CustomUserDetails(account);
			//System.out.println("Wywolano");
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return customUserDetails;
	}

}
