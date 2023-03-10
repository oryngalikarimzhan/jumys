package com.job.jumys.repository;

import java.util.Collection;
import java.util.Optional;

import com.job.jumys.model.Candidate;

public interface CandidateRepository {

    Candidate save(Candidate candidate);

    boolean deleteById(int id);

    boolean update(Candidate candidate);

    Optional<Candidate> findById(int id);

    Collection<Candidate> findAll();

}
