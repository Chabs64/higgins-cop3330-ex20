package org.example;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Chad Higgins
 */

/*
More complex programs may have decisions nested in other decisions, so that when one decision is made,
additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state.
The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge.
For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.

Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);

        System.out.println("What is the order amount? ");
        BigDecimal amount = new BigDecimal(in.nextLine());
        System.out.println("What state do you live in? ");
        String state = in.nextLine();

        double taxRate = 0.00;
        BigDecimal taxAmount = new BigDecimal("0");
        BigDecimal total = new BigDecimal("0");

        if(state.equals("Wisconsin"))
        {
            System.out.println("What county do you live in?");
            String county = in.nextLine();

            if(county.equals("Eau Claire"))
            {
                taxRate += 0.005;
            }
            else if(county.equals("Dunn"))
            {
                taxRate += 0.004;
            }

            taxRate += 0.05;
            taxAmount = amount.multiply(new BigDecimal(taxRate));
            total = amount.add(taxAmount);
            System.out.println("The tax is $"+taxAmount.setScale(2,RoundingMode.HALF_UP)+".\n" +
                    "The total is $"+total.setScale(2,RoundingMode.HALF_UP)+".");
        }
        else if(state.equals("Illinois"))
        {
            taxRate += 0.08;
            taxAmount = amount.multiply(new BigDecimal(taxRate));
            total = amount.add(taxAmount);
            System.out.println("The tax is $"+taxAmount.setScale(2,RoundingMode.HALF_UP)+".\n" +
                    "The total is $"+total.setScale(2,RoundingMode.HALF_UP)+".");
        }
        else
        {
            taxAmount = amount.multiply(new BigDecimal(taxRate));
            total = amount.add(taxAmount);
            System.out.println("The total is $"+total.setScale(2,RoundingMode.HALF_UP)+".");
        }
    }
}
