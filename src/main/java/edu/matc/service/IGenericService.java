package edu.matc.service;

import java.util.List;
import edu.matc.persistence.IGenericDAO;

/**
 * The interface Generic service.
 *
 * @param <T> the type parameter
 */
public interface IGenericService<T> extends IGenericDAO<T> {
    /**
     * Gets all.
     *
     * @return the all
     */
    List<T> getAll();
}
