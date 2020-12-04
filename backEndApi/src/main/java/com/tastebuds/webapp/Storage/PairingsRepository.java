package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Pairing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PairingsRepository extends CrudRepository<Pairing, Long> {
    List<Pairing> findAllByName(String pairing);

    Pairing findByName(String pairing);

    List<Pairing> findByNameIgnoringCase(String butter);
}
