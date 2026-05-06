package com.fiap.fase1.service;

import com.fiap.fase1.dto.UsuarioEntradaDTO;
import com.fiap.fase1.dto.UsuarioSaidaDTO;
import com.fiap.fase1.model.Usuario;
import com.fiap.fase1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioSaidaDTO criar(UsuarioEntradaDTO dto) {

        validarEntrada(dto);

        repository.findByEmailIgnoreCase(dto.getEmail())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("Email já cadastrado");
                });

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());
        usuario.setEndereco(dto.getEndereco());
        usuario.setTipo(dto.getTipo());
        usuario.setDataUltimaAlteracao(LocalDateTime.now());

        repository.save(usuario);

        return toDTO(usuario);
    }

    private void validarEntrada(UsuarioEntradaDTO dto) {

        System.out.println("EMAIL RECEBIDO: " + dto.getEmail());

        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email obrigatório");
        }

        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }
    }

    public List<UsuarioSaidaDTO> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public void alterarSenha(Long id, String novaSenha) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setSenha(novaSenha);
        usuario.setDataUltimaAlteracao(LocalDateTime.now());

        repository.save(usuario);
    }

    public boolean validarLogin(String login, String senha) {
        return repository.findByLoginAndSenha(login, senha).isPresent();
    }

    private UsuarioSaidaDTO toDTO(Usuario u) {
        UsuarioSaidaDTO dto = new UsuarioSaidaDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setLogin(u.getLogin());
        dto.setTipo(u.getTipo());
        dto.setEndereco(u.getEndereco());
        return dto;
    }
}