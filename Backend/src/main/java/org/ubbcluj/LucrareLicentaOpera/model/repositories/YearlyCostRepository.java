package org.ubbcluj.LucrareLicentaOpera.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubbcluj.LucrareLicentaOpera.model.entities.YearlyCost;

import java.util.List;

@Repository
public interface YearlyCostRepository extends CrudRepository<YearlyCost, Integer> {

    @Query("select yc from YearlyCost yc where yc.year = :year")
    List<YearlyCost> findByYear(@Param("year") Integer year);
}
