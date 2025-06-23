package br.com.sertaodata.sertaoapi.controller;

import br.com.sertaodata.sertaoapi.dtos.CreateCropRequest;
import br.com.sertaodata.sertaoapi.dtos.CropCreatedDTO;
import br.com.sertaodata.sertaoapi.dtos.CropResponse;
import br.com.sertaodata.sertaoapi.model.Crop;
import br.com.sertaodata.sertaoapi.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cultura")
public class CropController {

    private final CropService cropService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CropCreatedDTO saveCrop(@RequestBody CreateCropRequest createCropRequest){
        return cropService.createCrop(createCropRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CropResponse getCropId(@PathVariable Long id){
        return cropService.getIdCrop(id);
    }
}
