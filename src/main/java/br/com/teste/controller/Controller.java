package br.com.teste.controller;

import br.com.teste.entity.Funcionario;
import br.com.teste.service.Service;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;


@RestController
@RequestMapping("busca")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Funcionario funcionario) {
        try {
            service.save(funcionario);
            return status(HttpStatus.OK).body(String.format("OK"));
        } catch (Exception e) {
            return status(HttpStatus.INTERNAL_SERVER_ERROR).body(String.format("ERRO"));
        }

    }

    @GetMapping
    public List<Funcionario> list() {
        return service.buscaTodos();
    }

    @PutMapping("/{id}")
    public HttpStatus update(@PathVariable Long id) {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(id);
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        Funcionario funcionario = new Funcionario();
        try {
            service.deleta(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping("/del/{nome}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable String nome) {
        try {
            service.deletaPorNome(nome);
            return ResponseEntity.ok("Funcionário deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar funcionário: " + e.getMessage());
        }
    }
}
