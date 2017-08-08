package br.com.heiderlopes.notepadsaas.repository;

import br.com.heiderlopes.notepadsaas.model.Nota;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface NotaRepository extends MongoRepository<Nota, String> {

    @Query("{}")
    List<Nota> all();

}
