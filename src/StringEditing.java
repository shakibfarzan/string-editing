public abstract class StringEditing {
    protected int[][] costs;
    protected String str1;
    protected String str2;

    public StringEditing(String str1, String str2){
        costs = new int[str1.length()+1][str2.length()+1];
        this.str1 = str1;
        this.str2 = str2;
    }
    public static int min(int c1, int c2, int c3){
        int f = Math.min(c1, c2);
        return Math.min(f, c3);
    }

    public abstract int solve();
    public void print(){
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                System.out.print(costs[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public abstract void getAnswer();
}
