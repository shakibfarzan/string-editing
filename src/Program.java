import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        test();
//        Coordinator coordinator = new Coordinator();
//        try {
//            coordinator.experiment(1000, 50);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    static void test(String str1, String str2){
        StringEditingDC dc = new StringEditingDC(str1, str2);
        StringEditingMem mem = new StringEditingMem(str1, str2);
        StringEditingTab tab = new StringEditingTab(str1, str2);
        System.out.println("String 1:"+str1+" String 2:"+str2);
        System.out.println("String editing DC minimum cost: "+dc.solve()+"\n");
        System.out.println("String editing Memoized minimum cost: "+mem.solve());
        System.out.println("Operations/Steps:");
        mem.getAnswer();
        mem.print();
        System.out.println();
        System.out.println("String editing Tabular minimum cost: "+tab.solve());
        System.out.println("Operations/Steps:");
        tab.getAnswer();
        tab.print();
        System.out.println();
    }

    static void test(){
        test("abcdbdc","bddb");
        test("zatta","zauuaa");
        test("a", "eqxa");
        test("axxxaaass","oop");
        test("lllq","pla");
        test("qrst","wqryz");
        test("azata","t");
    }
}
