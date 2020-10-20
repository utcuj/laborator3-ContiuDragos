public class Bilet {
    public static int[] numere;
    public int[] getNumere()
    {
        return numere;
    }
    public Bilet(int[] numere)
    {
        if(numere.length==6)
            Bilet.numere =numere;
        else
            System.out.println("Sirul are prea multe numere");
    }
}
