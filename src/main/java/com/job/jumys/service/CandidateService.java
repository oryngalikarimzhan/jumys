package com.job.jumys.service;

import java.util.Collection;
import java.util.Optional;

import com.job.jumys.model.Candidate;

public interface CandidateService {

    Candidate save(Candidate candidate);

    boolean deleteById(int id);

    boolean update(Candidate candidate);

    Optional<Candidate> findById(int id);

    Collection<Candidate> findAll();
}
