import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int boardSize = scn.nextInt();
        int square = scn.nextInt() - 1;
        int magicNumber = scn.nextInt();
        int[] board = new int[boardSize];
        boolean[] visited = new boolean[boardSize];
        for(int i = 0; i < boardSize; i++) {
            board[i] = scn.nextInt();
            visited[i] = false;
        }

        int hopCount = 0;
        GameState gamestate = GameState.IN_PROGRESS;
        while(gamestate == GameState.IN_PROGRESS) {
            if(square < 0) {
                gamestate = GameState.LEFT;
            } else if(square >= boardSize) {
                gamestate = GameState.RIGHT;
            } else if(board[square] == magicNumber) {
                gamestate = GameState.MAGIC;
            } else if(visited[square]) {
                gamestate = GameState.CYCLE;
            } else {
                visited[square] = true;
                square += board[square];
                hopCount++;
            }
        }
        System.out.println(gamestate.name().toLowerCase());
        System.out.println(hopCount);
    }

    enum GameState {
        IN_PROGRESS, LEFT, RIGHT, CYCLE, MAGIC;
    }
}
