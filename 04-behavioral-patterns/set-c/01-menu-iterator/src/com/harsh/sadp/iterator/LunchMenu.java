
package com.harsh.sadp.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LunchMenu {

    private final List<MenuItem> items = new ArrayList<>();

    public LunchMenu() {
        items.add(new MenuItem("Veg Thali", 120));
        items.add(new MenuItem("Paneer Rice", 100));
        items.add(new MenuItem("Dal Khichdi", 80));
    }

    public MenuIterator createIterator() {
        return new MenuIterator() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < items.size();
            }

            @Override
            public MenuItem next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return items.get(position++);
            }
        };
    }
}
