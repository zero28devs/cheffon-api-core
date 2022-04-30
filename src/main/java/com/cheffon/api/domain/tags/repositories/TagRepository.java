package com.cheffon.api.domain.tags.repositories;

import com.cheffon.api.domain.tags.entities.Tag;

public interface TagRepository<T, V> {
	Tag buscarPorCodigo(Long id);
	T listar(V parametros);
	Tag cadastrar(Tag tag);
	Tag editar(Tag tag);
	void excluir(Long codigo);
}
