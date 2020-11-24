package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Pairing;
import org.springframework.data.repository.CrudRepository;

public interface PairingsRepository extends CrudRepository<Pairing, Long> {
}
