package com.bi.lotofacil.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BallResDTO {
    private Long ball;
    private Long rate;
}
