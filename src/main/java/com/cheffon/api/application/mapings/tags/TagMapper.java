package com.cheffon.api.application.mapings.tags;

import com.cheffon.api.application.rest.tags.requests.TagCadastrarRequest;
import com.cheffon.api.application.rest.tags.requests.TagEditarRequest;
import com.cheffon.api.application.rest.tags.responses.TagResponse;
import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.infra.db.orm.tags.TagData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagMapper {

	TagMapper INSTANCE = Mappers.getMapper( TagMapper.class );

	TagResponse tagToTagResponse( Tag tag );

	Tag tagCadastrarRequestToTag( TagCadastrarRequest request );

	Tag tagEditarRequestToTag( TagEditarRequest request );

	Tag tagDataToTag( TagData tagData );

	TagData tagToTagData( Tag tag );
}
