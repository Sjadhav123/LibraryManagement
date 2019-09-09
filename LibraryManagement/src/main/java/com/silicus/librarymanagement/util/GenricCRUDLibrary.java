package com.silicus.librarymanagement.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface GenricCRUDLibrary<T> {

    public T update(int id) throws FileNotFoundException, ClassNotFoundException, IOException;
    public void insert(Collection<T> t) throws IOException, FileNotFoundException, ClassNotFoundException;
    public Collection<T> findAll() throws IllegalStateException, IllegalArgumentException, ClassNotFoundException, IOException;
    public boolean delete(Long id) throws FileNotFoundException, IOException;
    public long count();
    public Object findById(int id);
    public T findByName(String name);
 
}

