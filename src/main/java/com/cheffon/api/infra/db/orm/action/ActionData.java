package com.cheffon.api.infra.db.orm.action;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table( name = "actions" )
public final class ActionData {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Length( max = 50 )
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
