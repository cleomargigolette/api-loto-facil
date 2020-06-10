package com.bi.lotofacil.service;

import com.bi.lotofacil.DTO.response.BallResDTO;
import com.bi.lotofacil.DTO.response.OccurrenceRateBallsCousinsResDTO;
import com.bi.lotofacil.DTO.response.OccurrenceRateInSweepstakesResDTO;
import com.bi.lotofacil.DTO.response.PeriodAllBallsResDTO;
import com.bi.lotofacil.modail.Ball;
import com.bi.lotofacil.modail.Sweepstakes;
import com.bi.lotofacil.repository.SweepstakesBallRepository;
import com.bi.lotofacil.repository.SweepstakesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnalyzerService {
    @Autowired
    private SweepstakesBallRepository repository;

    @Autowired
    private SweepstakesRepository sweepstakesRepository;

    @Autowired
    private SweepsyakesService SweepsyakesService;

    public Long countNumberInSweepstakes(Long idBall) {
        return repository.countNumberInSweepstakes(idBall);
    }

    public Long countNumberSweepstakes() {
        return sweepstakesRepository.countNumberSweepstakes();
    }

    public List<BallResDTO> findAllCountNumberInSweepstakes() {
        List<BallResDTO> listRateBalls = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            Long rate = this.countNumberInSweepstakes(new Long(i));
            BallResDTO ballResDTO = BallResDTO.builder()
                    .ball(new Long(i))
                    .rate(rate)
                    .build();
            listRateBalls.add(ballResDTO);
        }
        return listRateBalls;
    }

    public OccurrenceRateBallsCousinsResDTO verifyRateBallsCousin() {
        List<BallResDTO> rateBallsCousin = new ArrayList<>();
        Long[] numbersCousinsArray = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L};
        List<Long> numbersCousins = Arrays.asList(numbersCousinsArray);

        numbersCousins.forEach(numberCousin -> {
            Long rate = countNumberInSweepstakes(numberCousin);
            BallResDTO ballResDTO = BallResDTO.builder()
                    .ball(numberCousin)
                    .rate(rate)
                    .build();
            rateBallsCousin.add(ballResDTO);
        });
        Long numberSweepstakes =  countNumberSweepstakes();
        OccurrenceRateBallsCousinsResDTO dto = OccurrenceRateBallsCousinsResDTO.builder()
                .numberSweepstakes(numberSweepstakes)
                .rateBallsCousin(rateBallsCousin)
                .build();

        return dto;
    }

    public OccurrenceRateInSweepstakesResDTO createRateBalls() {
        Long numberSweepstakes = this.countNumberSweepstakes();
        List<BallResDTO> rateBalls = this.findAllCountNumberInSweepstakes();

        OccurrenceRateInSweepstakesResDTO dto = OccurrenceRateInSweepstakesResDTO.builder()
                .rateBall(rateBalls)
                .sweepstakeTotal(numberSweepstakes)
                .build();

        return dto;
    }

    public List<Long> periodOccurrenceBall(Long idBall) {
        List<Long> listPeriodOccurrenceBall = new ArrayList<>();
        List<Sweepstakes> sweepstakes = SweepsyakesService.findAll();
        final Long[] periodCurrence = {0L};

        final boolean[][] positiveNegative = {{false}};
        final Long[] positive = {0L};
        final Long[] negative = {0L};

        sweepstakes.forEach(sweepstake -> {
            List<Ball> listBall = sweepstake.getBalls();
            int concurso = sweepstakes.get(sweepstakes.size() - 1).getConcurso();

            for (int indice = 0; indice < listBall.size(); indice++) {
                Long ballCurrent = listBall.get(indice).getId();
                if (ballCurrent.equals(idBall)) {
                    if (negative[0] < 0L) {
                        listPeriodOccurrenceBall.add(negative[0]);
                        System.out.println("negative " + negative[0]);
                    }
                    positive[0]++;
                    negative[0] = 0L;
                    break;

                } else {
                    if ((listBall.size() - 1) == indice) {
                        if (positive[0] > 0L) {
                            periodCurrence[0]++;
                            listPeriodOccurrenceBall.add(positive[0]);
                            System.out.println("positve " + positive[0]);
                        }
                        negative[0]--;
                        if (concurso == sweepstake.getConcurso()) {
                            listPeriodOccurrenceBall.add(negative[0]);
                            System.out.println("negative " + negative[0]);
                            break;
                        }

                        positive[0] = 0L;
                    }
                }

            }
        });

        return listPeriodOccurrenceBall;
    }

    public List<PeriodAllBallsResDTO> findAllPeriodAllBallsInSweepstakes(){
        List<PeriodAllBallsResDTO> listPeriodAllBallsResDTO = new ArrayList<>();

        for (int indice = 1; indice < 26; indice++){
            List<Long> listPeriod = periodOccurrenceBall(new Long(indice));
            PeriodAllBallsResDTO periodAllBallsResDTO = PeriodAllBallsResDTO.builder()
                    .ball(new Long(indice))
                    .periodBall(listPeriod)
                    .build();
            listPeriodAllBallsResDTO.add(periodAllBallsResDTO);
        }
        return listPeriodAllBallsResDTO;
    }
}
