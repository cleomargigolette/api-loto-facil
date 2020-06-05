package com.bi.lotofacil.service;

import com.bi.lotofacil.DTO.response.OccurrenceRateBallsCousinsResDTO;
import com.bi.lotofacil.DTO.response.OccurrenceRateInSweepstakesResDTO;
import com.bi.lotofacil.repository.SweepstakesBallRepository;
import com.bi.lotofacil.repository.SweepstakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyzerService {
    @Autowired
    private SweepstakesBallRepository repository;

    @Autowired
    private SweepstakesRepository sweepstakesRepository;

    public Long countNumberInSweepstakes(Long idBall) {
        return repository.countNumberInSweepstakes(idBall);
    }

    public Long countNumberSweepstakes() {
        return sweepstakesRepository.countNumberSweepstakes();
    }

    public HashMap<Long, Long> findAllCountNumberInSweepstakes() {
        HashMap<Long, Long> listLong = new HashMap<>();
        for (int i = 1; i < 26; i++) {
            listLong.put(new Long(i), countNumberInSweepstakes(new Long(i)));
        }
        return listLong;
    }

    public OccurrenceRateBallsCousinsResDTO verifyRateBallsCousin(){
        Long numberSweepstakes = this.countNumberSweepstakes();
        HashMap<Long, Long> rateBalls = this.findAllCountNumberInSweepstakes();
        HashMap<Long, Long> rateBallsCousin = new HashMap<>();
        Long[] numbers = { 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L};
        List<Long> numbersCousins = Arrays.asList(numbers);

        for (Map.Entry<Long,Long> ballRate : rateBalls.entrySet()) {
            Long ballCurrent = ballRate.getKey();
            numbersCousins.forEach(ball -> {
                if(ball.equals(ballCurrent)){
                    rateBallsCousin.put(ballCurrent, ballRate.getValue());
                }
            });
        }
        OccurrenceRateBallsCousinsResDTO dto = OccurrenceRateBallsCousinsResDTO.builder()
                .numberSweepstakes(numberSweepstakes)
                .rateBallsCousin(rateBallsCousin)
                .build();

        return dto;
    }

    public OccurrenceRateInSweepstakesResDTO createRateBalls(){
        Long numberSweepstakes = this.countNumberSweepstakes();
        HashMap<Long, Long> rateBalls = this.findAllCountNumberInSweepstakes();

        OccurrenceRateInSweepstakesResDTO dto = OccurrenceRateInSweepstakesResDTO.builder()
                .rateBall(rateBalls)
                .SweepstakeTotal(numberSweepstakes)
                .build();

        return dto;
    }
}
