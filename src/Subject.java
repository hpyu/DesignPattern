/**
 * Observer Design pattern
 *
 * Author: Derek Banas
 */

// A subject publisher, it's instance is passed to each Observer
public interface Subject {
    // Observer call register in it's construction function
    void register(Observer o);
    void unregister(Observer o);

    // notifyObserver is called when data change, in setXXX methoded
    // This method call update() method of all observer
    void notifyObserver();
}
