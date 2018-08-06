/**
 * Observer Design pattern
 *
 * Author: Derek Banas
 */

/**
 * {@code StockObserver} is the concrete class that represent an observer who
 * is interested in stock data
 */
public class StockObserver implements Observer{
    // Data to be observed
    // This can be different to Subject, if observer is only interested in
    // part of the data
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    // Global variable that track the observers number, also used to create ID.
    static int observerIDTrack = 0;
    private int observerID;

    // Each observer has the Subject object, which is passed when constructed
    // It's defined as final since the Subject class won't change
    private final Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTrack;
        System.out.println("New Observer: " + this.observerID);
        stockGrabber.register(this);
    }

    @Override
    // update() is called in notifyObserver, traverse and call update of each
    // observer
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printThePrices();
    }
    private void printThePrices() {
        System.out.println(observerID + "\nIBM: " + ibmPrice + "\nAAPL: " +
                aaplPrice + "\nGOOG: " + googPrice);
    }
}
