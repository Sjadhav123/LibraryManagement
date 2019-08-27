package com.silicus.librarymanagent.Service;

/*Generic interface comman to all entities*/

import java.io.Serializable;
import java.util.List;

public interface GenricCRUDLibrary<T> {

	public T read(Serializable primaryKey) throws IllegalStateException,IllegalArgumentException;
    public T pudate(T t);
    public T insert(T t);
    public List<T> findAll();
    public boolean delete(Long id);
    public long count();
 
}
