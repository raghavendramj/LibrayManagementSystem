package com.library.management.assignmenthexad;

import com.library.management.assignmenthexad.model.Book;
import com.library.management.assignmenthexad.model.BookItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Librarian extends Account {

    private Map<String, Integer> booksInfo = new HashMap<>();
    private Map<Book, Integer> bookListMap = new HashMap<>();

    public Librarian(Integer userId, String password, String accountId) {
        super(userId, password, accountId);
    }

    public Book addBookItem(String title, String subject, String publisher, String barcode, double price, int noOfCopies) {

        booksInfo.put(title, booksInfo.getOrDefault(title, 0) + 1);

        Book book = new Book(title, subject, publisher);
        bookListMap.put(book, bookListMap.getOrDefault(book, 0) + 1);
        BookItem bookItem = new BookItem(title, subject, publisher, barcode, price);

        noOfCopies = booksInfo.containsKey(title) ? bookItem.getNoOfCopies() + noOfCopies : noOfCopies;
        bookItem.setNoOfCopies(noOfCopies);

        //System.out.println("Book added successfully!");

        return book;
    }


    public Set<Book> addBookItem(List<BookItem> bookItems){
        for(BookItem bookItem : bookItems)
            addBookItem(bookItem.getTitle(), bookItem.getSubject(), bookItem.getPublisher(), bookItem.getBarcode(), bookItem.getPrice(),bookItem.getNoOfCopies());

        return bookListMap.keySet();
    }

    public Set<Book> getAllTheBooks() {
        return bookListMap.keySet();
    }
}
