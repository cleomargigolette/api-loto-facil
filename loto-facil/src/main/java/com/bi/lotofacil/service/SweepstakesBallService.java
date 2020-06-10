package com.bi.lotofacil.service;

import com.bi.lotofacil.modail.SweepstakeBall;
import com.bi.lotofacil.repository.SweepstakesBallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SweepstakesBallService {

    @Autowired
    private SweepstakesBallRepository repository;

    public void insert(Long idBall, Long idSweepstake) {

        SweepstakeBall sweepstakesBall = new SweepstakeBall(idBall, idSweepstake);
        repository.save(sweepstakesBall);
    }
}
