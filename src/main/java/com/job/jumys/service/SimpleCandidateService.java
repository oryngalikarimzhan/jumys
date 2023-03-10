package com.job.jumys.service;

import java.util.Collection;
import java.util.Optional;

import com.job.jumys.model.Candidate;
import com.job.jumys.repository.CandidateRepository;
import com.job.jumys.repository.MemoryCandidateRepository;

public class SimpleCandidateService implements CandidateService {
    
    private static final SimpleCandidateService INSTANCE = new SimpleCandidateService();

    private final CandidateRepository candidateRepository = MemoryCandidateRepository.getInstance();

    public static SimpleCandidateService getInstance() {
        return INSTANCE;
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public boolean deleteById(int id) {
        return candidateRepository.deleteById(id);
    }

    @Override
    public boolean update(Candidate candidate) {
        return candidateRepository.update(candidate);
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidateRepository.findAll();
    }
    
}
