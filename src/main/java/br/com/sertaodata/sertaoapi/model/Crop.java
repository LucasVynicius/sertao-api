package br.com.sertaodata.sertaoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cultura_plantada")
public class Crop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tipo_cultura")
    private String cropType;
    @Column(name = "area_plantada")
    private Double areaPlanted;
    @Column(name = "data_plantio")
    private LocalDate plantingDate;
    @Column(name = "previsao_colheita")
    private LocalDate harvestDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propriedade_associada", nullable = false)
    @JsonIgnore
    private Property property;

}
