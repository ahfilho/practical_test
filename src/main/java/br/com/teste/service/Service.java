package br.com.teste.service;

import br.com.teste.entity.Funcionario;
import br.com.teste.repository.Repository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Transactional
@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void save(Funcionario funcionario) {
        funcionario.setDataNascimento(LocalDate.now());
        repository.save(funcionario);
    }

    public List<Funcionario> buscaTodos() {
        List<Funcionario> lista = repository.findAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return repository.findAll();
    }

    public Funcionario atualizar(Funcionario funcionario) throws Exception {
        Optional funcionarioOptional = repository.findById(funcionario.getId());
        if (funcionarioOptional.isPresent()) {
            Funcionario func = new Funcionario();
            func.setNome(funcionario.getNome());
            func.setDataNascimento(funcionario.getDataNascimento());
            func.setSalario(funcionario.getSalario());
            func.setFuncao(funcionario.getFuncao());
            return func;
        } else {
            funcionario.getId();
            return funcionario;
        }
    }

    public void deleta(Long id) throws Exception {
        Optional<Funcionario> funcionarioDeleta = repository.findById(id);
        if (funcionarioDeleta.isPresent()) {
            repository.delete(funcionarioDeleta.get());
        } else {
            throw new Exception("ERRO AO DELETAR O ID" + id);

        }

    }
    public void deletaPorNome(String nome) {
        repository.deleteByNome(nome);
    }

    }

