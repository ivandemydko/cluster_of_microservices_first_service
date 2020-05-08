package com.example.first_service.controller;

import com.example.first_service.service.FirstModelService;

import com.example.first_service.service.SecondModelService;
import model.AllModels;
import model.firstmodel.FirstModel;
import model.secondmodel.SecondModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstModelController {

    @Autowired
    private FirstModelService firstModelService;

    @Autowired
    private SecondModelService secondModelService;

    @Value("${example.value}")
    private String configExampleValue;

    @GetMapping("/firstModel/{name}")
    public FirstModel getModelByName(@PathVariable(name = "name") String name) {
        FirstModel firstModel = firstModelService.findByName(name);
        firstModel.setName(firstModel.getName() + " + " + configExampleValue);
        return firstModel;
    }

    @GetMapping("/allModels")
//    @PreAuthorize("#oauth2.hasScope('server')")
    public AllModels getAllModels() {
        FirstModel firstModel = firstModelService.findByName("first_model_1");
        SecondModel secondModel = secondModelService.getSecondModel();
        return new AllModels(firstModel, secondModel);
    }


}
