package com.bi.lotofacil.modail;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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
}
