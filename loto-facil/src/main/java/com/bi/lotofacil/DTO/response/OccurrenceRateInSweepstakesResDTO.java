package com.bi.lotofacil.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OccurrenceRateInSweepstakesResDTO {
    private Long SweepstakeTotal;
    private HashMap<Long, Long> rateBall;
}
