package me.dio.controller;

import me.dio.domain.model.Usuario;
import me.dio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(@Qualifier("userServiceImpl") UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        var usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuarioToCreate) {
        var usuarioCreated = usuarioService.create(usuarioToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(usuarioCreated);
    }
}
