package engineeringthesis.androidrestapi.child.dto;

import java.util.UUID;

public record ChildWithAccountDto(UUID uuid, String name, String surname, Short yearOfBirth, String city,
                                  ChildAccountDto account) {
}
