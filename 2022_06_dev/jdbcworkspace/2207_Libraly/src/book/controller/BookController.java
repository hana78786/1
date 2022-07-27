package book.controller;

import java.util.ArrayList;

import book.DAO.BookDAO;
import book.vo.Book;

public class BookController {
 BookDAO bDao= null;
	
	public ArrayList<Book> allBook() {
		bDao = new BookDAO();
	ArrayList<Book> bList = new ArrayList<Book>();
	bList = bDao.allBook();
		
		return bList;
	}

	public Book serchBno(int bNo) {
		Book book = new Book();
		bDao = new BookDAO();
		book = bDao.serchBNo(bNo);
		
		
		return book;
	}

	public int addBook(Book book, int i) {
		int result = 0;
		bDao= new BookDAO();
		result = bDao.addBook(book,i);
		
		return result;
		
		
	}

	public int allBookList() {
		bDao = new BookDAO();
		
		int result = bDao.allBookList();
		return result;
	}

	public int deleteBook(int bNo) {
		bDao = new BookDAO();
		int result =0;
		result = bDao.delBook(bNo);
		return result;
	}

}
