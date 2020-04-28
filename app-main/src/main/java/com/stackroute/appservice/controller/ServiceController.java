package com.stackroute.appservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class ServiceController {
    @GetMapping("data")
    public String getSensitivbeData() {
              return "You have been validated...";
    }

}
