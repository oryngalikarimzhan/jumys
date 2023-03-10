package com.job.jumys.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.job.jumys.model.Vacancy;

public class MemoryVacancyRepository implements VacancyRepository {
    
    private static final MemoryVacancyRepository INSTANCE = new MemoryVacancyRepository();    

    private int nextId = 1;

    private final Map<Integer, Vacancy> vacancies = new HashMap<>();

    private MemoryVacancyRepository() {
        save(new Vacancy(0, "Intern Java Developer", "no experiance"));
        save(new Vacancy(0, "Junior Java Developer", "1 year experiance"));
        save(new Vacancy(0, "Junior+ Java Developer", "1.5 year experiance"));
        save(new Vacancy(0, "Middle Java Developer", "2 year experiance"));
        save(new Vacancy(0, "Middle+ Java Developer", "3 year experiance"));
        save(new Vacancy(0, "Senior Java Developer", "5 year experiance"));
    }

    public static MemoryVacancyRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        vacancy.setId(nextId++);
        vacancies.put(vacancy.getId(), vacancy);
        return vacancy;
    }

    @Override
    public boolean deleteById(int id) {
        return vacancies.remove(id) != null;
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancies.computeIfPresent(vacancy.getId(), (id, oldVacancy) -> 
            new Vacancy(oldVacancy.getId(), vacancy.getTitle(), vacancy.getDescription())) != null;
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public Collection<Vacancy> findAll() {
        return vacancies.values();
    }

}