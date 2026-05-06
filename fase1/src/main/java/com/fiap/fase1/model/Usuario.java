package com.fiap.fase1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    private String endereco;

    private LocalDateTime dataUltimaAlteracao;
}