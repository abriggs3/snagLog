package edu.matc.service;

import java.util.List;
import edu.matc.persistence.IGenericDAO;

public interface IGenericService<T> extends IGenericDAO<T> {
    List<T> getAll();
    void deleteAll();
}
