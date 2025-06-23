package br.com.sertaodata.sertaoapi.dtos;

import java.time.LocalDate;

public record CreateCropRequest(
        String cropType,
        Double areaPlanted,
        LocalDate plantingDate,
        LocalDate harvestDate,
        Long propertyId
) {
}
