package com.library.management.assignmenthexad.model;

import java.util.Date;

public class BookItem extends Book {

    private String barcode;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private int noOfCopies;

    public BookItem(String title, String subject, String publisher, String barcode, double price) {
        super(title, subject, publisher);
        this.barcode = barcode;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookItem)) return false;

        BookItem bookItem = (BookItem) o;

        if (Double.compare(bookItem.getPrice(), getPrice()) != 0) return false;
        return getBarcode() != null ? getBarcode().equals(bookItem.getBarcode()) : bookItem.getBarcode() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getBarcode() != null ? getBarcode().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "barcode='" + barcode + '\'' +
                ", borrowed=" + borrowed +
                ", dueDate=" + dueDate +
                ", price=" + price +
                ", noOfCopies=" + noOfCopies +
                '}';
    }
}
