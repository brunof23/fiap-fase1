package com.fiap.fase1.dto;

import com.fiap.fase1.model.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntradaDTO {
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String endereco;
    private TipoUsuario tipo;
}
