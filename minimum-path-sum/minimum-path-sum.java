
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Input grid is null");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        if (rows == 1 && cols == 1) {
            return grid[0][0];
        }

        if (cols <= rows) {
            return minPathSumHelper(grid, rows, cols, true);
        } else {
            return minPathSumHelper(grid, cols, rows, false);
        }
    }

    private int minPathSumHelper(int[][] grid, int big, int small, boolean isColsSmall) {
        int[] dp = new int[small];
        // Process 1st small column/row
        dp[0] = grid[0][0];
        for (int j = 1; j < small; j++) {
            dp[j] = dp[j - 1] + (isColsSmall ? grid[0][j] : grid[j][0]);
        }
        // Process remaining columns/rows
        for (int i = 1; i < big; i++) {
            dp[0] += isColsSmall ? grid[i][0] : grid[0][i];
            for (int j = 1; j < small; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + (isColsSmall ? grid[i][j] : grid[j][i]);
            }
        }
        return dp[small - 1];
    }
}