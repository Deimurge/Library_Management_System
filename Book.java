
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;
//import java.io.File;
import java.util.regex.Matcher;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
 
class EmailValidator {
    private static final String EMAIL_PATTERN = 
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String email = "example@example.com";
        if (validateEmail(email)) {
            System.out.println("Email is valid");
        } else {
            System.out.println("Email is not valid");
        }
    }
}
public class Book extends Thread {
 
	public static String title;
	public static String author;
	public static String isbn;
	public static String status;
	public String borrower;
	public String borrowerEmail;
	public boolean isBorrowered;
    private LocalDate borrowDate;
	private static final long returnDate2 = 7;
    private LocalDate returnDate;
	public String status1 = "Available";
	public String status2 = "Borrowed";
	public int BookChoice;
	public double lateFee;


 
	static ArrayList<String> UserList = new ArrayList<String>();
	static ArrayList<String> EmailList = new ArrayList<String>();
	static ArrayList<Book> BookList = new ArrayList<Book>();
 
	static int choice ;
 
	public static Scanner userInput = new Scanner(System.in);
	public static Scanner choiceInput = new Scanner(System.in);
	@SuppressWarnings("static-access")
    public Book(String title, String author, String isbn, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        loadLibraryData();
    }
 
	public static void displayFirstMenu(){
		System.out.println("> Welcome to the Library Management System!");
		System.out.println("> Choose one of the following options:");
		System.out.println(">------------------------------------------------------------------------------------------------");
		System.out.println("2. Add a book to the Library");
		System.out.println("6. Blow up library");
		System.out.println("7. Back to main menu");
		System.out.println("0. Exit");
		System.out.println(">------------------------------------------------------------------------------------------------");
		System.out.println("> Enter your option here: ");
		choice = choiceInput.nextInt();//User inputs a choice (integer).
 
	}
 
	public static void displaySecondMenu(){
		System.out.println(">------------------------------------------------------------------------------------------------");
		System.out.println(" Choose one of the following options:");
		System.out.println(">************************************************************************************************");
		System.out.println("1. View Library");
		System.out.println("2. Add a book to the Library.");
		System.out.println("3. Borrow a book.");
		System.out.println("4. Return a book.");
		System.out.println("5. Delete a book.");
		System.out.println("6. Save data");
		System.out.println("7. Blow up library.");
		System.out.println("8. Back to main menu.");
		System.out.println("0. Exit.");
		System.out.println(">====================================================================");
		System.out.println("> Enter your option here: ");
		choice = choiceInput.nextInt();//User inputs a choice (integer).
 
	}
 
	public String displayBook(){

		String BookInfo = "----------------------------------------------------------------"+
						"\nTitle:.................."+title+
						"\nAuthor:................."+author+
						"\nISBN:.............."+isbn+ 
						"\nStatus:................."+status+
						"\nBorrower:..............."+borrower+
						"\nDate Borrowed:.........."+borrowDate+
						"\nReturn date:............"+returnDate+
						"\n----------------------------";
		/*LocalDate currentDate = LocalDate.now();
			long daysBetween = ChronoUnit.DAYS.between(borrowDate, currentDate);
				if (status.equals(status2)) {
					if (daysBetween > 14) {
						lateFee = (daysBetween - 14) * 0.25;
				}}*/
		return BookInfo;	
	}
 
	public void createBook(){
		System.out.println("Enter the title of the book: ");
		String title = userInput.nextLine();
		if (title.isEmpty()) {
			System.out.println("Error: Title cannot be empty.");
		}
		System.out.println("Enter the author of the book: ");
		String author = userInput.nextLine();
		if (author.isEmpty()) {
			System.out.println("Error: Author cannot be empty.");
		}
		System.out.println("Enter the ISBN of the book: ");
		String isbn = userInput.nextLine();
		if (isbn.isEmpty()) {
			System.out.println("Error: ISBN cannot be empty.");
		}

		borrower = "nobody";
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
 
		status = "Available";
	}
 
