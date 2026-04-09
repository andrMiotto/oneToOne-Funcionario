package senai.weg.exemploManyToMany.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioRequest;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioResponse;
import senai.weg.exemploManyToMany.service.FuncionarioService;

@RequiredArgsConstructor
@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping("/register")
    public ResponseEntity<FuncionarioResponse> create(@RequestBody FuncionarioRequest funcionarioRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.create(funcionarioRequest));

    }

    @GetMapping("/list")
    public ResponseEntity<List<FuncionarioResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.listAll());

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<FuncionarioResponse> listId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findById(id));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FuncionarioResponse> update(@PathVariable("id") long id,
            @RequestBody FuncionarioRequest funcionarioRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.update(id, funcionarioRequest));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{funcionario_id}/assento/{assento_id}")
    public ResponseEntity<FuncionarioResponse> associarAssento(@PathVariable long funcionario_id,
            @PathVariable long assento_id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.associarAssento(funcionario_id, assento_id));
    }

    @PutMapping("/{funcionario_id}/projeto/{projeto_id}")
    public ResponseEntity<FuncionarioResponse> associarProjeto(@PathVariable long funcionario_id,
            @PathVariable long projeto_id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.associarProjeto(funcionario_id, projeto_id));

    }

}
