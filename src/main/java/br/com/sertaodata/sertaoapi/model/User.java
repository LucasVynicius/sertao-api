package br.com.sertaodata.sertaoapi.model;

import br.com.sertaodata.sertaoapi.enums.TypeUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", length = 255, nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TypeUser typeUser;

    @CreationTimestamp
    @Column(name = "data_cadastro")
    private LocalDateTime dateRegistration;
}
