package br.com.sertaodata.sertaoapi.service;

import br.com.sertaodata.sertaoapi.dtos.CreateUserRequest;
import br.com.sertaodata.sertaoapi.dtos.UserCreatedDTO;
import br.com.sertaodata.sertaoapi.model.User;
import br.com.sertaodata.sertaoapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserCreatedDTO createUser(CreateUserRequest userDto) {

        User user = new User();

        user.setFullName(userDto.fullName());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setTypeUser(userDto.typeUser());
        user.setDateRegistration(LocalDateTime.now());

        User userCreate = userRepository.save(user);

        return new UserCreatedDTO("Usuário criado com sucesso.", userCreate.getId());
    }

    @Override
    public User getUserTheId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Cliente não encontrado"));
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUsertheId(Long id) {
        userRepository.deleteById(id);
    }
}
