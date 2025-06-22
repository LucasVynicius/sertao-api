package br.com.sertaodata.sertaoapi.dtos;

import br.com.sertaodata.sertaoapi.enums.TypeUser;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(
        @NotBlank(message = "Nome é obrigatório")
        String fullName,
        String email,
        String password,
        TypeUser typeUser
) {
}
