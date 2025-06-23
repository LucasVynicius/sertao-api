package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.dtos.CreateCropRequest;
import br.com.sertaodata.sertaoapi.dtos.CropCreatedDTO;
import br.com.sertaodata.sertaoapi.dtos.CropResponse;
import br.com.sertaodata.sertaoapi.model.Crop;
import org.springframework.stereotype.Service;

@Service
public interface CropService {

    CropCreatedDTO createCrop(CreateCropRequest createCropRequest);

    CropResponse getIdCrop(Long id);
}
