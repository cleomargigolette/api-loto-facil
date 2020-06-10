package com.bi.lotofacil.DTO.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PeriodAllBallsResDTO {
    private Long ball;
    private List<Long> periodBall;
}
