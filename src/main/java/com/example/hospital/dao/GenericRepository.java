package com.example.hospital.dao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public interface GenericRepository<C extends Serializable, Id extends Serializable> {
    void save( @NotNull C entity);
    void update(@NotNull C entity);
    void delete(@NotNull C entity);
    void deleteById(@NotNull Id id);
    C findById( @NotNull Id id);
    List<C> getAll();
}
