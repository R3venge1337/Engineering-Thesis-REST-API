package engineeringthesis.androidrestapi.child.dto;


import engineeringthesis.androidrestapi.account.dto.AccountDto;

import java.util.UUID;

public record ChildDto(UUID uuid, String name, String surname, Short yearOfBirth, String city, AccountDto account) {
}
