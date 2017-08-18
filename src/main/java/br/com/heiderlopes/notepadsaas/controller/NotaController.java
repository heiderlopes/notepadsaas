package br.com.heiderlopes.notepadsaas.controller;

import br.com.heiderlopes.notepadsaas.component.NotaComponent;
import br.com.heiderlopes.notepadsaas.model.Nota;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    private NotaComponent notaComponent;

    public NotaController(NotaComponent notaComponent) {
        this.notaComponent = notaComponent;
    }

    @GetMapping
    private List<Nota> findAll() {
        return notaComponent.findAll();
    }

    @GetMapping(value = "{titulo}")
    private List<Nota> findByTitulo(@PathVariable(value = "titulo") String q) {
        return notaComponent.findByTitulo(q);
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaComponent.salvar(nota);
    }

    @DeleteMapping
    private void deleteAll() {
        notaComponent.deleteAll();
    }
}
