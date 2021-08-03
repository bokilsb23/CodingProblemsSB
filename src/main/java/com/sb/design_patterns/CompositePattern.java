package com.sb.design_patterns;

import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {

    default int sum() {
        int sum = 0;
        Iterator<Integer> iterator = this.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }
}

class SingleValue implements ValueContainer {
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value) {
        this.value = value;
    }

    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }

    public void forEach(Consumer<? super Integer> action) {
        action.accept(value);
    }

    public Spliterator<Integer> spliterator() {
        return Collections.singleton(value).spliterator();
    }
}

/*class ManyValues extends ArrayList<Integer> implements com.sb.designPatterns.ValueContainer
{
}

public ColoredShape(Supplier<? extends T> ctor){
    ctor.get();
}
ColoredShape<Square> square = new ColoredShape(
        () -> new Square(20), "abc"
);*/

class MyList extends ArrayList<ValueContainer> {
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        Iterator<ValueContainer> iterator = this.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next().sum();
        }
        return sum;
    }
}