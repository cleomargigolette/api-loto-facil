package com.bi.lotofacil.repository;

import com.bi.lotofacil.modail.SweepstakeBall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SweepstakesBallRepository extends JpaRepository<SweepstakeBall, Long> {
    @Query(value = "SELECT COUNT(*) FROM sweepstake_ball where ball_id = ?1", nativeQuery = true)
    public Long countNumberInSweepstakes(Long idBall);
}
