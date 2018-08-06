import jdk.nashorn.internal.runtime.StoredScript;

import java.util.ArrayList;

/**
 * Observer Design pattern
 *
 * Author: Derek Banas
 */
public class StockGrabber implements Subject{
    // use ArrayList to keep all observers
    private final ArrayList<Observer> observers;

    // Data to be published
    // This part is duplicated with StockObserver, can abstract to a class
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {
        // ArrayList an expand automatically
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer " + (observerIndex+1) + " deleted");
        observers.remove(deleteObserver);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(ibmPrice, aaplPrice, googPrice);
        }
    }

    // These setXXX methods are called by main program
    // Call remove notifyObserver, and let main program call notifyObserver
    public void setIbmPrice(double newIbmPrice) {
        this.ibmPrice = newIbmPrice;
        notifyObserver();
    }
    public void setAaplPrice(double newAaplPrice) {
        this.aaplPrice = newAaplPrice;
        notifyObserver();
    }
    public void setGoogPrice(double newGoogPrice) {
        this.googPrice = newGoogPrice;
        notifyObserver();
    }
}
