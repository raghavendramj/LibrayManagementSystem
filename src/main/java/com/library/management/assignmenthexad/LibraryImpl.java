package com.library.management.assignmenthexad;

import com.library.management.assignmenthexad.model.Book;
import com.library.management.assignmenthexad.model.BookItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LibraryImpl implements Library {

    private Set<Book> booksInLibrary;
    private List<Integer> registeredMemberIds;
    private List<Member> registeredMembers;
    private List<Librarian> registeredMLibrarians;

    public LibraryImpl(Set<Book> booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
        this.registeredMemberIds = new ArrayList<>();
        this.registeredMembers = new ArrayList<>();
        this.registeredMLibrarians = new ArrayList<>();
    }

    public Set<Book> getListOfBooks() {
        if (booksInLibrary.isEmpty()) {
            System.out.println("No books are available in the library");

        }
        return booksInLibrary;
    }

    public Account registerMember(Account account) {

        int userId = account.getUserId();

        if (isRegisteredMember(userId)) {
            System.out.println("Member already registered");
            return registeredMembers.get(userId);
        }

        registeredMemberIds.add(userId);
        if(account instanceof  Member)
            registeredMembers.add((Member)account);
        else
            registeredMLibrarians.add((Librarian) account);

        return account;
    }

    public boolean isRegisteredMember(Integer memberId) {
        //If User is un-registered
        if (!registeredMemberIds.contains(memberId)) {
            return false;
        }
        return true;
    }

    public void borrowBook(Member member, BookItem bookItem) {

        if (!isRegisteredMember(member.getUserId()))
            return;

        //Valid Member
        member.borrowBook(bookItem);
    }

    public void returnBook(Member member, BookItem bookItem) {

        if (!isRegisteredMember(member.getUserId()))
            return;

        member.returnBook(bookItem);
    }
}
