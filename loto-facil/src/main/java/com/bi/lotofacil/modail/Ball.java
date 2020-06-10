package com.bi.lotofacil.modail;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "ball")
public class Ball {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @NonNull
    private Long name;

    @Transient
    private Long positiveOccurrence;

    @Transient
    private Long negativeOccurrence;

    @Transient
    private Long totalOccurrence;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sweepstake_ball",
            joinColumns = @JoinColumn(name = "ball_id"),
            inverseJoinColumns = @JoinColumn(name = "sweepstakes_id"))
    public List<Sweepstakes> sweepstakes;


}
