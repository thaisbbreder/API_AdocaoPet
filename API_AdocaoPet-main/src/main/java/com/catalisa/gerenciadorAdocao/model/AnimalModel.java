package com.catalisa.gerenciadorAdocao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ANIMAIS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do animal é obrigatório!")
    private String nome;
    @NotNull(message = "A idade do animal é obrigatório!")
    private Integer idade; //validacao negativo
    @NotBlank(message = "O tamanho do animal é obrigatório!")
    private String tamanho;
    @NotBlank(message = "O sexo do animal é obrigatório!")
    private String sexo; //Enum
    private String descricao;
    @OneToMany (mappedBy = "animal", fetch = FetchType.EAGER,  cascade = CascadeType.ALL)    //(fetch = FetchType.EAGER)
    private List<ComentarioModel> comentarios = new ArrayList<>();
    @NotNull(message = "A disponibilidade do animal é obrigatório!")
    private boolean disponivelAdocao;
    //gato ou cachorro Enum
    //teste
}
