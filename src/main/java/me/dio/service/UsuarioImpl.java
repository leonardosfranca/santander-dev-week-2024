package me.dio.service;

import me.dio.domain.model.Usuario;
import me.dio.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario create(Usuario usuarioToCreate) {
        if (usuarioRepository.existsByContaNumero(usuarioToCreate.getConta().getNumero())) {
            throw new IllegalArgumentException("O número dessa conta já existe!");
        }
        return usuarioRepository.save(usuarioToCreate);
    }
}
