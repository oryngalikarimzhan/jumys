package com.job.jumys.service;

import java.util.Collection;
import java.util.Optional;

import com.job.jumys.model.Vacancy;
import com.job.jumys.repository.MemoryVacancyRepository;
import com.job.jumys.repository.VacancyRepository;

public class SimpleVacancyService implements VacancyService {

    private static final SimpleVacancyService INSTANCE = new SimpleVacancyService();

    private final VacancyRepository vacancyRepository = MemoryVacancyRepository.getInstance();

    public static SimpleVacancyService getInstance() {
        return INSTANCE;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public boolean deleteById(int id) {
        return vacancyRepository.deleteById(id);
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancyRepository.update(vacancy);
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return vacancyRepository.findById(id);
    }

    @Override
    public Collection<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

}