package com.catalisa.gerenciadorAdocao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Table(name = "TB_COMENTARIO")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class ComentarioModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String texto;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "animal_id", nullable = false)
        private AnimalModel animal;
    }


