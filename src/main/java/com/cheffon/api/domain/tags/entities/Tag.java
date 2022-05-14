package com.cheffon.api.domain.tags.entities;

public final class Tag {

	private Long id;
	private String nome;

	public Tag( String nome ) {
		this.setNome( nome );
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	private void setNome( String nome ) {
		this.nome = nome;
	}

	@Override
	public boolean equals( Object o ) {
		if( this == o )
			return true;
		if( !( o instanceof Tag ) )
			return false;

		Tag tag = ( Tag ) o;

		if( getId() != null ? !getId().equals( tag.getId() ) : tag.getId() != null )
			return false;
		return getNome() != null ? getNome().equals( tag.getNome() ) : tag.getNome() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + ( getNome() != null ? getNome().hashCode() : 0 );
		return result;
	}

	@Override
	public String toString() {
		return "Tag{" + "id=" + id + ", nome='" + nome + '\'' + '}';
	}
}
