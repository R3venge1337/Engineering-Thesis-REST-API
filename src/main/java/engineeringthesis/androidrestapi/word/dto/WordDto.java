package engineeringthesis.androidrestapi.word.dto;

import java.util.UUID;

public record WordDto(UUID uuid, String name, String downloadUri) {
}
