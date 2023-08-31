package br.com.teste.repository;

import br.com.teste.entity.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Funcionario, Long> {

//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Funcionario f WHERE f.nome = :nome")
//    List<Funcionario> findByNome(@Param("nome") String nome);
void deleteByNome(String nome);

}
