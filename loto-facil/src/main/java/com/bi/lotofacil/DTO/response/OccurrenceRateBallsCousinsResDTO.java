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
public class OccurrenceRateBallsCousinsResDTO {
    private Long numberSweepstakes;
    private HashMap<Long, Long> rateBallsCousin;
}
