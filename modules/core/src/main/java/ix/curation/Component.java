package ix.curation;

import java.util.Set;
import java.util.stream.Stream;

/**
 * A (connected) component is a set of linked nodes within a graph
 */
public interface Component extends Iterable<Entity> {
    /*
     * a unique id associated with this component
     */
    String getId (); 
    
    /*
     * the component size (number of nodes/entities)
     */
    int size ();

    /*
     * return the set of node ids
     */
    Set<Long> nodes ();

    /*
     * return all entities for this component.
     */
    Entity[] entities ();

    default boolean overlaps (Component c) {
        Set<Long> nodes = nodes();
        for (Long n : c.nodes())
            if (nodes.contains(n))
                return true;
        return false;
    }

    /*
     * create a new component that is the xor of the given component
     * and this component
     */    
    default Component xor (Component c) {
        throw new UnsupportedOperationException
            ("xor() is not supported for this implementation");
    }
    
    /*
     * create a new component that is the intersection of the given
     * component and this component
     */
    default Component and (Component c) {
        throw new UnsupportedOperationException
            ("and() is not supported for this implementation");
    }

    /*
     * create a new component that is a union of the given component 
     * and this component
     */
    default <T extends Component> T add (T c) {
        throw new UnsupportedOperationException
            ("add() is not supported for this implementation");
    }

    default Stream<Entity> stream () {
        return Stream.of(entities ());
    }
    /*
     * return the score for this component
     */
    default Double score () { return null; }
}
