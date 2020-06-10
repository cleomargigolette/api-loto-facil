package com.bi.lotofacil.controller;

import com.bi.lotofacil.DTO.request.BallSaveReqDTO;
import com.bi.lotofacil.DTO.response.BallSaveResDTO;
import com.bi.lotofacil.service.BallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ball")
public class BallController {
    @Autowired
    private BallService ballService;

    @PostMapping
    public BallSaveResDTO saveBall(@RequestBody BallSaveReqDTO dto) {
        return BallSaveResDTO.of(this.ballService.saveBall(dto.getName()));
    }

    @GetMapping
    public List<BallSaveResDTO> FindAllBall() {
        return BallSaveResDTO.findAll(this.ballService.findAllBall());
    }

    @GetMapping("/{id}")
    public BallSaveResDTO FindByBall(@PathVariable("id") Long id) {
        return BallSaveResDTO.of(this.ballService.findById(id));
    }
}
