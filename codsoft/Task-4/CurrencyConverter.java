import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;     //https://github.com/stleary/JSON-java -JSON in Java

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.print("Enter the source currency code (e.g., USD): ");
        String sourceCurrencyCode = scanner.next();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrencyCode = scanner.next();

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        try {
            String apiUrl = "https://open.er-api.com/v6/latest/" + sourceCurrencyCode;
            URL url = new URL(apiUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                double convertedAmount = getConvertedAmount(conn, targetCurrencyCode, amount);

                System.out.println("Converted Amount from " + sourceCurrencyCode + " to " + targetCurrencyCode + ": " + convertedAmount);
            } else {
                System.out.println("API request failed");
            }

            // Close the connection
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static double getConvertedAmount(HttpsURLConnection conn, String targetCurrencyCode, double amount) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        String baseCode = jsonResponse.getString("base_code");
        JSONObject rates = jsonResponse.getJSONObject("rates");

        // Convert the amount to the target currency
        double exchangeRate = rates.getDouble(targetCurrencyCode);
        double convertedAmount = amount * exchangeRate;
        return convertedAmount;
    }
}
