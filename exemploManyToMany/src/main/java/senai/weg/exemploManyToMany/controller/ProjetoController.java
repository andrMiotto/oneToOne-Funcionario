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
import senai.weg.exemploManyToMany.dto.projeto.ProjetoRequest;
import senai.weg.exemploManyToMany.dto.projeto.ProjetoResponse;
import senai.weg.exemploManyToMany.service.ProjetoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("projeto")
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping("/register")
    public ResponseEntity<ProjetoResponse> create(@RequestBody ProjetoRequest projetoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.create(projetoRequest));

    }

    @GetMapping("/list")
    public ResponseEntity<List<ProjetoResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.listAll());

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ProjetoResponse> listId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.findById(id));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjetoResponse> update(@PathVariable("id") long id,
            @RequestBody ProjetoRequest projetoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.update(id, projetoRequest));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        projetoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
