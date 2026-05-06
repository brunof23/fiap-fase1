package com.fiap.fase1.dto;

import com.fiap.fase1.model.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSaidaDTO{
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String endereco;
    private TipoUsuario tipo;
}
