package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        menu();
    }


    public static void menu()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter your choice (1 for converting currencies, 2 for restaurant POS, 3 for exiting): ");
        String menuChoice = keyboard.next();

        while(!(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3")))
        {
            System.out.println("Please enter valid choice!!!");
            System.out.print("Please enter your choice (1 for converting currencies, 2 for restaurant POS, 3 for exiting): ");
            menuChoice = keyboard.next();
        }

        if (menuChoice.equals("3"))
            System.out.println("Bye!!!");

        while (!menuChoice.equals("3"))
        {
            if (menuChoice.equals("1"))
            {
                System.out.println();
                exchangeRate();
            }
            else
            {
                System.out.println();
                restaurantPos();
            }

            System.out.print("\nPlease enter your choice (1 for converting currencies, 2 for restaurant POS, 3 for exiting): ");
            menuChoice = keyboard.next();

            while(!(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3")))
            {
                System.out.println("Please enter valid choice!!!");
                System.out.print("Please enter your choice (1 for converting currencies, 2 for restaurant POS, 3 for exiting): ");
                menuChoice = keyboard.next();
            }

            if (menuChoice.equals("3"))
                System.out.println("Bye!!!\n");
        }
    }


    public static void exchangeRate()
    {
        Scanner keyboard = new Scanner(System.in);

        String currencyChoice = getCurrencyChoice();

        int conversionChoice = getConversionChoice();

        double currencyAmount = getCurrencyAmount();

        double exchangeAmount = getExchangeAmount(currencyChoice, conversionChoice, currencyAmount);

        System.out.println("The exchange amount is " + exchangeAmount);
    }


    public static String getCurrencyChoice()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What currency would like to convert to USD or from USD\n" +
                "(C for Canadian Dollar, E for Euro, I for Indian Rupee, J for Japanese Yen, M for Mexican Peso, B for British Pound): ");
        String currencyChoice = keyboard.next();

        return currencyChoice;
    }

    public static int getConversionChoice()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter 1 for converting to USD and 2 for converting from USD): ");
        int conversionChoice = keyboard.nextInt();

        return conversionChoice;
    }

    public static double getCurrencyAmount()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the currency amount: ");
        int currencyAmount = keyboard.nextInt();

        return currencyAmount;
    }

    public static double getExchangeAmount(String currencyChoice, int conversionChoice, double currencyAmount)
    {
        double exchangeAmount = 0;

        final double USD_TO_CAD = 0.9813,
                USD_TO_EURO = 0.757,
                USD_TO_INR = 52.53,
                USD_TO_YEN = 80.92,
                USD_TO_MXN = 13.1544,
                USD_TO_GBP = 0.6178;

        if (conversionChoice == 1) {
            switch (currencyChoice)
            {
                case "C":
                    exchangeAmount = currencyAmount / USD_TO_CAD;
                    break;

                case "E":
                    exchangeAmount = currencyAmount / USD_TO_EURO;
                    break;

                case "I":
                    exchangeAmount = currencyAmount / USD_TO_INR;
                    break;

                case "J":
                    exchangeAmount = currencyAmount / USD_TO_YEN;
                    break;

                case "M":
                    exchangeAmount = currencyAmount / USD_TO_MXN;
                    break;

                default:
                    exchangeAmount = currencyAmount / USD_TO_GBP;
                    break;
            }
        }
        else
        {
            switch (currencyChoice)
            {
                case "C":
                    exchangeAmount = currencyAmount * USD_TO_CAD;
                    break;

                case "E":
                    exchangeAmount = currencyAmount * USD_TO_EURO;
                    break;

                case "I":
                    exchangeAmount = currencyAmount * USD_TO_INR;
                    break;

                case "J":
                    exchangeAmount = currencyAmount * USD_TO_YEN;
                    break;

                case "M":
                    exchangeAmount = currencyAmount * USD_TO_MXN;
                    break;

                default:
                    exchangeAmount = currencyAmount * USD_TO_GBP;
                    break;
            }
        }

        return exchangeAmount;
    }


    public static void restaurantPos()
    {
        double foodTotal = getFoodTotal();

        double alcoholTotal = getAlcoholTotal();

        double amountDue = computeAmountDue(foodTotal, alcoholTotal);

        double amountPaid = getAmountPaid(amountDue);

        double changeDue = computeChangeDue(amountDue, amountPaid);

        System.out.println("The change due is " + changeDue);
    }

    public static double getFoodTotal()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the food total: ");
        double foodTotal = keyboard.nextDouble();

        return foodTotal;
    }

    public static double getAlcoholTotal()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the alcohol total: ");
        double alcoholTotal = keyboard.nextDouble();

        return alcoholTotal;
    }

    public static double computeAmountDue(double foodTotal, double alcoholTotal)
    {
        final double TAX = 0.09, TIP = 0.18;

        double amountDue = (foodTotal + alcoholTotal) * (1 + TAX) + foodTotal * TIP;

        System.out.println("Amount due is " + amountDue);

        return amountDue;
    }

    public static double getAmountPaid(double amountDue)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the amount paid: ");
        double amountPaid = keyboard.nextDouble();

        if (amountPaid > amountDue)
        {
            System.out.println("Amount paid is more than the amount due");
            amountPaid = amountDue;
        }

        return amountPaid;
    }

    public static double computeChangeDue(double amountDue, double amountPaid)
    {
        return amountDue - amountPaid;
    }

}