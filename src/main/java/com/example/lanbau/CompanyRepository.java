package com.example.lanbau;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findByName(String name);

}

