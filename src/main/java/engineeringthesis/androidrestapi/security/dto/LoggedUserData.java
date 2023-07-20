package engineeringthesis.androidrestapi.security.dto;

import java.util.UUID;

public record LoggedUserData(String userLogin, UUID userUuid, UUID customerUuid) {
}
