/**
 * Observer Design pattern
 *
 * Author: Derek Banas
 */

// Observer is the subscriber
public interface Observer {
    // Publisher of Subject will call each observer's update to publish data
    void update(double ibmPrice, double aaplPrice, double googPrice);
}
