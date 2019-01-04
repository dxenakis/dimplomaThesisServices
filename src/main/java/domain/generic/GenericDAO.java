package domain.generic;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @param <T> The generic class type.
 * @param <ID> The type of the stored object's id.
 * @author Angelos-Christos Anadiotis
 */
public interface GenericDAO<T, ID extends Serializable> {

    /**
     *
     * @param id The id of the stored object.
     * @param lock Indicates whether this operation should be locked.
     * @return The instance of the object in the database, if there is one.
     */
    T findById(ID id, boolean lock);

    /**
     *
     * @return All the database objects of this type.
     */
    List<T> findAll();

    /**
     *
     * @param exampleInstance An instance of the object to look for.
     * @param excludeProperty An array with the object properties which should not be applied as criteria when searching in database.
     * @return A list with the objects in the database, which match the criteria.
     */
    List<T> findByExample(T exampleInstance, String... excludeProperty);

    /**
     *
     * @param entity Make this object persistent (save it) to database.
     * @return An instance of this object.
     */
    T makePersistent(T entity);

    /**
     *
     * @param entity Make this object transient (delete it from database).
     */
    void makeTransient(T entity);

}
