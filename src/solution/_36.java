package solution;

import java.util.HashSet;
import java.util.Set;

public class _36 {

    private boolean checkBox(char[][] board, int x, int y) {
        Set<Character> charSet = new HashSet<>();

        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; y++) {
                if (board[i][j] == '.') continue;

                if (charSet.contains(board[i][j])) {
                    return false;
                }

                charSet.add(board[i][j]);
            }
        }

        return true;
    }

    private boolean checkVertical(char[][] board, int y) {
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == '.') continue;

            if (charSet.contains(board[i][y])) {
                return false;
            }

            charSet.add(board[i][y]);
        }

        return true;
    }

    private boolean checkHorizontal(char[][] board, int x) {
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == '.') continue;

            if (charSet.contains(board[x][i])) {
                return false;
            }

            charSet.add(board[x][i]);
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!checkVertical(board, i)) return false;
            if (!checkHorizontal(board, i)) return false;
        }

        boolean top = checkBox(board, 0, 0) && checkBox(board, 3, 0) && checkBox(board, 6, 0);
        if (!top) return false;

        boolean mid = checkBox(board, 0, 3) && checkBox(board, 3, 3) && checkBox(board, 6, 3);
        if (!mid) return false;

        boolean bot = checkBox(board, 0, 6) && checkBox(board, 3, 6) && checkBox(board, 6, 6);
        if (!bot) return false;

        return true;
    }
}
