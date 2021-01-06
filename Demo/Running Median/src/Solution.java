import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {


    private static void printIntArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(double[] array) {
        for (double a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {

        double[] input = new double[a.length];
        int[] aux = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                aux[i] = a[i];
            }

            boolean findPos = true;
            int posAux = i;
            int menor;
            int newNumber = a[i];

            while (findPos && posAux != 0) {
                posAux = posAux - 1;
                menor = aux[posAux];

                if (newNumber < menor) {
                    aux[posAux + 1] = menor;

                    if (posAux == 0) {
                        aux[posAux] = newNumber;
                        findPos = false;
                    }
                } else {
                    aux[posAux + 1] = newNumber;
                    findPos = false;
                }
            }

            printIntArray(aux);

            if (i % 2 == 0) {
                int pos = i / 2;
                input[i] = aux[pos] / 1.0;
            } else {
                int posSuperior = i / 2;
                int posInferior = (int) Math.ceil((double) i / 2);
                input[i] = (aux[posInferior] + aux[posSuperior]) / 2.0;
            }
        }

        return input;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/Users/marif/Documents/Codigos/GitHub/Amazon-Studies/Problemas/Running Median/src/output.txt"));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
