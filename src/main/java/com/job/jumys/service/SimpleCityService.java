package com.job.jumys.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.job.jumys.model.City;
import com.job.jumys.repository.CityRepository;

@Service
public class SimpleCityService implements CityService {

    private final CityRepository cityRepository;

    public SimpleCityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Collection<City> findAll() {
        return cityRepository.findAll();
    }
}