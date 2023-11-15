package com.catalisa.gerenciadorAdocao.service;

import com.catalisa.gerenciadorAdocao.exception.AnimalNaoEncontradoException;
import com.catalisa.gerenciadorAdocao.model.AnimalModel;
import com.catalisa.gerenciadorAdocao.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public AnimalModel cadastrarAnimal(AnimalModel updateAnimal) {
        return animalRepository.save(updateAnimal);
    }

    public Page<AnimalModel> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnimalModel> pageResult =  animalRepository.findAll(pageable);
        if (pageResult.isEmpty()) {
            throw new AnimalNaoEncontradoException("Nenhum animal cadastrado.");
        }
        return pageResult;
    }

    public Page<AnimalModel> getByNome(String nome, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnimalModel> pageResult = animalRepository.findByNome(nome, pageable);
        return pageResult;
    }

    public Page<AnimalModel> getByTamanho(String tamanho, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnimalModel> pageResult = animalRepository.findByTamanho(tamanho, pageable);
        return pageResult;
    }

    public AnimalModel getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNaoEncontradoException("Animal com o ID: " + id + " não encontrado."));
    }

    public AnimalModel atualizarAnimalPorId(Long id, AnimalModel updateAnimal) {
        Optional<AnimalModel> animalOptional = animalRepository.findById(id);

        if (animalOptional.isPresent()) {
            AnimalModel animal = animalOptional.get();

            // Aplicar alterações fornecidas
            animal.setNome(updateAnimal.getNome());
            animal.setIdade(updateAnimal.getIdade());
            animal.setTamanho(updateAnimal.getTamanho());
            animal.setSexo(updateAnimal.getSexo());
            animal.setDescricao(updateAnimal.getDescricao());
            animal.setDisponivelAdocao(updateAnimal.isDisponivelAdocao());

            // Salvar animal atualizado
            return animalRepository.save(animal);
        } else {
            throw new AnimalNaoEncontradoException("Animal com o ID: " + id + " não encontrado.");
        }
    }


    public AnimalModel deletarAnimal(Long id) {
        Optional<AnimalModel> animalOptional = animalRepository.findById(id);
        if (animalOptional.isPresent()) {
            AnimalModel animal = animalOptional.get();
            animalRepository.deleteById(id);
            return animal;
        } else {
            throw new AnimalNaoEncontradoException("Não foi possível deletar. Animal com o ID: " + id + " não foi encontrado.");
        }
    }
}