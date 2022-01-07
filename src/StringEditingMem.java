import java.util.Arrays;

public class StringEditingMem extends StringEditing {

    public StringEditingMem(String str1, String str2) {
        super(str1, str2);
    }

    @Override
    public int solve() {
        return solve(str1.length(), str2.length());
    }

    private int solve(int i, int j) {
        if (i == 0 && j == 0) return 0;

        if (costs[i][j] != 0) return costs[i][j];

        if (j == 0) {
            costs[i][j] = solve(i - 1, 0) + 1;
        } else if (i == 0) {
            costs[i][j] = solve(0, j - 1) + 1;
        } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            costs[i][j] = solve(i - 1, j - 1);
        } else {
            costs[i][j] = min(solve(i - 1, j) + 1, solve(i - 1, j - 1) + 2, solve(i, j - 1) + 1);
        }
        return costs[i][j];
    }

    @Override
    public void getAnswer() {
        int i = costs.length - 1;
        int j = costs[0].length - 1;
        int currentRes = costs[i][j];
        while (currentRes > 0) {
            if (i == 0) {
                System.out.println("Index: " + 0 + " -> Insert");
                currentRes = costs[0][--j];
            } else if (j == 0) {
                System.out.println("Index: " + (i - 1) + " -> Delete");
                currentRes = costs[--i][0];
            } else {
                int delete = costs[i - 1][j], convert = costs[i - 1][j - 1], insert = costs[i][j - 1],
                        disDelete = currentRes - delete, disConvert = currentRes - convert, disInsert = currentRes - insert;
                if ((delete==0 && insert == 0)||disConvert > disDelete && disConvert > disInsert) {
                    if (disConvert != 0) System.out.println("Index: " + (i - 1) + " -> Convert");
                    currentRes = convert;
                    i--;
                    j--;
                } else if (disDelete > disInsert) {
                    System.out.println("Index: " + (i - 1) + " -> Delete");
                    currentRes = delete;
                    i--;
                } else {
                    System.out.println("Index: " + (i - 1) + " -> Insert");
                    currentRes = insert;
                    j--;
                }
            }
        }
    }
}
