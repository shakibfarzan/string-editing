import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Coordinator {
    private String generateRandomString(int length){
        char[] charArray = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = ((int) (Math.random() * 26)) + 97;
            charArray[i] = (char) (rand);
        }
        return String.valueOf(charArray);
    }

    private long getTime(){
        return System.nanoTime();
    }

    public void experiment(int n, int maxRep) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputB.txt"));
        for (int num = 10; num<= n; num+=10){
            for (int rep = 0; rep<maxRep; rep++){
                System.out.println("Testing n= "+num);

                String str1 = generateRandomString(num);
                String str2 = generateRandomString(num/2);

                StringEditingDC stringEditingDC = new StringEditingDC(str1,str2);
                StringEditingMem stringEditingMem = new StringEditingMem(str1,str2);
                StringEditingTab stringEditingTab = new StringEditingTab(str1,str2);

                ArrayList<StringEditing> methods = new ArrayList<>();
//                methods.add(stringEditingDC);
                methods.add(stringEditingMem);
                methods.add(stringEditingTab);

                writer.write(num+",");

                for (StringEditing method: methods){
                    long begin = getTime();
                    int val = method.solve();
                    long finish = getTime();
                    writer.write((finish - begin)+",");
                    writer.write(val+",");
                }
                writer.write("\n");
            }
        }
        writer.close();
    }
}
