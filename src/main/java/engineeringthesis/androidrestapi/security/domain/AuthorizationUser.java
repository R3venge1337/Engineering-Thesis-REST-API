package engineeringthesis.androidrestapi.security.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import engineeringthesis.androidrestapi.account.dto.AccountDTO;

class AuthorizationUser implements UserDetails {
	
	private static final long serialVersionUID = -1986331235857128091L;
	private int id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdTime;
    private List<GrantedAuthority> authorities = new ArrayList<>();
    
    
    
	public AuthorizationUser(AccountDTO account) {
		super();
		this.id = account.getAccountId();
		this.username = account.getAccountName();
		this.password = account.getAccountPassword();
		this.email = account.getAccountEmail() ;
		this.createdTime = account.getAccountCreatedDate();
        this.authorities.add(new SimpleGrantedAuthority(account.getRole().toString()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public int getId() { return id; }

    public String getEmail() { return email; }
    
    

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
