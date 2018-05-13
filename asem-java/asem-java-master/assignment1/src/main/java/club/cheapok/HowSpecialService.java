package club.cheapok;

import org.apache.commons.math3.distribution.NormalDistribution;

/*
Assume the distribution of the grades follows a Normal Distribution with mean: 9.76 and STD: 4.42
 make a function that takes as an input your grade and prints on the screen:
 the PROBABILITY you’re better than a random colleague.
*/

public class HowSpecialService {
    public static void main(String[] args) {
        double myGrade = (18.0*10)/31;
        System.out.println( howSpecialAmI(myGrade) );
    }

    /*
     * what is a normal distribution: http://mathworld.wolfram.com/NormalDistribution.html
     * classes you want to use:
     * http://commons.apache.org/proper/commons-math/javadocs/api-3.5/org/apache/commons/math3/distribution/NormalDistribution.html
     * concepts you need to grasp: cummulative distribution
     */
    private static double howSpecialAmI(double yourGrade) {
        double probability = 0;
        // your code goes here

        //18 /31

        NormalDistribution normalDistribution = new NormalDistribution(9.77,4.42);
        probability = normalDistribution.cumulativeProbability(yourGrade);

        return probability;
    }


}
