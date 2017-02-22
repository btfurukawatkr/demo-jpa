package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Child;

public interface ChildRepository extends CrudRepository<Child, Integer>{

}
