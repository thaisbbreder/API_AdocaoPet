package com.catalisa.gerenciadorAdocao.controller;

import com.catalisa.gerenciadorAdocao.model.AnimalModel;
import com.catalisa.gerenciadorAdocao.model.ComentarioModel;
import com.catalisa.gerenciadorAdocao.service.AnimalService;
import com.catalisa.gerenciadorAdocao.service.ComentarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@RestController
//@Api(value = "AnimalController")
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    //CADASTRAR NOVO ANIMAL
    @ApiOperation(value = "Cadastra um novo animal para ser adotado")
    @PostMapping
    public ResponseEntity<AnimalModel> cadastrarAnimal(@RequestBody @Valid AnimalModel animalModel) {
        AnimalModel novoCadastro = animalService.cadastrarAnimal(animalModel);
        return new ResponseEntity<>(animalModel, HttpStatus.CREATED);
    }

    //LISTAR TODOS ANIMAIS, LISTAR POR NOME E TAMANHO
    @ApiOperation(value = "Lista todos os animais ou busca por filtro de nome ou tamanho")
    @GetMapping
    public ResponseEntity<Page<AnimalModel>> listarTodosAnimals(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String tamanho,
           // @RequestParam(required = false) Boolean disponivelAdocao,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<AnimalModel> animaisPage;

        if (StringUtils.hasText(nome)) {
            animaisPage = animalService.getByNome(nome, page, size);
        } else if (StringUtils.hasText(tamanho)) {
            animaisPage = animalService.getByTamanho(tamanho, page, size);
       // } else if (disponivelAdocao != null && disponivelAdocao) {
       //     animaisPage = animalService.getByDisponibilidade(true, page, size);
        } else {
            animaisPage = animalService.getAll(page, size);
        }
        return ResponseEntity.ok(animaisPage);
    }

    //BUSCAR POR ID
    @ApiOperation(value = "Busca por filtro de id")
    @GetMapping(path = "{id}")
    public ResponseEntity<AnimalModel> buscarAnimalPorId(@PathVariable Long id) {
        AnimalModel animal = animalService.getById(id);
        return ResponseEntity.ok(animal);
    }

    //ATUALIZAR INFORMACOES
    @ApiOperation(value = "Atualiza as informações do animal")
    @PatchMapping(path = "{id}")
    public ResponseEntity<AnimalModel> atualizarAnimal(@PathVariable Long id, @RequestBody AnimalModel animalUpdate) {
        AnimalModel atualizarAnimal = animalService.atualizarAnimalPorId(id, animalUpdate);
        return ResponseEntity.ok(atualizarAnimal);
    }

    //EXCLUIR CADASTRO
    @ApiOperation(value = "Deleta animal pelo id")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarAnimalPorID(@PathVariable Long id) {
        animalService.deletarAnimal(id);
        return ResponseEntity.ok().body("Animal(a) excluído(a) com sucesso!");
    }
}
