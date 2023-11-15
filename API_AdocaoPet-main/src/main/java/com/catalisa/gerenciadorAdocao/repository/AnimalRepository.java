package com.catalisa.gerenciadorAdocao.repository;

import com.catalisa.gerenciadorAdocao.model.AnimalModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
    Page<AnimalModel> findByNome(String nome, Pageable pageable);
    Page<AnimalModel> findByTamanho(String tamanho, Pageable pageable);
    //Page<AnimalModel> findByDisponibilidade(boolean disponibilidade, Pageable pageable);
}