package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.model.User;
import br.com.sertaodata.sertaoapi.dtos.CreatePropertyRequest;
import br.com.sertaodata.sertaoapi.dtos.PropertyCreatedDTO;
import br.com.sertaodata.sertaoapi.model.Property;
import br.com.sertaodata.sertaoapi.repository.PropertyRepository;
import br.com.sertaodata.sertaoapi.repository.UserRepository;
import br.com.sertaodata.sertaoapi.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{

    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    @Override
    public PropertyCreatedDTO createProperty(CreatePropertyRequest createPropertyRequest) {
        User user = userRepository.findById(createPropertyRequest.ownerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario não encontrado"));

        userValidator.validateAndGetProducer(createPropertyRequest.ownerId());
        Property property = new Property();

        property.setName(createPropertyRequest.name());
        property.setMunicipality(createPropertyRequest.municipality());
        property.setState(createPropertyRequest.state());
        property.setSizeInHectares(createPropertyRequest.sizeInHectares());
        property.setOwner(user);

        Property propertyCreate = propertyRepository.save(property);

        return new PropertyCreatedDTO("Sua propriedade foi cadastrada com sucesso.", property.getId());
    }

    @Override
    public Property getPropertyTheId(Long id) {
        return propertyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Propriedade não encontrada"));
    }

    @Override
    public List<Property> getPropertys() {
        return propertyRepository.findAll();
    }

}
