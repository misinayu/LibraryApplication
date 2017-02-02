import java.util.*;
/**
 * Write a description of class LibraryApplication here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LibraryApplication
{
    public void run()
    {
        Scanner scan = new Scanner(System.in);

        Library library = new Library("SunMoon Library");
        //
        String choice = "";
        do{
            choice = this.getSelection();
            System.out.println();

            if(choice.equals("0")){
                System.out.println("\n\t\t" + "SYSTEM CLOSING" + "\n");
                System.out.println();
            }
            else if(choice.equals("1")){
                System.out.println("\t" + "Enter the borrower name >>> ");
                String borrowerName = scan.next();

                library.registerOneBorrower(borrowerName);
            }
            else if(choice.equals("2"))
            {
                System.out.print("\t" + "Enter the title >>> ");
                String title = scan.next();
                //
                System.out.print("\t" + "Enter the author >>> ");
                String author = scan.next();
                //
                System.out.print("\t" + "Enter the catalogue number >>> ");
                int catalogueNumber = scan.nextInt();
                //
                // Add the book to the library.
                library.registerOneBook(title, author, catalogueNumber);
            }
            else if(choice.equals("3")){
                System.out.println("\n\t" + "Books for loan");
                library.displayBooksForLoan();
            }
            else if(choice.equals("4"))
            {
                System.out.println("\n\t" + "Books on loan");
                library.displayBooksOnLoan();
            }
            else if(choice.equals("5"))
            {
                // Get details from the human user
                System.out.print("\t" + "Enter the catalogue number >>> ");
                int catalogueNumber = scan.nextInt();
                //
                System.out.print("\t" + "Enter the borrower name >>> ");
                String borrowerName = scan.next();

                // Lend the book to the borrower
                library.lendOneBook(borrowerName, catalogueNumber);        		
            }
            else if(choice.equals("6"))
            {
                System.out.print("\t" + "Enter the cataloue number >>> ");
                int catalogueNumber = scan.nextInt();

                library.returnOneBook(catalogueNumber);
            }
            else
            {
                System.out.println("\n\t" + "UNKONWN SELECTION" + "\n");
            }
        } while (choice.equals("0") == false);
    }

    private String getSelection()
    {
        // Display menu to the human use
        System.out.println();
        System.out.println("0: Quit");
        System.out.println("1: Register one borrower");
        System.out.println("2: Register one book");
        System.out.println("3: Display books for loan");
        System.out.println("4: Display books on loan");
        System.out.println("5: Lend one book");
        System.out.println("6: Return one book");
        //
        // Get and return the choice made
        System.out.println();
        //
        Scanner s = new Scanner(System.in);
        return s.next();
    }
}
