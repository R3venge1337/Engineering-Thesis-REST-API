package engineeringthesis.androidrestapi.security.domain;

import java.util.Collection;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import engineeringthesis.androidrestapi.account.dto.AccountDto;
@RequiredArgsConstructor
class AuthorizationUser implements UserDetails {

	private final AccountDto accountDTO;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(accountDTO.role())) ;
	}

	@Override
	public String getPassword() {
		return accountDTO.accountPassword();
	}

	@Override
	public String getUsername() {
		return accountDTO.accountName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return accountDTO.isActive();
	}
}
