package me.dio.service.impl;

import me.dio.domain.model.Usuario;
import me.dio.domain.repository.UsuarioRepository;
import me.dio.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UserServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario create(Usuario usuario) {
        if (usuario.getId() != null && usuarioRepository.existsById(usuario.getId())) {
            throw new IllegalArgumentException("este ID de usuário já existe.");
        }
        return null;
    }
}
