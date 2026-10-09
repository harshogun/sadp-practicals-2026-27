
package com.harsh.sadp.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EnumerationIterator<E> implements Iterator<E> {

    private final Enumeration<E> enumeration;

    public EnumerationIterator(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(
                "Remove is not supported"
        );
    }
}
