public class NQbacktracking {
    int[] ld, rd, cl;
    int x, y;

    public NQbacktracking(int x_, int y_) {
        ld = new int[30];
        rd = new int[30];
        cl = new int[30];
        this.x = x_;
        this.y = y_;
    }

    void printSolution(int[][] board) {
        System.out.println("N Queen Backtracking Solution:\nGiven initial position of 1st queen at row: " + x + 
                           ", column: " + y + "\n");
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    boolean solveNQUtil(int[][] board, int col) {
        int N = board.length;
        if (col >= N) {
            return true;
        }

        if (col == y) {
            return solveNQUtil(board, col + 1);
        }

        for (int i = 0; i < N; i++) {
            if (i == x) {
                continue;
            }

            if (ld[i - col + N - 1] != 1 && rd[i + col] != 1 && cl[i] != 1) {
                board[i][col] = 1;
                ld[i - col + N - 1] = rd[i + col] = cl[i] = 1;

                if (solveNQUtil(board, col + 1)) {
                    return true;
                }

                // BACKTRACK
                board[i][col] = 0;
                ld[i - col + N - 1] = rd[i + col] = cl[i] = 0;
            }
        }
        return false;
    }

    boolean solveNQ() {
        int N = 8; // Board size (N x N)
        int[][] board = new int[N][N];

        // Place initial queen and mark attack paths
        board[x][y] = 1;
        ld[x - y + N - 1] = rd[x + y] = cl[x] = 1;

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        int N = 8; // Board size (N x N)
        int x = 1; // Initial position row (0-based index)
        int y = 3; // Initial position column (0-based index)

        NQbacktracking NQBt = new NQbacktracking(x, y);
        NQBt.solveNQ();
    }
}
