package com.fiap.fase1.controller;

import com.fiap.fase1.dto.UsuarioEntradaDTO;
import com.fiap.fase1.dto.UsuarioSaidaDTO;
import com.fiap.fase1.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioSaidaDTO criar(@RequestBody UsuarioEntradaDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<UsuarioSaidaDTO> buscarPorNome(@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }

    @PatchMapping("/{id}/senha")
    public void alterarSenha(@PathVariable Long id, @RequestBody String senha) {
        service.alterarSenha(id, senha);
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String login, @RequestParam String senha) {
        return service.validarLogin(login, senha);
    }
}