package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Book;
import com.app.model.Library;
import com.app.repository.BookRepository;
import com.app.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public void add(Library library)
	{
		libraryRepository.save(library);
	}
	
	public void deleteBook(Integer libraryId)
	{
		Library l = findBook(libraryId);
		libraryRepository.delete(l);
		
	}

	public Library findBook(Integer libraryId) { 
		
		return  libraryRepository.getOne(libraryId);
				
			 
}
	
public Book findBookId(Integer bookId) { 
		
		return  bookRepository.getOne(bookId);
							 
}

public Book updateBookDetails(int nbId, String nBName, String nBauthr, String nBpubshr) {
	// TODO Auto-generated method stub
	
	Book b = findBookId(nbId);
	
    b.setBookName(nBName);
	b.setAuthor(nBauthr);
	b.setPublisher(nBpubshr);
	bookRepository.save(b);
	return b;
}



}