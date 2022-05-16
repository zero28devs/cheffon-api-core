package com.cheffon.api.infra.db.orm.ratings;

import javax.persistence.*;

@Entity
@Table( name = "ratings" )
public class RatingData {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private Double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
