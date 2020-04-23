package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Measurement;
import com.herokuapp.receptio.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Override
    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

}
