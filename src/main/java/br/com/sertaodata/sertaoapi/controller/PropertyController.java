package br.com.sertaodata.sertaoapi.controller;

import br.com.sertaodata.sertaoapi.dtos.CreatePropertyRequest;
import br.com.sertaodata.sertaoapi.dtos.PropertyCreatedDTO;
import br.com.sertaodata.sertaoapi.model.Property;
import br.com.sertaodata.sertaoapi.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("propriedade")
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyCreatedDTO saveProperty(@RequestBody CreatePropertyRequest createPropertyRequest){
        return propertyService.createProperty(createPropertyRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Property getPropertyId(@PathVariable Long id){
        return propertyService.getPropertyTheId(id);
    }
}
