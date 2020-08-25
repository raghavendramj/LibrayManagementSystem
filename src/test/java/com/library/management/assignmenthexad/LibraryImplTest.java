package com.library.management.assignmenthexad;

import com.library.management.assignmenthexad.model.Book;
import com.library.management.assignmenthexad.model.BookItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class LibraryImplTest {

    Member member;
    Librarian librarian;

    Library library = new LibraryImpl(null);
    Set<Book> actualBooks = new HashSet<>();
    List<BookItem> actualBookItems = new ArrayList<>();

    @Before
    public void registerLibrarian() {
        librarian = new Librarian(1021, "pass@123", "raghavendramj");
        Assert.assertEquals("raghavendramj", librarian.getAccountId());
        library.registerMember(librarian);
    }

    @Before
    public void registerMember() {
        member = new Member(1212, "pass@123", "raghavendramj", new Date(12 / 02 / 2020));
        library.registerMember(member);
        Assert.assertEquals(1212, (int) member.getUserId());
    }

    @Test
    public void addBooksListToLibrary() {
        this.actualBookItems = Arrays.asList(
                new BookItem("Eloquent JavaScript, Second Edition", "A Modern Introduction to Programming", "No Starch Press", "9781593275846", 4),
                new BookItem("Learning JavaScript Design Patterns", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media", "9781449331818", 3),
                new BookItem("Speaking JavaScript", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media", "9781449365035", 6),
                new BookItem("You Don't Know JS", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media", "9781491904244", 9)
        );

        actualBooks.add(new Book("Eloquent JavaScript, Second Edition", "A Modern Introduction to Programming", "No Starch Press"));
        actualBooks.add(new Book("Learning JavaScript Design Patterns", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media"));
        actualBooks.add(new Book("Speaking JavaScript", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media"));
        actualBooks.add(new Book("You Don't Know JS", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media"));

        Set<Book> resultBooks = librarian.addBookItem(actualBookItems);
        Assert.assertEquals(resultBooks, actualBooks);

        System.out.println("addBooksListToLibrary is successful!");
    }


    @Test
    public void addSingleBookItemToLibrary() {

        Book actualBook = new Book("Design Patterns", "Complete DP and SP", "O'Reilly Media");
        //String title, String subject, String publisher, String barcode, double price, int noOfCopies
        Book returnedBook = librarian.addBookItem("Design Patterns", "Complete DP and SP", "O'Reilly Media", "4522458126", 56, 12);
        Assert.assertEquals(actualBook, returnedBook);

        System.out.println("addSingleBookItemToLibrary is successful!");
    }


    @Test
    public void borrowOneBook() {
        BookItem bookItem = new BookItem("Eloquent JavaScript, Second Edition", "A Modern Introduction to Programming", "No Starch Press", "9781593275846", 4);
        library.borrowBook(member, bookItem);
        Assert.assertEquals(Arrays.asList(bookItem), member.getBorrowedBookItems());

        System.out.println("borrowOneBook is successful!");
    }


    @Test
    public void borrow3Books() {
        BookItem bookItem1 = new BookItem("Eloquent JavaScript, Second Edition", "A Modern Introduction to Programming", "No Starch Press", "9781593275846", 4);
        BookItem bookItem2 = new BookItem("Learning JavaScript Design Patterns", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media", "9781449331818", 3);
        BookItem bookItem3 = new BookItem("Speaking JavaScript", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media", "9781449365035", 6);

        library.borrowBook(member, bookItem1);
        library.borrowBook(member, bookItem2);
        library.borrowBook(member, bookItem3);

        Assert.assertEquals(Arrays.asList(bookItem1, bookItem2), member.getBorrowedBookItems());
    }

    @Test
    public void return1Book() {

        BookItem bookItem1 = new BookItem("Eloquent JavaScript, Second Edition", "A Modern Introduction to Programming", "No Starch Press", "9781593275846", 4);
        BookItem bookItem2 = new BookItem("Learning JavaScript Design Patterns", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media", "9781449331818", 3);

        library.borrowBook(member, bookItem1);
        library.borrowBook(member, bookItem2);
        Assert.assertEquals(Arrays.asList(bookItem1, bookItem2), member.getBorrowedBookItems());


        library.returnBook(member, bookItem2);
        Assert.assertEquals(Arrays.asList(bookItem1), member.getBorrowedBookItems());

    }

    @Test
    public void returnAlltheBooks() {

        BookItem bookItem1 = new BookItem("Eloquent JavaScript, Second Edition", "A Modern Introduction to Programming", "No Starch Press", "9781593275846", 4);
        BookItem bookItem2 = new BookItem("Learning JavaScript Design Patterns", "A JavaScript and jQuery Developer's Guide", "O'Reilly Media", "9781449331818", 3);

        library.borrowBook(member, bookItem1);
        library.borrowBook(member, bookItem2);
        Assert.assertEquals(Arrays.asList(bookItem1, bookItem2), member.getBorrowedBookItems());


        library.returnBook(member, bookItem1);
        library.returnBook(member, bookItem2);
        Assert.assertEquals(new ArrayList<>(), member.getBorrowedBookItems());
    }

}
