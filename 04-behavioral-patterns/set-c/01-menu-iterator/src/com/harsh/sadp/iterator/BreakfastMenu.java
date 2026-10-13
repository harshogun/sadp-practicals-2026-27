
package com.harsh.sadp.iterator;

public class BreakfastMenu {

    private final MenuItem[] items = {
            new MenuItem("Poha", 30),
            new MenuItem("Upma", 35),
            new MenuItem("Idli", 40)
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
                    throw new java.util.NoSuchElementException();
                }
                return items[position++];
            }
        };
    }
}
