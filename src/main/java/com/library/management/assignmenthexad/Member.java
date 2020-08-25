package com.library.management.assignmenthexad;

import com.library.management.assignmenthexad.model.BookItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member extends Account {

    private Date dateOfMembership;
    private List<BookItem> borrowedBookItems;

    public Member(Integer userId, String password, String accountId, Date dateOfMembership) {
        super(userId, password, accountId);
        this.dateOfMembership = dateOfMembership;
        this.borrowedBookItems = new ArrayList<>();
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public List<BookItem> getBorrowedBookItems() {
        return borrowedBookItems;
    }

    public void borrowBook(BookItem bookItem) {
        //If User already borrowed 2 books.
        if (borrowedBookItems.size() >= 2) {
            System.out.println("Member already borrowed 2 books, can't issue more books");
            return;
        }

        if (borrowedBookItems.contains(bookItem)) {
            System.out.println("Member can't borrow same book more than once");
            return;
        }

        this.borrowedBookItems.add(bookItem);

        //Update the No of Copies of Same book
        bookItem.setNoOfCopies(bookItem.getNoOfCopies() - 1);
    }

    public void returnBook(BookItem bookItem) {
        if (!borrowedBookItems.remove(bookItem)) {
            System.out.println("Can't return the book");
            return;
        }

        //Update the No of Copies of Same book
        bookItem.setNoOfCopies(bookItem.getNoOfCopies() + 1);
    }
}
