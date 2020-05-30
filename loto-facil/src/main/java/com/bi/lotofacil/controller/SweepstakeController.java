package com.bi.lotofacil.controller;

import com.bi.lotofacil.DTO.response.SweepstakeResDTO;
import com.bi.lotofacil.modail.Sweepstakes;
import com.bi.lotofacil.service.SweepsyakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sweepstakes")
public class SweepstakeController {
    @Autowired
    private SweepsyakesService service;

    @GetMapping
    public List<Sweepstakes> saveAll() throws IOException {
        return service.saveAll();
    }

    @GetMapping("/findAll")
    public List<SweepstakeResDTO> findAll() {
        return SweepstakeResDTO.mapDTO(service.findAll());
    }
}
