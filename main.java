package hw3test;

import java.util.Scanner;
public class main {
  public static void main(String[] args){
	  
	  
	  
      String author = "author";
		String title = "title";
		String isbn = "4444";
		//String sType = "library book";
		double saleN = 1;
		float price = 0;
		

	
      BookstoreBook X = new BookstoreBook (isbn, title,  author, price, saleN);
      LibraryBook Z = new LibraryBook ("66666", "title2", "author2", 200, 150);
      // depending on type
      //BookList.BookList();
      BookList bookList = new BookList();
      bookList.add(X);
      bookList.add(Z);
      bookList.printList();


  }
  
}
//---------------------------------------------------------------------------------------
abstract class Book {
	String author;
	String title ;
	String isbn  ;
	String sType ;
	double saleN ;
	float price  ;
	
	public String toString(){
        return author + "/" + title + "/" + isbn + "/" + sType + "/" + saleN + "/" + price;
    }

}
//---------------------------------------------------------------------------------------

class BookstoreBook extends Book {
  public  BookstoreBook(String isbn, String title,  String author, float price, double saleN){
      this.isbn = isbn;
      this.title = title;
      this.author = author;
      this.price = price;
      this.saleN = saleN;
  }

}
//---------------------------------------------------------------------------------------

class LibraryBook extends Book {

  public LibraryBook(String isbn, String title,  String author, float price, double saleN){
	  this.isbn = isbn;
      this.title = title;
      this.author = author;
      this.price = price;
      this.saleN = saleN;
     
  }


}
//---------------------------------------------------------------------------------------

class BookList {
  private static Book[] list;
  public BookList() {
      list = new Book[100];
      for (int index = 0; index < 100 ; index++){
          list[index] = null;
      }
      // Additional code goes here if needed...
  }

  public void add(Book X) {
		boolean full = true;
		for (int index = 0; index < 100; index++) {
			if (list[index] == null) {
				list[index] = X;
				full = false;
				break;
			}
		}
		if (full)
			System.out.println("No more books can be added");
	}

  public void printList (){
	  
      for (Book X: list){
    	  if(X != null) {
    		  System.out.println(X);
    	  }
      }
  }
  
}



