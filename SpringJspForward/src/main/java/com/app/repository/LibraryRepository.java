package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Library;

public interface LibraryRepository extends JpaRepository<Library , Integer>{

}
