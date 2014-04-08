package de.sven.utils.collections;

import javax.annotation.Generated;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * List that operates with sub elements from List elements.
 *
 * @author sven.bayer
 */
public class SubElementList<E> implements Cloneable, List<E> {

    private static final Logger LOGGER = LogManager.getLogger(SubElementList.class.getName());

    private static final String ONLY_READ_AND_DELETE = "SubElementList is only readable and deletable!";
    private static final String ONLY_ITERATOR = "SubElementList has only an Iterator!";
    private static final String ERROR_CANNOT_CALL_INVOKE = "Cannot invoke method ";
    private static final String ERROR_CANNOT_ACCESS_INVOKE = "Cannot access invoked method ";
    private static final String COULDN_T_CLONE_SUB_ELEMENT_LIST = "Couldn't clone SubElementList!";
    private final List list;
    private final Method getMethod;

    public SubElementList(List list, Method getMethod){
        this.list = list;
        this.getMethod = getMethod;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Tests if the list contains the sub element "o".
     *
     * @param o the sub element
     * @return true if it contains an element with the sub element "o"
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Returns a new SubElementIterator for the sub elements.
     *
     * @return the SubElementIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new SubElementIterator<E>(list, getMethod);
    }

    /**
     * Returns the elements as array.
     *
     * @return array of elements
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Use toArray(T[] a) instead!");
    }

    /**
     * Returns the sub elements as array.
     *
     * @param a
     * @param <T>
     * @return array of sub elements
     */
    @Override
    public <T> T[] toArray(T[] a) {
        for(int i = 0; i < list.size(); i++){
            a[i] = (T) get(i);
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException(ONLY_READ_AND_DELETE);
    }

    /**
     * Removes the element that contains the sub element "o".
     *
     * @param o the sub element
     * @return true if the sub element was found
     */
    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if(i != -1) {
            return list.remove(i) != null;
        } else {
            return false;
        }
    }

    /**
     * Checks if the list contains all sub elements "c".
     *
     * @param c the sub elements
     * @return true if it contains all sub elements
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean hasContainedAll = true;
        for(Object o : c){
            if(!contains(o)){
                hasContainedAll = false;
            }
        }
        return hasContainedAll;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException(ONLY_READ_AND_DELETE);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException(ONLY_READ_AND_DELETE);
    }

    /**
     * Removes all elements that contain one of the sub elements "c".
     *
     * @param c the sub elements
     * @return true if all sub elements were removed
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean hasRemovedAll = true;
        for(Object o : c){
            if(!remove(o)){
                hasRemovedAll = false;
            }
        }
        return hasRemovedAll;
    }

    /**
     * Retains only the elements in this list which sub elements of "c" that are contained in the specified collection.
     *
     * @param c the sub elements
     * @return true if the list changed
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean hasChanged = false;
        for(Object o : c){
            if(contains(o)){
                remove(o);
                hasChanged = true;
            }
        }
        return hasChanged;
    }

    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Compares the sub elements of this list with the given list "o".
     *
     * @param o the Object to be compared with
     * @return true if sub elements are equals to elements of "o"
     */
    @Generated("method")
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof List))
            return false;

        Iterator<E> e1 = iterator();
        Iterator e2 = ((List) o).iterator();
        while(e1.hasNext() && e2.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Generated("method")
    @Override
    public int hashCode() {
        int hashCode = 1;
        Iterator<E> i = iterator();
        while (i.hasNext()) {
            E obj = i.next();
            hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    /**
     * Returns the sub element of the list element at the index.
     *
     * @param index the index
     * @return the sub element at index
     */
    @Override
    public E get(int index) {
        Object o = list.get(index);
        return getInvoke(o);
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException(ONLY_READ_AND_DELETE);
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException(ONLY_READ_AND_DELETE);
    }

    /**
     * Removes the list element at position index.
     *
     * @param index the position
     * @return the sub element of the removed element
     */
    @Override
    public E remove(int index) {
        Object o = list.get(index);
        E element = getInvoke(o);
        list.remove(index);
        return element;
    }

    private E getInvoke(Object o) {
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
     * Returns the index of for the element that holds the searched sub element "o".
     *
     * @param o the sub element
     * @return the index
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < list.size(); i++) {
                Object current = list.get(i);
                if (getInvoke(current) == null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                Object current = list.get(i);
                if (o.equals(getInvoke(current))){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = list.size()-1; i >= 0; i--){
                Object current = list.get(i);
                if (getInvoke(current)==null){
                    return i;
                }
            }
        } else {
            for (int i = list.size()-1; i >= 0; i--){
                Object current = list.get(i);
                if (o.equals(getInvoke(current))){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException(ONLY_ITERATOR);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException(ONLY_ITERATOR);
    }

    /**
     * Returns a sub list of the current list.
     *
     * @param fromIndex the start index
     * @param toIndex the last index
     * @return th sub list
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return new SubElementList<E>(list.subList(fromIndex, toIndex), getMethod);
    }

    /**
     * Returns the parent list.
     *
     * @return the parent list
     */
    public <T> List<T> getParentList(){
        return (ArrayList<T>) new ArrayList<T>(list);
    }

    @Override
    public SubElementList<E> clone(){
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            LOGGER.error(COULDN_T_CLONE_SUB_ELEMENT_LIST, e);
        }
        return new SubElementList<E>((ArrayList) new ArrayList(list).clone(), getMethod);
    }
}