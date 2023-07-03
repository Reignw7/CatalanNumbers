import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catalan {

    private long memo[] = new long[100000000+1];

    public Catalan()
    {
        for(int i = 0; i<memo.length;i++)
            memo[i] = -1;
    }

    public long catalan (int n)
    {
        long tmp = 0;
        if(n<=1) {
            return 1;
        }

        if(memo[n] == -1) {

            for(int i = 0; i < n;i++)
            {
                tmp += catalan(i)*catalan(n-i-1);
            }
            memo[n] = tmp;
        }
        return memo[n];
    }

    public static void main(String[] args)
    {
        Catalan obj = new Catalan();

        try
        {
            File file = new File("C:\\Users\\Chris\\IdeaProjects\\Term4_Prac2\\src\\catalan.csv");
            Scanner scan = new Scanner(file);

            scan.nextLine();
            while(scan.hasNext())
            {
                int x = scan.nextInt();
                System.out.println("Input:\t" + x);
                System.out.println("Output:\t" + "catalan(" + x + ") = " + obj.catalan(x) + "\n");
            }
            scan.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("---------end of program-------");

    }
}