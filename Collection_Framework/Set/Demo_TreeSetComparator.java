import java.util.*;

class Book
{
    private String name;
    private double price;

    Book(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
    String getName() {return name;}
    double getPrice() {return price;}
}

class SortingAlgo implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        Book book1 = (Book)o1;
        Book book2 = (Book)o2;

        if(book1.getPrice() < book2.getPrice()) return -1;  //pushing the element to the left of the node
        return 1;
    }
}


public class Demo_TreeSetComparator
{
    public static void main(String args[])
    {
        Book b1,b2,b3,b4;
        b1 = new Book("java",780.06);
        b2 = new Book("c",192.06);
        b3 = new Book("cpp",530.06);
        b4 = new Book("dbms",100.06);

        TreeSet tree = new TreeSet(new SortingAlgo());
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        tree.add(b4);

        Iterator<Book> iterate = tree.iterator();  // iterator() is a method
        while(iterate.hasNext())
        {
            Book b = (Book)iterate.next();
            System.out.println(b.getName()+" price:-"+b.getPrice());
        }
    }
}