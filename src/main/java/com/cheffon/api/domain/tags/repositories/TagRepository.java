package com.cheffon.api.domain.tags.repositories;

import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;

public interface TagRepository<T, V> {
	Tag buscar(Long id);
	T listar(V dadosPaginacao, ListarTagFiltro filtro );
	Tag cadastrar(Tag tag);
	Tag editar(Tag tag);
	void excluir(Long id);
}
