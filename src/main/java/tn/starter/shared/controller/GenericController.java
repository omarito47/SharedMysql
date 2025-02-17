package tn.starter.shared.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.starter.shared.service.IGenericService;


import java.util.List;

public class GenericController<T> {

    @Autowired
    IGenericService<T> genericService;

    @PostMapping("/add")
    public T add(@RequestBody T dto) {
        return genericService.add(dto);
    }
    @PutMapping("/put")
    public T update(@RequestBody T dto) {
        return genericService.update(dto);
    }
    @GetMapping("/getById/{id}")
    public T retrieveById(@PathVariable("id") long id) {
        return genericService.retrieveById(id);
    }
    @GetMapping("/getAll")
    public List<T> retrieveAll() {
        return genericService.retrieveAll();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        genericService.delete(id);
    }
}