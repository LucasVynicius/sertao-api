package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.dtos.CreateUserRequest;
import br.com.sertaodata.sertaoapi.dtos.UserCreatedDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserCreatedDTO createUser(CreateUserRequest userDto);


}
