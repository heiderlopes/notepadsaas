package br.com.heiderlopes.notepadsaas.controller;

import br.com.heiderlopes.notepadsaas.model.Nota;
import br.com.heiderlopes.notepadsaas.repository.NotaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotaController {

    private NotaRepository notaRepository;

    public NotaController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @GetMapping(value = "/")
    private List<Nota> findAll() {
        return notaRepository.findAll();
    }

    @PostMapping(value = "/")
    private void save(@RequestBody Nota nota) {
        notaRepository.save(nota);
    }
}
