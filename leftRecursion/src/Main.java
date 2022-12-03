import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    static int count = 1;
    static String[] productionRules;
    public static void main(String[] args) {
        int n;
        System.out.println("Enter number of production rules");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        productionRules = new String[n];
        //String a = "A = ABa|Aa|a";
        for(int i=0;i<n;i++)
        {
            generateRules();
        }


    }
    public static void generateRules() {
        int recursionCount = 0;
        System.out.println("\nEnter production rules no " + count);
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        productionRules[count - 1] = a;
        count++;
        List<String> alpha = new ArrayList<String>();
        List<String> bita = new ArrayList<String>();
        String s[] = a.split(" |\\|");
        String start = s[0];
        for (int i = 2; i < s.length; i++) {
            StringBuilder sb = new StringBuilder(s[i]);

            //making alpha
            if (s[i].startsWith(start)) {
                sb.delete(0, start.length());
                alpha.add(sb.toString());
                recursionCount++;
            } else {
                bita.add(s[i]);
            }
        }
        if (recursionCount != 0) {
            String[] mAlphas = new String[alpha.size()];
            String[] mBitas = new String[bita.size()];
            for (int i = 0; i < mAlphas.length; i++) {
                mAlphas[i] = alpha.get(i).toString().replace("[", "").replace("]", "");
            }
            for (int i = 0; i < mBitas.length; i++) {
                mBitas[i] = bita.get(i).toString().replace("[", "").replace("]", "");
            }
//        System.out.println("Previous rule is:");
//        System.out.println(a);
//        System.out.println("------------------");
//        System.out.println("New rule is:");
            System.out.print(start + "=");
            for (int i = 0; i < mBitas.length; i++) {
                if (i != mBitas.length - 1) {
                    System.out.print(mBitas[i] + start + "'" + "|");
                } else {
                    System.out.print(mBitas[i] + start + "'");
                }
            }
            System.out.println();
            System.out.print(start + "'" + "=\u03B5");
            for (int i = 0; i < mAlphas.length; i++) {
                System.out.print("|" + mAlphas[i] + start + "'");
            }
        }
        else {
            System.out.println("No left recursion detected!");
        }
    }

}
//E = E + T|T
//T = T * F|F
//F = (E)|id
