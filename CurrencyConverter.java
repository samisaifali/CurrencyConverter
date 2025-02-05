import java.util.Scanner;

public class CurrencyConverter {
    // Exchange rates (1 unit of the given currency to USD)
    static final double USD_TO_EUR = 0.85;
    static final double USD_TO_GBP = 0.75;
    static final double USD_TO_INR = 74.50;
    static final double USD_TO_JPY = 110.25;
    static final double USD_TO_CAD = 1.25; // Added CAD exchange rate

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available currencies
        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available Currencies: USD, EUR, GBP, INR, JPY, CAD");
        
        // User selects input currency
        System.out.print("Enter the currency you have (USD, EUR, GBP, INR, JPY, CAD): ");
        String fromCurrency = scanner.next().toUpperCase();
        
        // User selects output currency
        System.out.print("Enter the currency you want to convert to (USD, EUR, GBP, INR, JPY, CAD): ");
        String toCurrency = scanner.next().toUpperCase();
        
        // User inputs the amount
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        // Convert the amount
        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
        
        // Output result
        if (convertedAmount == -1) {
            System.out.println("Invalid currency selection. Please try again.");
        } else {
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, toCurrency);
        }

        scanner.close();
    }

    public static double convertCurrency(String from, String to, double amount) {
        // Convert input currency to USD first
        double amountInUSD = switch (from) {
            case "USD" -> amount;
            case "EUR" -> amount / USD_TO_EUR;
            case "GBP" -> amount / USD_TO_GBP;
            case "INR" -> amount / USD_TO_INR;
            case "JPY" -> amount / USD_TO_JPY;
            case "CAD" -> amount / USD_TO_CAD; // Added CAD conversion
            default -> -1; // Invalid currency
        };

        if (amountInUSD == -1) return -1; // Invalid input currency

        // Convert from USD to target currency
        return switch (to) {
            case "USD" -> amountInUSD;
            case "EUR" -> amountInUSD * USD_TO_EUR;
            case "GBP" -> amountInUSD * USD_TO_GBP;
            case "INR" -> amountInUSD * USD_TO_INR;
            case "JPY" -> amountInUSD * USD_TO_JPY;
            case "CAD" -> amountInUSD * USD_TO_CAD; // Added CAD conversion
            default -> -1; // Invalid target currency
        };
    }
}
