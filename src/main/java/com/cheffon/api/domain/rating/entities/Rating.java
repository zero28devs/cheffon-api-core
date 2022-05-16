package com.cheffon.api.domain.rating.entities;

public class Rating {
    private Long id;
    private Double score;

    public Rating(Double score) {
        setScore(score);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;

        Rating rating = (Rating) o;

        if (getId() != null ? !getId().equals(rating.getId()) : rating.getId() != null) return false;
        return getScore() != null ? getScore().equals(rating.getScore()) : rating.getScore() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getScore() != null ? getScore().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {return "Rating{" + "id=" + id + ", score=" + score + '}';
    }
}
