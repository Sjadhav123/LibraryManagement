package com.silicus.librarymanagement.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface GenricCRUDLibrary<T> {

    public T update(int id);
    public T insert(T t) throws IOException, FileNotFoundException;
    public Collection<T> findAll();
    public boolean delete(Long id);
    public long count();
    public Object findById(int id);
    public T findByName(String name);
 
}
