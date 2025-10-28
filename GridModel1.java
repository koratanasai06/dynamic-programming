package topdown;

import java.util.*;

public class GridModel1 {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            Pair p = (Pair) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int[][] memo = new int[2][2];
    static Set<Pair> inValidPaths = new HashSet<>();

    public static void main(String[] args) {
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Block all cells from (1,1) to (100,100)
//        for (int i = 1; i < 100; i++) {
//            for (int j = 1; j < 100; j++) {
//                inValidPaths.add(new Pair(i, j));
//            }
//        }
        inValidPaths.add(new Pair(1, 0));

        int res = countPaths(1,1);
        System.out.println("Number of valid paths: " + res);
    }

    static int countPaths(int x, int y) {
        if (inValidPaths.contains(new Pair(x, y))) {
            return 0; // blocked cell
        }
        if (x == 0 && y == 0) {
            return 1; // start point
        }
        if (x < 0 || y < 0) {
            return 0; // out of bounds
        }
        if (memo[x][y] == -1) {
            memo[x][y] = countPaths(x-1,y-1)+countPaths(x - 1, y) + countPaths(x, y - 1);
        }
        return memo[x][y];
    }
}
