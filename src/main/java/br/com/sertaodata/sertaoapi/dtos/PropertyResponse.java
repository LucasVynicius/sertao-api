package br.com.sertaodata.sertaoapi.dtos;

public record PropertyResponse(
        Long id,
        String name,
        String municipality,
        String state,
        Double sizeInHectares,
        Long ownerId,
        String ownerName
) {
}
