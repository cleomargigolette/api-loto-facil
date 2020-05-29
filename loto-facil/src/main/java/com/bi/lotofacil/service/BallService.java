package com.bi.lotofacil.service;

import com.bi.lotofacil.modail.Ball;
import com.bi.lotofacil.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallService {
    @Autowired
    private BallRepository ballRepository;

    public Ball saveBall(Long name) {
        Ball ball = Ball.builder().name(name).build();
        return this.ballRepository.save(ball);
    }

    public Ball findById(Long idBall){
        return ballRepository.findById(idBall).get();
    }

    public List<Ball> findAllBall(){
        return this.ballRepository.findAll();
    }
}
