package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{

    private final PropertyRepository propertyRepository;
}
