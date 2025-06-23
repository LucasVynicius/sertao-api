package br.com.sertaodata.sertaoapi.dtos;

import br.com.sertaodata.sertaoapi.enums.TypeUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "Nome é obrigatório")
        String fullName,

        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String password,

        @NotBlank(message = "O tipo de usuário é obrigatório")
        TypeUser typeUser

) {
}
