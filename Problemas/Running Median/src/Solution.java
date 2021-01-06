import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {




    /*
     * Complete the runningMedian function below.
     */
    static int runningMedian(int numOfParts, List<Integer> parts) {

        int result = 0;

        if (numOfParts > 1) {

            while (!parts.isEmpty()) {

                int  small1 = parts.get(0), small2 = parts.get(1), number;
                int index1 = 0, index2 = 1;

                System.out.println("Vetor: " + parts);


                if (numOfParts == 2) {
                    result += small1 + small2;
                    parts.remove(index1);
                    parts.remove(index2-1);

                    return result;
                }

                if (small1<small2){
                    small1 = parts.get(1); small2 = parts.get(0);
                    index1 = 1; index2 = 0;
                }

                for (int i = 2; i < numOfParts; i++) {
                    System.out.println("small1: " + small1 + " small2: " + small2);
                    number = parts.get(i);

                    System.out.println("number: " + number);

                    if (number<small1){
                        small1 = number;
                        index1= i;
                    }else{
                        if(number<small2){
                            small2 = number;
                            index2 = i;
                        }
                    }
                }

                System.out.println("small1: " + small1 + " small2: " + small2);

                int minActualResult = small1 + small2;

                result += minActualResult;
                parts.remove(index1);
                if(index1<=index2) {
                    index2--;
                }
                parts.remove(index2);
                parts.add(minActualResult);

                numOfParts--;
            }

        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        List<Integer> entrada = new ArrayList<>();
        entrada.add(1);
        entrada.add(4);
        entrada.add(2);

        System.out.println("Entrada: " + entrada);
        System.out.println("Resultado: " + runningMedian(3, entrada));


    }
}
