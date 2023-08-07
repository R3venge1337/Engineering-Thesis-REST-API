package engineeringthesis.androidrestapi.child.dto;


import java.util.UUID;

public record ChildDto(UUID uuid, String name, String surname, Short yearOfBirth, String city) {
}
