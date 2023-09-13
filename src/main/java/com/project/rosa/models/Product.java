package com.project.rosa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(nullable = false)
    private String destinacao;

    @Column(nullable = false)
    private Float taxaRentabilidadeAnual;

    @Column(nullable = false)
    private Integer prazoMinimo;

    @Column(nullable = false)
    private Float taxaAdministracao;
}
