package br.com.sertaodata.sertaoapi.dtos;

import java.time.LocalDate;

public record CropResponse(
        Long id,
        String cropType,
        Double areaPlanted,
        LocalDate plantingDate,
        LocalDate harvestDate,
        Long propertyId,
        String propertyName
) {
}
