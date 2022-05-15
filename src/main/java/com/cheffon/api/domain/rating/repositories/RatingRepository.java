package com.cheffon.api.domain.rating.repositories;

import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;

public interface RatingRepository<T,V> {
    Rating buscar(Long id);
    T listar(V dadosPaginacao, ListarRatingFiltro filtro );
    Rating cadastrar(Rating rating);
    Rating editar(Rating rating );
    void excluir(Long id);

}
