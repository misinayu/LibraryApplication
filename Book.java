
public class Book implements Comparable
{
    //Attributes
    private int catalogueNumber;
    private String author;
    private String title;
    //relations
    private Borrower borrower;

    //operations
    public Book(String title, String author, int catalogueNumber)
    {
        this.title = title;
        this.author = author;
        this.catalogueNumber = catalogueNumber;
    }

    public Book()
    {
        this("","",0);
    }

    public void display()
    {
        System.out.println();
        System.out.println("\t\t" + "Title : " + title);
        System.out.println("\t\t" + "Author : " + author);
        System.out.println("\t\t" + "CatalogueNumber : " + catalogueNumber);
        System.out.println();
    }

    public void attachBorrower(Borrower borrower)
    {
        this.borrower = borrower;
    }

    //     public void detachBorrower(Borrower borrower)
    public void detachBorrower()
    {
        this.borrower = null;
    }

    public Borrower getBorrower()
    {
        return borrower;
    }

    public boolean equals(Object obj)
    {
        return this.compareTo(obj) == 0;
    }

    public int compareTo(Object obj)
    {
        Book book = (Book) obj;
        int bookCatalogueNumber = book.getCatalogueNumber();

        int result;
        if(catalogueNumber < bookCatalogueNumber)
            result = -1;
        else if(catalogueNumber == bookCatalogueNumber)
            result = 0;
        else
            result = 1;

        return result;
    }

    public int hashCode()
    {
        Integer integerCatalogueNumber = new Integer(catalogueNumber);
        return integerCatalogueNumber.hashCode();
    }
    //   

    public int getCatalogueNumber()
    {
        return catalogueNumber;
    }

    public String toString()
    {
        return catalogueNumber + ": " + title + " by " + author;
    }
}
