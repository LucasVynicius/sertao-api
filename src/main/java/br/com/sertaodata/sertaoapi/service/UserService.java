package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.dtos.CreateUserRequest;
import br.com.sertaodata.sertaoapi.dtos.UserCreatedDTO;
import br.com.sertaodata.sertaoapi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserCreatedDTO createUser(CreateUserRequest userDto);

    User getUserTheId(Long id);

    List<User> getUser();

    void deleteUsertheId(Long id);
}
