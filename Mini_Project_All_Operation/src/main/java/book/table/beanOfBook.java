package book.table;

import java.io.Serializable;

public class beanOfBook implements Serializable
{
   
	private static final long serialVersionUID = -1525234317755058619L;
private String bookname;
   private double bookPrice;
   private int bookId;
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public double getBookPrice() {
	return bookPrice;
}
public void setBookPrice(double bookPrice) {
	this.bookPrice = bookPrice;
}
@Override
public String toString() {
	return "beanOfBook [bookname=" + bookname + ", bookPrice=" + bookPrice + ", bookId=" + bookId + "]";
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
   
}
