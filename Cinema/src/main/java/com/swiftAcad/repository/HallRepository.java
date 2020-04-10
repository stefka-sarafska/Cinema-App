package com.swiftAcad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Hall;
@Repository
public interface HallRepository extends CrudRepository<Hall, Long>{

}
