package com.cheffon.api.domain.rating.repositories;

import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;
import org.springframework.data.domain.Pageable;

public interface RatingRepository<T,V> {
    Rating buscar(Long id);
    T listar(Pageable dadosPaginacao, ListarRatingFiltro filtro );
    Rating cadastrar(Rating rating);
    Rating editar(Rating Rating );
    void excluir(Long id);

}
