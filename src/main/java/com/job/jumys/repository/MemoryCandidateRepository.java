package com.job.jumys.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.job.jumys.model.Candidate;

@Repository
public class MemoryCandidateRepository implements CandidateRepository {
    
    private int nextId = 1;

    private final Map<Integer, Candidate> vacancies = new HashMap<>();

    private MemoryCandidateRepository() {
        save(new Candidate(0, "Intern Java Developer", "no experiance"));
        save(new Candidate(0, "Junior Java Developer", "1 year experiance"));
        save(new Candidate(0, "Junior+ Java Developer", "1.5 year experiance"));
        save(new Candidate(0, "Middle Java Developer", "2 year experiance"));
        save(new Candidate(0, "Middle+ Java Developer", "3 year experiance"));
        save(new Candidate(0, "Senior Java Developer", "5 year experiance"));
    }

    @Override
    public Candidate save(Candidate candidate) {
        candidate.setId(nextId++);
        vacancies.put(candidate.getId(), candidate);
        return candidate;
    }

    @Override
    public boolean deleteById(int id) {
        return vacancies.remove(id) != null;
    }

    @Override
    public boolean update(Candidate candidate) {
        return vacancies.computeIfPresent(candidate.getId(), (id, oldCandidate) -> 
            new Candidate(oldCandidate.getId(), candidate.getName(), candidate.getDescription())) != null;
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public Collection<Candidate> findAll() {
        return vacancies.values();
    }

}