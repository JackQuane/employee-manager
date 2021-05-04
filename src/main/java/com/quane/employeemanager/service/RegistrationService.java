package com.quane.employeemanager.service;

import com.quane.employeemanager.EmailValidator;
import com.quane.employeemanager.model.AppUser;
import com.quane.employeemanager.model.AppUserRole;
import com.quane.employeemanager.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }

        System.out.println(request.getFirstName());

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                        ));
    }
}
