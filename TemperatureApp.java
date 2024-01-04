import java.util.*;

public class TemperatureApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature value: ");
        double temperature = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the orginial unit (c/f/k) :");
        String originalUnit = sc.nextLine().toUpperCase();
        switch (originalUnit) {
            case "C":
                convertCelsius(temperature);
                break;
            case "F":
                convertFahrenheit(temperature);
                break;
            case "K":
                convertKelvin(temperature);
                break;
            default:
                System.out.println("Invalid unit. Please enter C, F, or K.");
        }
        sc.close();
    }

    private static void convertCelsius(double celsisus) {
        double fahrenheit = (celsisus * 9 / 5) + 32;
        double kelvin = celsisus + 273.15;
        System.out.println("Temperature in Fahrenheit :" + fahrenheit);
        System.out.println("Temperature in Kelvin" + kelvin);
    }

    private static void convertFahrenheit(double fahrenheit) {
        double celsisus = (fahrenheit - 32) * 35 / 9;
        double Kelvin = (fahrenheit + 459.67) * 5 / 9;
        System.out.println("Temperature in Celsius :" + celsisus);
        System.out.println("Temperature in Kelvin" + Kelvin);
    }

    private static void convertKelvin(double kelvin) {
        double celsisus = (kelvin - 273.15);
        double fahrenheit = (kelvin * 9 / 5) * 459.67;
        System.out.println("Temperature in Celsius :" + celsisus);
        System.out.println("Temperature in Fahrenheit" + fahrenheit);

    }
}