package engineeringthesis.androidrestapi.security.dto;

import java.io.Serializable;

public class AuthorizationResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public AuthorizationResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}