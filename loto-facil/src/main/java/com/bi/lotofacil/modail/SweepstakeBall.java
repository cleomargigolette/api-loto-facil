package com.bi.lotofacil.modail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sweepstake_ball")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SweepstakeBall {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name  = "ball_id")
    private Long ballId;

    @Column(name  = "sweepstakes_id")
    private Long sweepstakesId;

    @ManyToOne
    @JoinColumn(name = "ball_id", insertable = false, updatable = false)
    private Ball ball;

    @ManyToOne
    @JoinColumn(name = "sweepstakes_id", insertable = false, updatable = false)
    private Sweepstakes sweepstakes;

    public SweepstakeBall(Long idBall, Long idSweepstake){
        this.ballId = idBall;
        this.sweepstakesId = idSweepstake;
    }
}
