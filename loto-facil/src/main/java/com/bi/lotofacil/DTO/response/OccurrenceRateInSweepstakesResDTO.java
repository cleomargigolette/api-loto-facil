package com.bi.lotofacil.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OccurrenceRateInSweepstakesResDTO {
    private Long sweepstakeTotal;
    private List<BallResDTO> rateBall;
}
