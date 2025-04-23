public class Generic
{
    public <E> void PrintArray(E s[])
    {
        for(E e:s)
            System.out.println(e);
    }

    public static void main(String[] args) {
        Generic g1 = new Generic();
        String countries[] = {"India","Italy"};
        Integer i1[] = {12,1,4,3,90,13};

        g1.PrintArray(countries);
        g1.PrintArray(i1);
    }
}