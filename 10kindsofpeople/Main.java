import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Main
{
    public static int UNKNOWN = -1;

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        Location[][] map = new Location[rows][cols];
        for(int r = 0; r < rows; r++) {
            String row = scn.next();
            for(int c = 0; c < cols; c++) {
                map[r][c] = new Location(r, c, (int)(row.charAt(c) - '0'));
            }
        }
        int numQueries = scn.nextInt();
        int[][] queries = new int[numQueries][4];
        for(int i = 0; i < numQueries; i++) {
            for(int j = 0; j < 4; j++) {
                queries[i][j] = scn.nextInt()-1;
            }
        }

        int currRegion = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(map[r][c].region == UNKNOWN) {
                    int targetLabel = map[r][c].label;
                    map[r][c].region = currRegion;
                    Stack<Location> toVisit = new Stack<>();
                    toVisit.push(map[r][c]);
                    while(!toVisit.isEmpty()) {
                        Location loc = toVisit.pop();
                        int row = loc.r;
                        int col = loc.c;
                        for(int d = -1; d <= 1; d++) {
                            if(row+d >= 0 && row+d < rows &&
                                    map[row+d][col].label == targetLabel && map[row+d][col].region == UNKNOWN) {
                                toVisit.push(map[row+d][col]);
                                map[row+d][col].region = currRegion;
                            }
                            if(col+d >= 0 && col+d < cols &&
                                    map[row][col+d].label == targetLabel && map[row][col+d].region == UNKNOWN) {
                                toVisit.push(map[row][col+d]);
                                map[row][col+d].region = currRegion;
                            }
                        }
                    }
                    currRegion++;
                }
            }
        }

        for(int i = 0; i < numQueries; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            Location loc1 = map[r1][c1];
            Location loc2 = map[r2][c2];
            if(loc1.region == loc2.region) {
                System.out.println(loc1.label == 0 ? "binary" : "decimal");
            } else {
                System.out.println("neither");
            }
        }
    }

    static class Location {
        public int r;
        public int c;
        public int label;
        public int region;

        public Location(int row, int col, int label) {
            this.r = row;
            this.c = col;
            this.label = label;
            this.region = UNKNOWN;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Location)) {
                return false;
            }
            Location other = (Location)o;
            return this.r == other.r && this.c == other.c;
        }

        @Override
        public int hashCode() {
            return this.r * 1000 + this.c;
        }
    }
}
