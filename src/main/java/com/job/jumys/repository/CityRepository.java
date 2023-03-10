package com.job.jumys.repository;

import java.util.Collection;

import com.job.jumys.model.City;

public interface CityRepository {
    Collection<City> findAll();
}
