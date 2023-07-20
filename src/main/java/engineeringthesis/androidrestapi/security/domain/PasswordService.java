package engineeringthesis.androidrestapi.security.domain;

import engineeringthesis.androidrestapi.security.PasswordFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
class PasswordService implements PasswordFacade {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encodePassword(final String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public Boolean matchPassword(final String raw, final String encoded) {
        return passwordEncoder.matches(raw, encoded);
    }
}