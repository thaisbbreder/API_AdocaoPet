package com.catalisa.gerenciadorAdocao.service;

import com.catalisa.gerenciadorAdocao.exception.AnimalNaoEncontradoException;
import com.catalisa.gerenciadorAdocao.model.AnimalModel;
import com.catalisa.gerenciadorAdocao.model.ComentarioModel;
import com.catalisa.gerenciadorAdocao.repository.AnimalRepository;
import com.catalisa.gerenciadorAdocao.repository.ComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public ComentarioModel adicionarComentario(Long animalId, String texto) {
        AnimalModel animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new AnimalNaoEncontradoException("Animal com o ID: " + animalId + " não encontrado."));
        ComentarioModel comentario = new ComentarioModel();
        comentario.setAnimal(animal);
        comentario.setTexto(texto);
        return comentarioRepository.save(comentario);
    }

    public List<ComentarioModel> listarComentarios(Long animalId) {
        AnimalModel animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new AnimalNaoEncontradoException("Animal com o ID: " + animalId + " não encontrado."));

        return animal.getComentarios();
    }
}

