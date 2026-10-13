
package com.harsh.sadp.iterator;

import java.util.NoSuchElementException;

public class DinnerMenu {

    private final MenuItem[] items = {
            new MenuItem("Chapati Bhaji", 70),
            new MenuItem("Veg Pulao", 90),
            new MenuItem("Masala Dosa", 85)
    };

    public MenuIterator createIterator() {
        return new MenuIterator() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < items.length;
            }

            @Override
            public MenuItem next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return items[position++];
            }
        };
    }
}
