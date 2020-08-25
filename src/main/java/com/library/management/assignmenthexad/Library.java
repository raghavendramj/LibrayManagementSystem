package com.library.management.assignmenthexad;

import com.library.management.assignmenthexad.model.Book;
import com.library.management.assignmenthexad.model.BookItem;

import java.util.Set;

public interface Library {
    Set<Book> getListOfBooks();

    Account registerMember(Account account);

    boolean isRegisteredMember(Integer memberId);

    void borrowBook(Member member, BookItem bookItem);

    void returnBook(Member member, BookItem bookItem);
}
