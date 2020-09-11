package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Book;
import com.app.model.Library;
import com.app.service.LibraryService;



@Controller
public class AppController {
	
	@Autowired
	LibraryService libraryService;
	
	
	@RequestMapping("/")
	public void home()
	{
		System.out.println("hi");
	}
	
	@RequestMapping("/home")
	public String index()
	{
		System.out.println("index");
		return "index.jsp";
	}
	
	@RequestMapping("/addBook")
	public void addBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println("AddBook");
		
		int libraryId=Integer.parseInt(request.getParameter("lid"));
    	String libraryName=request.getParameter("lname");
    	int bookId=Integer.parseInt(request.getParameter("bid"));
		String bookName=request.getParameter("bname");
		String author=request.getParameter("author");
		String publisher=request.getParameter("pub");
		
		PrintWriter out=response.getWriter();
		out.println(libraryId);
		out.println(libraryName);
		out.println(bookId);
		out.println(bookName);
		out.println(author);
		out.println(publisher);
	
		out.println("Book Added");
		
		
		Library library=new Library();
		
		library.setLibraryId(libraryId);
		library.setLibraryName(libraryName);
		
		
		Book books=new Book();
		books.setBookId(bookId);
		books.setBookName(bookName);
		books.setAuthor(author);
		books.setPublisher(publisher);
		books.setLibrary(library);
		library.getBook().add(books);
		
		libraryService.add(library);
	
	}
	
	@RequestMapping("/deleteBook")
	public void deleteBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		libraryService.deleteBook(Integer.parseInt(request.getParameter("did")));
		out.println("Library ID "+request.getParameter("did")+" deleted. ");
	}
	
	@RequestMapping("/searchBook")
	public void searchBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Library l = libraryService.findBook(Integer.parseInt(request.getParameter("sid")));
		
		if(l!=null)
		{
			out.println("Library Id:"+l.getLibraryId());out.print("<br>");
			out.println("Library Name:"+l.getLibraryName());
			
		}

		Book b = libraryService.findBookId(Integer.parseInt(request.getParameter("sbid")));
		
		  out.print("<br>");
		  if(b!=null) { out.println("Book Id : "+b.getBookId());out.print("<br>");
		  out.println("Book Name : "+b.getBookName());out.print("<br>");
		  out.println("Author of Book : "+b.getAuthor());out.print("<br>");
		  out.println("Publisher of Book : "+b.getPublisher()); }else {
		  out.println("Enter the correct BookId"); }

	}
		
	
	
	@RequestMapping("/updateBook")
	public void updateBook(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		
		int nbId =Integer.parseInt(request.getParameter("buid"));
		String nBName = request.getParameter("buname");
		String nBauthr = request.getParameter("uauthor");
		String nBpubshr = request.getParameter("upub");
		
		Book book = libraryService.findBookId(nbId);

		Book upbook = libraryService.updateBookDetails(nbId,nBName,nBauthr,nBpubshr);
		 	
	  	out.println("After Updating");out.print("<br>");
		out.println("Book Name : " +upbook.getBookName());out.print("<br>");
		out.println("Book Author : "+upbook.getAuthor());out.print("<br>");
		out.println("Book Publisher Name : "+upbook.getPublisher());out.print("<br>");

	}
	
	@RequestMapping("/add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println("AddBook");
		
		int libraryId=Integer.parseInt(request.getParameter("lid"));
    	String libraryName=request.getParameter("lname");
    	int bookId=Integer.parseInt(request.getParameter("bid"));
		String bookName=request.getParameter("bname");
		String author=request.getParameter("author");
		String publisher=request.getParameter("pub");
		
		PrintWriter out=response.getWriter();
		out.println(libraryId);
		out.println(libraryName);
		out.println(bookId);
		out.println(bookName);
		out.println(author);
		out.println(publisher);
	
		out.println("Book Added");
		
		
		Library library=libraryService.findBook(libraryId);
		
		library.setLibraryId(libraryId);
		library.setLibraryName(libraryName);
		
		
		Book books=new Book();
		books.setBookId(bookId);
		books.setBookName(bookName);
		books.setAuthor(author);
		books.setPublisher(publisher);
		books.setLibrary(library);
		library.getBook().add(books);
		
		libraryService.add(library);
	
	}


}
