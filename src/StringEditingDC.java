public class StringEditingDC extends StringEditing {

    public StringEditingDC(String str1, String str2) {
        super(str1, str2);
    }

    @Override
    public int solve() {
        return solve(str1.length(), str2.length());
    }

    private int solve(int i, int j) {
        if (i == 0 && j == 0) return 0;
        if (j == 0) return solve(i - 1, 0) + 1;
        if (i == 0) return solve(0, j - 1) + 1;
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) return solve(i - 1, j - 1);
        return min(solve(i - 1, j) + 1, solve(i - 1, j - 1) + 2, solve(i, j - 1) + 1);
    }

    @Override
    public void getAnswer() {
//        it isn't implemented for this class
    }
}
