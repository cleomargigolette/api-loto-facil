package com.bi.lotofacil.service;

import com.bi.lotofacil.modail.Sweepstakes;
import com.bi.lotofacil.repository.SweepstakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SweepsyakesService {

    @Autowired
    private SweepstakesRepository repository;

    @Autowired
    private ManagerFileService managerFileService;

    @Autowired
    private SweepstakesBallService sweepstakesBallService;

    public Sweepstakes saveSweepstake(Sweepstakes sweepstakes) {
        return this.repository.save(sweepstakes);
    }

    public Sweepstakes findBySweepstake(Long id) {
        return this.repository.findById(id).get();
    }

    public List<Sweepstakes> findAll() {
        return this.repository.findAll();
    }

    public List<Sweepstakes> saveAll() throws IOException {
        List<Sweepstakes> sweepstakesList = managerFileService.createSweepstakes();
        sweepstakesList.forEach(sweepstake -> {
            Sweepstakes sweepstakes = this.repository.save(sweepstake);
            sweepstake.getBalls().forEach(ball -> {
                sweepstakesBallService.insert(ball.getId(), sweepstake.getId());
            });

        });
        return sweepstakesList;
    }
}
