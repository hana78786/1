package book.controller;

import java.util.ArrayList;

import book.DAO.BookDAO;
import book.vo.Book;

public class BookController {
 BookDAO bDao= new BookDAO();
	
	public ArrayList<Book> allBook() {
	ArrayList<Book> bList = new ArrayList<Book>();
	bList = bDao.allBook();
		
		return bList;
	}

}
