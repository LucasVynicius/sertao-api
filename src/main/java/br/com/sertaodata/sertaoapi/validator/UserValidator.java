package br.com.sertaodata.sertaoapi.validator;

import br.com.sertaodata.sertaoapi.enums.TypeUser;
import br.com.sertaodata.sertaoapi.exceptions.BusinessException;
import br.com.sertaodata.sertaoapi.model.User;
import br.com.sertaodata.sertaoapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public User validateAndGetProducer(Long idUser){
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new EntityNotFoundException("Usuario com Id" + idUser + " nao encontrado"));

        if (!user.getTypeUser().equals(TypeUser.PRODUCER)){
            throw new BusinessException("A acao so pode ser realizada por um produtor.");
        }

        return user;
    }

    public User validateAndGetTechnician(Long idUser){
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new EntityNotFoundException("Usuario com Id" + idUser + " nao encontrado"));

        if (!user.getTypeUser().equals(TypeUser.TECHNICIAN)) {
            throw new BusinessException("A ação só pode ser realizada por um técnico.");
        }

        return user;
    }


}
