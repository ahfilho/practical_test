package br.com.teste.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PESSOA")
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NOME")
    @NotNull
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    @NotNull
    private LocalDate dataNascimento;

//    1
//    2
//    3 --
    //
}