	public void addBook(){
		Book newBook = new Book(title,author, isbn, status); //create new book object with status "Available."
		newBook.createBook();
		BookList.add(newBook);//add the book to the BookList ArrayList.
		BookList.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780060935467", "Available"));
		BookList.add(new Book("1984", "George Orwell", "9780451524935", "Available"));
        BookList.add(newBook);
		BookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Available"));
        BookList.add(newBook);
		BookList.add(new Book("Pride and Prejudice", "Jane Austen", "9780141395881", "Available"));
        BookList.add(newBook);
		BookList.add(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", "Available"));
		System.out.println("---------------------------------------------------------");
		System.out.println("> You have successfully added the book to the library!\n");
		System.out.println("---------------------------------------------------------");	
	}

 
	public void displayBookList(){
		if (BookList.size() == 0){//If the library is empty, it goes back to main menu and choice.
			System.out.println(">-------------------------------------------------------------");
			System.out.println("> There Library is Empty! Please add a book first!\n");
			System.out.println(">-------------------------------------------------------------");
			Book.displayFirstMenu();//Display to main menu.
			choice = choiceInput.nextInt();//Register new choice.
 
		} else {					
			for (int i = 0; i < BookList.size(); i++){
				System.out.printf("\n>-----------Book Index: [%s]---------------------------------\n",i+1);
				System.out.println(BookList.get(i).displayBook());	
				System.out.println(">-------------------------------------------------------------");
			}//End of For Loop.			
		}// End of Else Statement.			
	}//End of if Statement.
 
	public void borrowBook(LocalDate borrowDate, LocalDate returnDate) {
		System.out.println("---------------------------------------------------------");
		System.out.println("> Here are all the books registered in the library: ");
		System.out.println("---------------------------------------------------------");		
		displayBookList();
	
		int bookChoice = -1;
		while (true) {
			System.out.println("\n\n-------------> Choose an available book from the above list and write down it's index number: ");
			bookChoice = choiceInput.nextInt() - 1; // register user's book choice.
	
			if (bookChoice < 0 || bookChoice >= BookList.size()) {
				System.out.println("------------->  The number of the book you entered is not in the list! <-------------");
				continue;
			}
	
			Book book = BookList.get(bookChoice);
			if (book.status.equalsIgnoreCase("Available")) {
				// Print the borrowed book information and change the book status to borrowed.
				book.status = "Borrowed";
				System.out.printf("\n> You have chosen the following book: %s\n", book.displayBook());
	
				// Add the user name to the book borrower variable:
				book.borrower = borrower;
				book.borrowerEmail = borrowerEmail;
				book.borrowDate = borrowDate;
				book.returnDate = returnDate;
	
				System.out.println("> You have to return the book in two weeks!");
	
				// Write to physical file
				try (FileWriter myWriter = new FileWriter("borrowers.txt", true)) {
					myWriter.write(borrower + " \n " + borrowerEmail + " \n " + book.title + " \n " + borrowDate + "\n ");
					System.out.println("Borrowers record as been successfully written to the physical file.");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
	
				break; // exit the loop
			} else {
				System.out.println("> The Book you are trying to borrow is unavailable!");
			}
		}
	
		choice = 8; // update the choice variable
	}

	public void setTitle(){
		Book.title = title;
	}
	public void setIsbn(){
		Book.isbn = isbn;
	}
	public void setStatus(){
		Book.status = status;
	}
	public void setBorrower(LocalDate localDate){
		borrower = borrower;
	}
	public void setAuthor(){
		Book.author = author;
	}
	public void setBorrowerEmail(String parts){
		borrowerEmail = borrowerEmail;
	}
	public void setBorrowDate(){
		borrowDate = borrowDate;
	}



	public class Library {
    private List<Book> bookList;
    private List<String> userList;
    private List<String> emailList;



    public Library() {
        bookList = new ArrayList<>();
        userList = new ArrayList<>();
        emailList = new ArrayList<>();

        loadLibraryData();
    }

}
private void loadLibraryData() {
	try (BufferedReader reader = new BufferedReader(new FileReader("library.txt"))) {
		 String line;
		 while ((line = reader.readLine()) != null) {
			 String[] parts = line.split(";");
			 if (parts.length == 7) {
				Book book = new Book(parts[0], parts[1], parts[2], parts[3]);
				 book.setBorrower(parts[4]);
				 book.setBorrowerEmail(parts[5]);
				 book.setBorrower(LocalDate.parse(parts[6]));
				 BookList.add(book);
			 }
		 }
	 } catch (IOException e) {
		 System.out.println("Error loading library data: " + e.getMessage());
	 }
 }
 


	
	public void returnBook(LocalDate returnDate) {
		System.out.println("> Enter the Title of the book you want to return: ");
		String returnBookTitle = userInput.nextLine();
		boolean bookFound = false;
		for (Book book : BookList) {
			if (book.title.equalsIgnoreCase(returnBookTitle)) {
				long daysBetween = ChronoUnit.DAYS.between(book.borrowDate, returnDate);
				if (daysBetween > 15) {
					double fine = (daysBetween - 15) * 3.25;
					System.out.println("You are fined R" + String.format("%.2f", fine) + " for returning " + book.title + " late.");
				}
				book.status = "Available";
	
				// Write receipt to physical file
				try (FileWriter myWriter = new FileWriter("receipts.txt", true)) {
					myWriter.write(borrower + " " + borrowerEmail + " " + book.title + "was returned by" + returnDate +  "\n");
					System.out.println("Return receipt as been successfully written to the physical file.");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
	
				System.out.println("> You have successfully returned the book to the library!");
				displayFirstMenu(); // Display main menu.
				choice = choiceInput.nextInt(); // Register new choice.
				bookFound = true;
				break;
			}
		}
		if (!bookFound) {
			System.out.println("> The are no books with this title in the library." +
					" Would you like to add the book to the library? (yes/no) ");
			String addBook = userInput.nextLine();
			if (addBook.equalsIgnoreCase("yes")) {
				addBook();
			} else {
				displayFirstMenu(); // Display main menu.
				choice = choiceInput.nextInt(); // Register new choice.
			}
		}
	}

    public void run(){
        try {
            for (Book book : BookList){
              long daysBetween = ChronoUnit.DAYS.between(book.borrowDate, returnDate);
            if ( daysBetween > 15) {
                double fine = (daysBetween - 15) * 3.25;
                System.out.println("You are fined R" + String.format("%.2f", fine) + " for returning " + book.title + " late.");
                boolean payed = false;
                if (daysBetween > 30 && payed){
                    System.out.println("We will inform the night owls");
                }else{
                    System.out.println("\n -----Thank you for returning the book-----");
                }
            }}
            

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
 
	public void setBorrower(String string) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setBorrower'");
	}

	@SuppressWarnings("static-access")
	public void removeBook(){
		int i = 0;
		System.out.println("---------------------------------------------------------");
		System.out.println("> Here are all the books registered in the library: ");
		System.out.println("---------------------------------------------------------");
 
		while (i < BookList.size() && BookList.size() > 0){//show the user the list of all the books
			System.out.printf("\n> Book number %s:\n%s",i+1,BookList.get(i));
			i = i+1;
		}//end of while loop.
 
		System.out.println("\n\n> Choose an available book from the above list and write down it's number: ");
		int BookChoice = choiceInput.nextInt()-1;//register user's book choice.
 
		while(choice == 5){
			try{
				if (BookChoice > 0 && BookChoice < BookList.size() && BookList.get(BookChoice).status.equalsIgnoreCase("Available")){//Check if the book to be borrowed is available.
					//Print the borrowed book information and change the book status to borrowed.
					BookList.remove(BookChoice);
					System.out.printf("\n> You have chosen to delete the following book: %s\n", BookList.get(BookChoice));
					System.out.printf("\n> The Book %s is deleted.\n", BookList.get(BookChoice));
					choice = 8;
				}
			}catch(InputMismatchException error){
				System.out.println("<ERROR> Please enter a number of book from the list: ");
				choiceInput.nextInt();
				choice = 5;
			}catch(IndexOutOfBoundsException error){
				System.out.println("<ERROR> Please enter a number of book from the list: ");
				choice = 5;
			}
		}		
	}


	 private void saveData() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("library.txt"))) {
			for (Book book : BookList) {
				writer.write(
                    "----------------------------------------------------------------"+
                    "\nTitle:.................."+ book.title + ";" +
                    "\nAuthor:................."+book.author + ";" +
                    "\nISBN:.............."+book.isbn + ";" + 
                    "\nStatus:................."+book.status + ";" +
                    "\nBorrower:..............."+book.borrower + ";" +
                    "\nDate Borrower Email:.........."+book.borrowerEmail + ";" +
                    "\nDate Borrowed:.........."+book.borrowDate + "\n"+
                    "\nReturn date:............"+returnDate+
                    "\n----------------------------"
                    );
			}
		} catch (IOException e) {
			System.out.println("Error saving library data: " + e.getMessage());
		}
    }
 
 
	public void emptyLibrary(){
		System.out.println("> WARNING!!! < You have chosen to delete all books in the library! ");
		System.out.println("\tAre you sure?? Enter yes or no: ");
		String confirmation = userInput.nextLine();
		try{
			if(confirmation.equalsIgnoreCase("yes")){
				System.out.println("\n----->Library is being deleted...<-----");
				BookList.clear();
				System.out.println("\n----->Library is Empty!<-----");
				choice = 8;
			}
		}catch(InputMismatchException error){
			System.out.println("<ERROR> Make sure you spell yes or no correctrly: ");
			choice = 8;
		}
	}
 
 
	public void addUser(){
		System.out.println("Please enter your name: ");
		borrower = userInput.nextLine();
		System.out.println("Please enter your Email: ");
	    String email = userInput.nextLine();
    if (EmailValidator.validateEmail(email)) {
        borrowerEmail = email;
        EmailList.add(borrowerEmail);
    } else {
        System.out.println("Error: Invalid email format. Please try again.");
    }
		UserList.add(borrower);	//Add the userName to the UserList arrayList.

	}
 
	public void load() {
		System.out.println("----------/First Section/----------");
		addUser();
		System.out.println("----------/Second Section/----------");
		Book.displayFirstMenu();//Displays the main menu and ask for choice.
	
		System.out.println("----------/Entering main section/----------");

		
		exit:
		while (choice!= 0) {
			try {
				switch (choice) {
					case 1:
						if (BookList.size() > 0) {
							displayBookList();
						} else {
							System.out.println("<ERROR> Library is empty! Please add a Book first!");
						}
						choice = 8;
						break;
					case 2:
						addBook();
						displaySecondMenu();
						break;
					case 3:
						if (BookList.size() > 0) {
							borrowBook(borrowDate, borrowDate);
						}
						break;
					case 4:
						returnBook(borrowDate);
						break;
					case 5:
						removeBook();
						try {
							if (BookList.size() > 0) {
								displaySecondMenu();
							}
						} catch (IndexOutOfBoundsException error) {
							System.out.println("<ERROR> The array is Empty! Please add a book first!");
							choice = 8;
						}
						break;
					case 6:
						saveData();
                        displaySecondMenu();
						break;
					case 7:
						emptyLibrary();
                        displaySecondMenu();
						break;
					case 8:
						if (BookList.size() > 0) {
							displaySecondMenu();
						} else {
							displayFirstMenu();
						}
						break;
					case 0:
						break exit;
					default:
						System.out.println("Error: Number entered should be between (1-8)");
						break exit;
				}
			} catch (InputMismatchException error) {
				System.out.println("Error: Number entered should be between (1-8)");
				displaySecondMenu();
			}
		}//end of while loop.
	
		System.out.println("------You have Exited the Library!-------");
		System.out.println("------Thank you. Please come again.-----");
	}//End of load() method.
 

	public static void main(String[] args){

 
		System.out.println("--------> Welcome to the library! <--------");
 
		Book newBook = new Book(title, author, isbn, status);
		newBook.load();
        newBook.start();
		
 
	}//End of Main Method.
 
}
