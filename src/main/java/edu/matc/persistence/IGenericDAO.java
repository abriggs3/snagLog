package edu.matc.persistence;

import java.util.List;
import java.util.Map;

/**
 * The interface Generic dao.
 *
 * @param <T> the type parameter
 */
public interface IGenericDAO<T> {
    /**
     * Get t.
     *
     * @param cl the cl
     * @param id the id
     * @return the t
     */
    public T get(Class<T> cl, Integer id);

    /**
     * Save t.
     *
     * @param object the object
     * @return the t
     */
    public T save(T object);

    /**
     * Update.
     *
     * @param object the object
     */
    public void update(T object);

    /**
     * Delete.
     *
     * @param object the object
     */
    public void delete(T object);

    /**
     * Query list.
     *
     * @param hsql   the hsql
     * @param params the params
     * @return the list
     */
    public List<T> query(String hsql, Map<String, Object> params);

}
