package com.example.first_service.repository;


import model.firstmodel.FirstModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstModelRepository extends JpaRepository<FirstModel, Long> {

    FirstModel findByName(String name);
}
