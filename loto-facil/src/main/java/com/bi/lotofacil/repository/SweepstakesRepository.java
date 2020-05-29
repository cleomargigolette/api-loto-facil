package com.bi.lotofacil.repository;

import com.bi.lotofacil.modail.Sweepstakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SweepstakesRepository extends JpaRepository<Sweepstakes, Long> {
}
