import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        scn.nextInt();
        int numInstructions = scn.nextInt();
        Map<String, String> wealthMap = new HashMap<>();
        String defaultWealth = "0";
        for(int i = 0; i < numInstructions; i++) {
            String instruction = scn.next();
            switch(instruction) {
                case "SET":
                    wealthMap.put(scn.next(), scn.next());
                    break;
                case "RESTART":
                    wealthMap = new HashMap<>();
                    defaultWealth = scn.next();
                    break;
                case "PRINT":
                    System.out.println(wealthMap.getOrDefault(scn.next(), defaultWealth));
            }
        }
    }
}
