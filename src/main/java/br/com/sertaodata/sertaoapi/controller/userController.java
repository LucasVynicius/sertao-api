package br.com.sertaodata.sertaoapi.controller;

import br.com.sertaodata.sertaoapi.dtos.CreateUserRequest;
import br.com.sertaodata.sertaoapi.dtos.UserCreatedDTO;
import br.com.sertaodata.sertaoapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuario")
public class userController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreatedDTO createUser(@RequestBody CreateUserRequest user){
        return userService.createUser(user);

    }
}
