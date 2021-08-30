package com.nasr.hospital.db.dao;

import java.util.List;

/**
 *
 * @author Muhamed S. NasR for SQL lines and dealing with Data in tables....
 *
 */
public interface DaoList<T> {
    

    public List<T> loadAll() throws Exception;

    public String insert() throws Exception;

    public String delete() throws Exception;

    public String update() throws Exception;

    public T getData(T t) throws Exception;
    
}
