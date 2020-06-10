package com.bi.lotofacil.DTO.response;

import com.bi.lotofacil.modail.Sweepstakes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SweepstakeResDTO {
    private int concurso;
    private Date date;
    private List<Long> balls;

    public static SweepstakeResDTO of(Sweepstakes sweepstakes) {
        SweepstakeResDTO DTO = new SweepstakeResDTO();
        List<Long> balls = new ArrayList<>();

        sweepstakes.getBalls().forEach(ball -> {
            balls.add(ball.getName());
        });

        DTO.setConcurso(sweepstakes.getConcurso());
        DTO.setDate(sweepstakes.getDate());
        DTO.setBalls(balls);
        return DTO;
    }

    public static List<SweepstakeResDTO> mapDTO(List<Sweepstakes> list) {
        List<SweepstakeResDTO> listDTO = new ArrayList<>();
        list.forEach(sweepstakes -> {
            listDTO.add(of(sweepstakes));
        });
        return listDTO;
    }
}
