package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Library {
	
	@Id
	int libraryId;
	String libraryName;
	@OneToMany(mappedBy="library",cascade=CascadeType.ALL)
	List<Book> book=new ArrayList<Book>();
	
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int libraryId, String libraryName, List<Book> book) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.book = book;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + ", book=" + book + "]";
	}


}
