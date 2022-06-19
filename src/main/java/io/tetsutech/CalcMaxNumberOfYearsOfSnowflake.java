package io.tetsutech;

import java.math.BigInteger;

public class CalcMaxNumberOfYearsOfSnowflake {
  public static void main(String[] args) {
    //41 bit binary minimum
    String minTimeStampStr = "00000000000000000000000000000000000000000";
    //41 bit binary maximum
    String maxTimeStampStr = "11111111111111111111111111111111111111111";
    //Convert to decimal
    long minTimeStamp = new BigInteger(minTimeStampStr, 2).longValue();
    long maxTimeStamp = new BigInteger(maxTimeStampStr, 2).longValue();

    System.out.println(maxTimeStampStr.length());

    System.out.println("minTimeStamp " + minTimeStamp);
    System.out.println("maxTimeStamp " + maxTimeStamp);

    //How many milliseconds are there in a year
    long oneYearMills = 1L * 1000 * 60 * 60 * 24 * 365;
    //Calculate the maximum number of years
    System.out.println((maxTimeStamp - minTimeStamp) / oneYearMills);
 }
}
