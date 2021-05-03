package com.quane.employeemanager.service;

import com.quane.employeemanager.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {


    public String register(RegistrationRequest request) {return "it works";}
}
