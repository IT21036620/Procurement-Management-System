package com.csse.hexa.core;
import java.util.List;

/**
 * Model Mapper interface
 * @param <E>
 * @param <R>
 * @param <V>
 */
public interface ModelMapper<E extends Entity, R extends Request, V extends Response> {
    /**
     * Request to entity e.
     *
     * @param request the request
     * @return the e
     */
    public E requestToEntity(R request);

    /**
     * Entity to response v.
     *
     * @param entity the entity
     * @return the v
     */
    public V entityToResponse(E entity);

    /**
     * Entity to response list.
     *
     * @param entities the entities
     * @return the list
     */
    public List<V> entityToResponse(List<E> entities);
}
