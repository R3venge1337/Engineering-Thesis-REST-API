package engineeringthesis.androidrestapi.security.domain;

import engineeringthesis.androidrestapi.account.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
class AuthorizationUser implements UserDetails {

    private final AccountDto accountDto;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(accountDto.role()));
    }

    @Override
    public String getPassword() {
        return accountDto.password();
    }

    @Override
    public String getUsername() {
        return accountDto.name();
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
        return accountDto.isActive();
    }
}
