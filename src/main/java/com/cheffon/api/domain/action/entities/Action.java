package com.cheffon.api.domain.action.entities;


public class Action {
    private Long id;
    private String nome;

    public Action(String nome) {
        this.setNome(nome);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;

        Action action = (Action) o;

        if (getId() != null ? !getId().equals(action.getId()) : action.getId() != null) return false;
        return getNome() != null ? getNome().equals(action.getNome()) : action.getNome() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Action{" + "id=" + id + ", nome='" + nome + '\'' + '}';
    }
}
