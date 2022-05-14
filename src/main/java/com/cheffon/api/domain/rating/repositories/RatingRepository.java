package com.cheffon.api.domain.rating.repositories;

import com.cheffon.api.domain.tags.entities.Rating;
import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;

public interface RatingRepository<T,V> {
    Rating buscar(Long id);
    T listar(V dadosPaginacao, ListarTagFiltro filtro );
    Rating cadastrar(Rating rating);
    Rating editar(Rating Rating );
    void excluir(Long id);

}
