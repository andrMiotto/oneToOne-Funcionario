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
import senai.weg.exemploManyToMany.dto.assento.AssentoRequest;
import senai.weg.exemploManyToMany.dto.assento.AssentoResponse;
import senai.weg.exemploManyToMany.service.AssentoService;

@RestController
@RequestMapping("assento")
@RequiredArgsConstructor
public class AssentoController {
    
private final AssentoService assentoService;


    @PostMapping("/register")
    public ResponseEntity<AssentoResponse> create(@RequestBody AssentoRequest assentoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(assentoService.create(assentoRequest));

    }

    @GetMapping("/list")
    public ResponseEntity<List<AssentoResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(assentoService.listAll());

    }


    @GetMapping("/list/{id}")
    public ResponseEntity<AssentoResponse> listId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(assentoService.findById(id));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AssentoResponse> update(@PathVariable("id") long id, @RequestBody AssentoRequest assentoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(assentoService.update(id, assentoRequest));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        assentoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
