package br.com.teste.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "FUNCIONARIO")
public class Funcionario extends Pessoa {



    @Column(name = "SALARIO")
    @NotNull
    private BigDecimal salario;

    @Column(name = "FUNCAO")
    @NotNull
    private String funcao;

}
