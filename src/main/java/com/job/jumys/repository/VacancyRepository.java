package com.job.jumys.repository;

import java.util.Collection;
import java.util.Optional;
import com.job.jumys.model.Vacancy;

public interface VacancyRepository {

    Vacancy save(Vacancy vacancy);

    boolean deleteById(int id);

    boolean update(Vacancy vacancy);

    Optional<Vacancy> findById(int id);

    Collection<Vacancy> findAll();

}
