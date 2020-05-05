package org.ubbcluj.LucrareLicentaOpera.model.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ubbcluj.LucrareLicentaOpera.model.entities.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Integer> {
}
