package com.job.jumys.repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.job.jumys.controller.ThreadSafe;
import com.job.jumys.model.Candidate;

@ThreadSafe
@Repository
public class MemoryCandidateRepository implements CandidateRepository {
    
    private final AtomicInteger nextId = new AtomicInteger(0);

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<Integer, Candidate>();

    private MemoryCandidateRepository() {
        save(new Candidate(0, "Intern Java Developer", "no experiance", false, 1));
        save(new Candidate(0, "Junior Java Developer", "1 year experiance", true, 2));
        save(new Candidate(0, "Junior+ Java Developer", "1.5 year experiance", true, 3));
        save(new Candidate(0, "Middle Java Developer", "2 year experiance", true, 1));
        save(new Candidate(0, "Middle+ Java Developer", "3 year experiance", true, 2));
        save(new Candidate(0, "Senior Java Developer", "5 year experiance", true, 2));
    }

    @Override
    public Candidate save(Candidate candidate) {
        candidate.setId(nextId.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
        return candidate;
    }

    @Override
    public boolean deleteById(int id) {
        return candidates.remove(id) != null;
    }

    @Override
    public boolean update(Candidate candidate) {
        return candidates.computeIfPresent(candidate.getId(), (id, oldCandidate) -> 
            new Candidate(
                oldCandidate.getId(), 
                candidate.getTitle(), 
                candidate.getDescription(), 
                candidate.getVisible(), 
                candidate.getCityId())
            ) != null;
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return Optional.ofNullable(candidates.get(id));
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidates.values();
    }

}