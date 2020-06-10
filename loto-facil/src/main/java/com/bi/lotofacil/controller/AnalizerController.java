package com.bi.lotofacil.controller;

import com.bi.lotofacil.DTO.response.OccurrenceRateBallsCousinsResDTO;
import com.bi.lotofacil.DTO.response.OccurrenceRateInSweepstakesResDTO;
import com.bi.lotofacil.DTO.response.PeriodAllBallsResDTO;
import com.bi.lotofacil.service.AnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analizer")
public class AnalizerController {
    @Autowired
    private AnalyzerService analyzerService;

    @GetMapping
    public OccurrenceRateInSweepstakesResDTO findRateBalls() {
        return this.analyzerService.createRateBalls();
    }

    @GetMapping("/cousin")
    public OccurrenceRateBallsCousinsResDTO findRateBallsCousin() {
        return this.analyzerService.verifyRateBallsCousin();
    }

    @GetMapping("/period-ball/{idBall}")
    public List<Long> findPeriodOccurrenceBall(@PathVariable("idBall") Long idBall) {
        return this.analyzerService.periodOccurrenceBall(idBall);
    }

    @GetMapping("/period-balls")
    public List<PeriodAllBallsResDTO> findAllPeriodOccurrenceAllBalls() {
        return this.analyzerService.findAllPeriodAllBallsInSweepstakes();
    }
}
