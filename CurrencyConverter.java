import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Exchange rates with respect to USD
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("AUD", 1.35);
        exchangeRates.put("CAD", 1.25);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter");

        while (true) {
            System.out.println("\nAvailable currencies: " + exchangeRates.keySet());
            System.out.print("Enter source currency (or type 'exit' to quit): ");
            String sourceCurrency = scanner.nextLine().toUpperCase();
            if (sourceCurrency.equals("EXIT")) {
                break;
            }

            if (!exchangeRates.containsKey(sourceCurrency)) {
                System.out.println("Invalid source currency. Please try again.");
                continue;
            }

            System.out.print("Enter target currency: ");
            String targetCurrency = scanner.nextLine().toUpperCase();
            if (!exchangeRates.containsKey(targetCurrency)) {
                System.out.println("Invalid target currency. Please try again.");
                continue;
            }

            System.out.print("Enter amount in " + sourceCurrency + ": ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            double convertedAmount = convertCurrency(sourceCurrency, targetCurrency, amount);
            System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, sourceCurrency, convertedAmount, targetCurrency);
        }

        scanner.close();
        System.out.println("Thank you for using the Currency Converter");
    }

    private static double convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        return amount * (targetRate / sourceRate);
    }
}