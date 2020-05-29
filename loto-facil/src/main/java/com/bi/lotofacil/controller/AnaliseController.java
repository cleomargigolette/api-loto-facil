package com.bi.lotofacil.controller;

import com.bi.lotofacil.service.SorteioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnaliseController {
    @Autowired
    private SorteioService service;

    public String teste (){
        return service.teste();
    }
}
