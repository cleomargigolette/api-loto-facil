package com.bi.lotofacil.DTO.response;

import com.bi.lotofacil.modail.Ball;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BallSaveResDTO {
    private Long id;
    private Long name;

    public static BallSaveResDTO of(Ball ball) {
        BallSaveResDTO dto = BallSaveResDTO.builder()
                .id(ball.getId())
                .name(ball.getName())
                .build();
        return dto;
    }

    public static List<BallSaveResDTO> findAll(List<Ball> listBall) {
        List<BallSaveResDTO> listDto = new ArrayList<BallSaveResDTO>();
        listBall.forEach(ball -> {
            listDto.add(of(ball));
        });
        return listDto;
    }
}
