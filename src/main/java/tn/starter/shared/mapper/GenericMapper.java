package tn.starter.shared.mapper;

import java.util.List;

public interface GenericMapper<T,D> {
    /* T:DTO D:Entity */
    D toEntity(T source);
    T toDto(D source);
    List<T> toListDto(List<D> source);
}