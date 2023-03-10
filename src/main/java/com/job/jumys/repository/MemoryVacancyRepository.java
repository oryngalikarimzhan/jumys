package com.job.jumys.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.job.jumys.controller.ThreadSafe;
import com.job.jumys.model.Vacancy;

@ThreadSafe
@Repository
public class MemoryVacancyRepository implements VacancyRepository {

    private final AtomicInteger nextId = new AtomicInteger(0);

    private final Map<Integer, Vacancy> vacancies = new ConcurrentHashMap<Integer, Vacancy>();

    private MemoryVacancyRepository() {
        save(new Vacancy(0, "Intern Java Developer", "no experiance", true, 2));
        save(new Vacancy(0, "Junior Java Developer", "1 year experiance", true, 3));
        save(new Vacancy(0, "Junior+ Java Developer", "1.5 year experiance", true, 1));
        save(new Vacancy(0, "Middle Java Developer", "2 year experiance", true, 1));
        save(new Vacancy(0, "Middle+ Java Developer", "3 year experiance", true, 2));
        save(new Vacancy(0, "Senior Java Developer", "5 year experiance", true, 3));
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        vacancy.setId(nextId.incrementAndGet());
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
            new Vacancy(
                oldVacancy.getId(), 
                vacancy.getTitle(), 
                vacancy.getDescription(), 
                vacancy.getVisible(),
                vacancy.getCityId())
            ) != null;
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