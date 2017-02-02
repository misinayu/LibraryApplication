import java.util.*;

public class Borrower implements Comparable
{
    // ----- Attributes ----------
    private String name;
    // ----- Relations ----------
     private LinkedList<Book> borrowedBooks;

    public Borrower(String name) {
        this.name = name;
        borrowedBooks = new LinkedList<Book>();
    } 
    
    public void attachBook(Book book){
        //
       // book.attachBorrower(this); //
        
        borrowedBooks.add(book);
    } 
    
     public void detachBook(Book book) {
        //
       //  book.detachBorrower(); //
         
        borrowedBooks.remove(book);
    } 
    
    public boolean equals(Object obj) {
        return this.compareTo(obj) == 0;
    } 
    
    public int compareTo(Object obj) {
        Borrower borrower = (Borrower) obj;
        String pname = borrower.getName();
        return name.compareTo(pname);
    } 
    
    public int hashCode() {
        return name.hashCode();
    } 
   
    public String getName() {
        return name;
    } 
    
    public String toString(){
        return "Borrower's name : " + name;
    }
    
//     public Iterator getBorrowedBooksIterator()
//     {
//         Collection readOnlyCollection = Collections.unmodifiableCollection(borrowedBooks);
//         return readOnlyCollection.iterator();
//     }   
}
