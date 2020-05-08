package com.example.first_service.service;

import com.example.first_service.repository.FirstModelRepository;

import model.firstmodel.FirstModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstModelServiceImpl implements FirstModelService {

    @Autowired
    private FirstModelRepository firstModelRepository;

    @Override
    public FirstModel findByName(String name) {
        return firstModelRepository.findByName(name);
    }
}
