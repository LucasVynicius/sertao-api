package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.dtos.CreateCropRequest;
import br.com.sertaodata.sertaoapi.dtos.CropCreatedDTO;
import br.com.sertaodata.sertaoapi.dtos.CropResponse;
import br.com.sertaodata.sertaoapi.exceptions.EntityNotFoundException;
import br.com.sertaodata.sertaoapi.model.Crop;
import br.com.sertaodata.sertaoapi.model.Property;
import br.com.sertaodata.sertaoapi.repository.CropRepository;
import br.com.sertaodata.sertaoapi.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService{

    private final CropRepository cropRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public CropCreatedDTO createCrop(CreateCropRequest createCropRequest) {

        Property property = propertyRepository.findById(createCropRequest.propertyId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cultura não encontrada."));

        Crop crop = new Crop();

        crop.setCropType(createCropRequest.cropType());
        crop.setAreaPlanted(createCropRequest.areaPlanted());
        crop.setPlantingDate(createCropRequest.plantingDate());
        crop.setHarvestDate(createCropRequest.harvestDate());
        crop.setProperty(property);


        Crop saveCrop = cropRepository.save(crop);
        return new CropCreatedDTO("Cultura criada com sucesso", crop.getId());
    }

    @Override
    public CropResponse getIdCrop(Long id) {
        Crop crop = cropRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cultura com ID " + id + " nao encontrada"));

        return new CropResponse(
                crop.getId(), 
                crop.getCropType(),
                crop.getAreaPlanted(),
                crop.getPlantingDate(),
                crop.getHarvestDate(),
                crop.getProperty().getId(),
                crop.getProperty().getName()
        );
    }
}
