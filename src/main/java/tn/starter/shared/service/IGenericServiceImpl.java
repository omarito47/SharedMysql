package tn.starter.shared.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.starter.shared.mapper.GenericMapper;

import java.util.List;

@Slf4j
public class IGenericServiceImpl<T,D> implements IGenericService<T> {


    @Autowired
    JpaRepository<D, Long> repository;
    @Autowired
    GenericMapper<T, D> mapper;

    @Override
    public T add(T dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public T update(T dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public T retrieveById(long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(new StringBuilder("No ")
                                .append(this.getClass().getSimpleName())
                                .append(" found with this id").toString()
                        )));
    }

    @Override
    public List<T> retrieveAll() {
        return mapper.toListDto(repository.findAll()) ;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}