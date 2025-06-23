package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.model.Property;
import br.com.sertaodata.sertaoapi.dtos.CreatePropertyRequest;
import br.com.sertaodata.sertaoapi.dtos.PropertyCreatedDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {

    PropertyCreatedDTO createProperty(CreatePropertyRequest createPropertyRequest);

    Property getPropertyTheId(Long id);

    List<Property> getPropertys();
}
