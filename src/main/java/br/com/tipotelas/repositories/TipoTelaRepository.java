package br.com.tipotelas.repositories;

import br.com.tipotelas.models.TipoTela;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TipoTelaRepository extends MongoRepository<TipoTela, String> {

     Optional<TipoTela> findByTipo(String tipo);
}
