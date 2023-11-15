package com.catalisa.gerenciadorAdocao.repository;

import com.catalisa.gerenciadorAdocao.model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioModel, Long> {
}
