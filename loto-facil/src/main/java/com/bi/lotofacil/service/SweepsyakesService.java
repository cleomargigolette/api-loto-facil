package com.bi.lotofacil.service;

import com.bi.lotofacil.modail.Sweepstakes;
import com.bi.lotofacil.repository.SweepstakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SweepsyakesService{

    @Autowired
    private SweepstakesRepository repository;

    public Sweepstakes saveSweepstake(Sweepstakes sweepstakes){
        return this.repository.save(sweepstakes);
    }

    public Sweepstakes findBySweepstake(Long id){
        return this.repository.findById(id).get();
    }
}
