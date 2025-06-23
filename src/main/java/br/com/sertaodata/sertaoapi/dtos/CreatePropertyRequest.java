package br.com.sertaodata.sertaoapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreatePropertyRequest(
        @NotBlank(message = "Nome é obrigatorio")
        String name,
        @NotBlank(message = "Municipio é obrigatorio")
        String municipality,
        @NotBlank(message = "Estado é obrigatorio")
        String state,
        @Positive(message = "Tamanho da propriedade é obrigato")
        Double sizeInHectares,
        @NotNull
        Long ownerId
) {
}
