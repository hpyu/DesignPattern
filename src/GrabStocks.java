/**
 * Observer Design pattern
 *
 * Author: Derek Banas
 */

public class GrabStocks {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setAaplPrice(677.00);
        stockGrabber.setGoogPrice(666.00);

        StockObserver observer2 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setAaplPrice(677.00);
        stockGrabber.setGoogPrice(666.00);
    }
}
