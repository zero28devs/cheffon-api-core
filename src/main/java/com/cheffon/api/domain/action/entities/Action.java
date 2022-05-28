package com.cheffon.api.domain.action.entities;

public class Action {
    private Long id;
    private String name;

    public Action(String name) {
        setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;

        Action action = (Action) o;

        if (getId() != null ? !getId().equals(action.getId()) : action.getId() != null) return false;
        return getName() != null ? getName().equals(action.getName()) : action.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Action{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
