package com.bi.lotofacil.modail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sweepstakes")
public class Sweepstakes {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    private int concurso;
    private Date date;
    @ManyToMany(mappedBy = "sweepstakes", fetch = FetchType.EAGER)
    private List<Ball> balls;
}
