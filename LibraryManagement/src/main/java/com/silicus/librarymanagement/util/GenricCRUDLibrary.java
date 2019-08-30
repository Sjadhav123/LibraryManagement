package com.silicus.librarymanagement.util;

/*Generic interface comman to all entities*/

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenricCRUDLibrary<T> {

    public T update(int id);
    public void insert();
    public Collection<T> findAll();
    public boolean delete(Long id);
    public long count();
    public Object findById(int id);
    public T findByName(String name);
 
}
