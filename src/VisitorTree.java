/**
 * Visitor Design Pattern
 */


/**
 * Class {@code VisitorTree} is a demo of Visitor design pattern
 */
abstract class VisitorTree<E> {
    // define two abstract methods that means to be implemented by subclass
    // or itself somewhere else??
    abstract public String toString();
    abstract public Double sum();

    // define static APi leaf()
    // leaf() and branch() are called static factory method
    public static <E> VisitorTree<E> leaf(final E e) {
        // below code is defining a nested class that extends VisitorTree<E>,
        // this class doesn't have a name, but since it override the abstract
        // methods toString() and sum(), it can be instantiated
        // with new VisitorTree<E>, it is cast to it's super class VisitorTree.
        //
        // It's just a simplified expression, since subclass won't be accessed
        // outside, no need to give it a class name
        return new VisitorTree<E>() {
            @Override
            public String toString() {
                return e.toString();
            }

            @Override
            public Double sum() {
                return ((Number)e).doubleValue();
            }
        };
    }

    public static <E> VisitorTree<E> branch(final VisitorTree<E> l,
                                            final VisitorTree<E> r) {
        return new VisitorTree<E>() {
            @Override
            public String toString() {
                return "(" + l.toString() + "_" + r.toString() + ")";
            }

            @Override
            public Double sum() {
                return l.sum() + r.sum();
            }
        };
    }
}
