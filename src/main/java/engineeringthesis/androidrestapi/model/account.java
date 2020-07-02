package engineeringthesis.androidrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "account")
public class account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
	private Integer accountId;
	
	@Column(name = "accountName")
	private String accountName;
	
	@Column(name = "accountPassword")
	private String accountPassword;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "accountCreatedDate")
		private Date accountCreatedDate;
	
	@Column(name = "accountEmail")
	private String accountEmail;
	
	public account(){}
	
	public account(String accountName, String accountPassword, Date accountCreatedDate, String accountEmail) {
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.accountCreatedDate = accountCreatedDate;
		this.accountEmail = accountEmail;
	}



	public account(Integer accountId, String accountName, String accountPassword, Date accountCreatedDate,
			String accountEmail) {
		
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.accountCreatedDate = accountCreatedDate;
		this.accountEmail = accountEmail;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public Date getAccountCreatedDate() {
		return accountCreatedDate;
	}

	public void setAccountCreatedDate(Date accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	@Override
	public String toString() {
		return "account [accountId=" + accountId + ", accountName=" + accountName + ", accountPassword="
				+ accountPassword + ", accountCreatedDate=" + accountCreatedDate + ", accountEmail=" + accountEmail
				+ "]";
	}
	
	
	

}
