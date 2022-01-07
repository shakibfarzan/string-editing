public class StringEditingTab extends StringEditing {

    public StringEditingTab(String str1, String str2) {
        super(str1, str2);
    }

    @Override
    public int solve() {
        if (str1.length() == 0 && str2.length() == 0) return 0;

        for (int i = 0; i < costs.length; i++) {
            costs[i][0] = i;
        }

        for (int j = 0; j < costs[0].length; j++) {
            costs[0][j] = j;
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 1; j < costs[0].length; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) costs[i][j] = costs[i - 1][j - 1];
                else costs[i][j] = min(costs[i - 1][j] + 1, costs[i - 1][j - 1] + 2, costs[i][j - 1] + 1);
            }
        }
        return costs[str1.length()][str2.length()];
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
                if (disConvert > disDelete && disConvert > disInsert) {
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
