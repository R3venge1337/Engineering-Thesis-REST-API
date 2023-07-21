package engineeringthesis.androidrestapi.security.dto;

import java.util.UUID;

public record AuthenticationResponse(String accessToken, String userName, UUID userUuid, String userRole){
}
