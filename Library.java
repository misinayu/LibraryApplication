
/**
 * Write a description of class Library here.
 * 
 * @author (sHwang) 
 * @version (2014.11.26)
 */
import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class Library
{
    private String name;
    private TreeSet<Book> registeredBooks;
    private HashSet<Borrower> registeredBorrowers;

    //     private String theMessage;

    public Library(String name)
    {
        this.name = name;
        // Initialize architectural attributes
        registeredBooks = new TreeSet<Book>();
        registeredBorrowers = new HashSet<Borrower>();
    }   // method: Library
    public Iterator getBorrowersIterator()
    {
        Collection readOnlyCollection = Collections.unmodifiableCollection(registeredBorrowers);
        return readOnlyCollection.iterator();
    }   // method: getBorrowersIterator
    public Iterator getBooksIterator()
    {
        Collection readOnlyCollection = Collections.unmodifiableCollection(registeredBooks);
        return readOnlyCollection.iterator();
    }   // method: getBooksIterator

    public void registerOneBorrower(String name)
    {
        Borrower borrower = new Borrower(name);
        boolean result = registeredBorrowers.add(borrower);

    }   

    public void registerOneBook(String title, String author, int catalogueNumber)
    {
        Book book = new Book(title, author, catalogueNumber);
        boolean result = registeredBooks.add(book);
    }   

    public void displayBooksForLoan()
    {
        System.out.println("\n" + "Library: " + name + "\n");
        //
        Iterator iter = registeredBooks.iterator();
        //
        System.out.println("\n" + "Books available for loan");
        while(iter.hasNext() == true){
            Book book = (Book)iter.next();
            if(book.getBorrower() == null){
                book.display();
            }
        }
    }   

    public void displayBooksOnLoan()    
    {
        System.out.println("\n" + "Library: " + name + "\n");
        //
        Iterator iter = registeredBooks.iterator();
        //
        System.out.println("\n" + "Books available on loan");
        while(iter.hasNext() == true){
            Book book = (Book)iter.next();
            if(book.getBorrower() != null){
                book.display();
            }
        }
    }   

    public void lendOneBook(String name, int catalogueNumber)
    {
        Book book = this.findBook(catalogueNumber);
        Borrower borrower = this.findBorrower(name);
        book.attachBorrower(borrower);//
        borrower.attachBook(book);
    }   // method: lendOneBook

    public void returnOneBook(int catalogueNumber)
    {
        Book book = this.findBook(catalogueNumber);
        Borrower borrower = book.getBorrower();
        borrower.detachBook(book);
        book.detachBorrower();//
    }   // method: returnOneBook

    private Borrower findBorrower(String name)
    {
        Borrower foundBorrower = null;
        //
        Iterator iter = registeredBorrowers.iterator();
        while(iter.hasNext() == true)
        {
            Borrower borrower = (Borrower)iter.next();
            String borowerName = borrower.getName();
            if(borowerName.equals(name)==true)
            {
                foundBorrower = borrower;
                break;
            }
        }
        return foundBorrower;
    }

    private Book findBook(int catalogueNumber)
    {
        Book foundBook = null;
        //
        Iterator iter = registeredBooks.iterator();
        while(iter.hasNext() == true)
        {
            Book book = (Book)iter.next();
            int bookCatalogueNumber = book.getCatalogueNumber();
            if(bookCatalogueNumber == catalogueNumber)
            {
                foundBook = book;
                break;
            }
        }
        return foundBook;
    }   
}
