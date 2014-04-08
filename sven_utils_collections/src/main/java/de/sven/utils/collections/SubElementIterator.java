package de.sven.utils.collections;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator that iterates over sub elements from a list.
 *
 * @author sven.bayer
 */
public class SubElementIterator<E> implements Iterator {

    private static final Logger LOGGER = LogManager.getLogger(SubElementIterator.class.getName());
    private static final String ERROR_CANNOT_CALL_INVOKE = "Cannot invoke method ";
    private static final String ERROR_CANNOT_ACCESS_INVOKE = "Cannot access invoked method ";

    private List list;
    private final Method getMethod;

    private int index = -1;

    /**
     * Initializes a SubElementIterator with the List and the getters and setters for the sub element.
     *
     * @param list the list
     * @param getMethod the getter method
     */
    public SubElementIterator(List list, Method getMethod){
        this.list = list;
        this.getMethod = getMethod;
    }

    /**
     * Checks if the list has a next element.
     *
     * @return true if the list has a next element
     */
    @Override
    public boolean hasNext() {
        return index < (list.size() - 1);
    }

    /**
     * Returns the next sub element.
     *
     * @return the next sub element
     */
    @Override
    public E next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        Object o = list.get(++index);
        try {
            return (E) getMethod.invoke(o);
        } catch (IllegalAccessException e) {
            LOGGER.error(ERROR_CANNOT_ACCESS_INVOKE + getMethod.getName(), e);
        } catch (InvocationTargetException e) {
            LOGGER.error(ERROR_CANNOT_CALL_INVOKE + getMethod.getName(), e);
        }
        return null;
    }

    /**
     * Removes the current element.
     */
    @Override
    public void remove() {
        list.remove(index);
    }
}