package br.com.heiderlopes.notepadsaas.controller;

import br.com.heiderlopes.notepadsaas.model.Nota;
import br.com.heiderlopes.notepadsaas.repository.NotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    private NotaRepository notaRepository;

    public NotaController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @GetMapping
    private List<Nota> findAll() {
        return notaRepository.findAll();
    }

    @GetMapping(value = "{titulo}")
    private List<Nota> findByTitulo(@PathVariable(value = "titulo") String q) {
        return notaRepository.findByTitulo(q);
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaRepository.save(nota);
    }
}
