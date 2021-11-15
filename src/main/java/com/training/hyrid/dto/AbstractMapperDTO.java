/*
package com.training.hyrid.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AbstractMapperDTO<D,E> {

    @Autowired
    private ModelMapper mapper;

    public E dtoToEnity(D dto, Class<E> entity){
        return mapper.map(dto,entity);
    }

    public D entityToDto(E entity,Class<D> dto){
        return mapper.map(entity,dto);
    }

    public List<D> entityToListDto(List<E> listEntity,Class<D> d){
        List<D> dto = listEntity.stream().map(e -> entityToDto(e,d)).collect(Collectors.toList());
        return dto.stream().distinct().collect(Collectors.toList());
    }

}
*/
