package com.practice.random;

import java.text.DecimalFormat;

public class SIPTracker {

    public static void main(String[] args) {
        int startAge = 25;
        int retirementAge = 45;
        int years = (retirementAge - startAge);
        double sip = 7500; // Initial monthly SIP
        double annualIncrementRate = 0.1; // 10% step-up
        double annualReturn = 0.15; // 15% expected return
        double monthlyReturn = Math.pow(1 + annualReturn, 1.0 / 12) - 1;

        double totalInvested = 0;
        double corpus = 0;

        DecimalFormat df = new DecimalFormat("#,##,###.00");

        System.out.println("Age\tMonthly SIP\tTotal Invested\tEstimated Corpus");
        System.out.println("```\t``````````\t`````````````\t```````````````");
        for (int year = 1; year <= years; year++) {
            for (int month = 1; month <= 12; month++) {
                totalInvested += sip;
                corpus = (corpus + sip) * (1 + monthlyReturn);
            }

            int currentAge = startAge + year - 1;
            System.out.println(currentAge + "\t₹" + df.format(sip) + "\t₹" + df.format(totalInvested) + "\t₹" + df.format(corpus));
            
            sip = sip * (1 + annualIncrementRate); // Step up SIP annually
        }
        System.out.println();
        System.out.println("total number of years invested: " + years);
    }
}
