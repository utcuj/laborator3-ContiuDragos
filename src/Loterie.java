import java.util.Random;
import java.util.Scanner;

public class Loterie {

    private final int[] numereCastigatoare =new int[6];
    private int[] extragere()
    {
        int[] fv=new int[49];
        Random r=new Random();
        for(int i=0;i<6;i++) {
            numereCastigatoare[i] = r.nextInt(50);
            if(numereCastigatoare[i]==0 || fv[numereCastigatoare[i]]!=0)
            {
                i--;
                continue;
            }
            fv[numereCastigatoare[i]]++;
        }
        return numereCastigatoare;
    }
    public static void main(String[] args)
    {
        Loterie infinity=new Loterie();
        int[] numereCastigatoare =infinity.extragere();
        Scanner in = new Scanner(System.in);

        int count=0;
        int[] numereAlese = new int[6];
        int[] frecventa = new int[49];
        System.out.println("Loto 6/49\nAlegti numerele de pe bilet");
        for(int i=0;i<6;i++) {
            numereAlese[i] = in.nextInt();
            if(numereAlese[i]>=50)
            {
                System.out.println("Numarul introdus e mai mare decat 49. Puneti alt numar.");
                i--;
                continue;
            }
            if(frecventa[numereAlese[i]]!=0)
            {
                System.out.println("Ati mai ales acest numar o data. Puneti alt numar.");
                i--;
            }
            else
                frecventa[numereAlese[i]]++;
        }
            Bilet biletulMeu=new Bilet(numereAlese);
        for(int i=0;i<6;i++)
        {
            int[] numereDePeBilet =biletulMeu.getNumere();
            for(int j=0;j<6;j++)
            {
                if (numereDePeBilet[j] != numereCastigatoare[i]) {
                    continue;
                }
                count++;
            }
        }
        System.out.println("Numerele dumneavoastra:");
        for(int i=0;i<6;i++)
        {
            System.out.print(numereAlese[i]+" ");
        }
        System.out.println("\nNumerele castigatoare:");
        for(int i=0;i<6;i++)
        {
            System.out.print(numereCastigatoare[i]+" ");
        }
        if(count==6)
            System.out.println("\nATI CASTIGAT");
        else
            System.out.println("\nATI PIERDUT");

    }
}
