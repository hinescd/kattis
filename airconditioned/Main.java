import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int numMinions = scn.nextInt();
        int[][] ranges = new int[numMinions][2];
        for(int i = 0; i < numMinions; i++) {
            ranges[i][0] = scn.nextInt();
            ranges[i][1] = scn.nextInt();
        }
        Arrays.sort(ranges, (a, b) -> a[1] - b[1]);
        int[] maxNonoverlappingFrom = new int[numMinions];
        int maxSubsetLength = 0;
        for(int i = numMinions - 1; i >= 0; i--) {
            int maxNonoverlappingAfterHere = 0;
            for(int j = i + 1; j < numMinions; j++) {
                if(ranges[j][0] > ranges[i][1]) {
                    maxNonoverlappingAfterHere = Math.max(maxNonoverlappingAfterHere, maxNonoverlappingFrom[j]);
                }
            }
            maxNonoverlappingFrom[i] = 1 + maxNonoverlappingAfterHere;
            maxSubsetLength = Math.max(maxSubsetLength, maxNonoverlappingFrom[i]);
        }
        System.out.println(maxSubsetLength);
    }
}
