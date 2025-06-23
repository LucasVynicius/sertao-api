package br.com.sertaodata.sertaoapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "propriedade")
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_propriedade", length = 255, nullable = false)
    private String name;

    @Column(name = "municipio", nullable = true)
    private String municipality;

    @Column(name = "estado", nullable = false)
    private String state;

    @Column(name = "tamanho_hectares", nullable = false)
    private Double sizeInHectares;

    @ManyToOne
    @Column(name = "proprietario", nullable = false)
    private User owner;
}
