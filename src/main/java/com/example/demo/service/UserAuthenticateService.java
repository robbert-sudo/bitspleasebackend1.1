package com.example.demo.service;

import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.response.AuthenticationResponse;

public interface UserAuthenticateService {


    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);
}
