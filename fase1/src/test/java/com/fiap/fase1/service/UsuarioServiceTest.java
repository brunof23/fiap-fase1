package com.fiap.fase1.service;

import com.fiap.fase1.dto.UsuarioEntradaDTO;
import com.fiap.fase1.model.TipoUsuario;
import com.fiap.fase1.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveCriarUsuario() {
        UsuarioEntradaDTO dto = new UsuarioEntradaDTO(
                "Bruno", "bruno@email.com", "bruno", "123", "Rua X", TipoUsuario.CLIENTE
        );

        when(repository.findByEmailIgnoreCase(any())).thenReturn(Optional.empty());

        service.criar(dto);

        verify(repository).save(any());
    }
}