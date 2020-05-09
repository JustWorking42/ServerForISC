package com.example.serverfortest.repos;

import com.example.serverfortest.domain.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TestRepo extends PagingAndSortingRepository<Test, Long> {
    Iterable<Test> findById(int i);
    List<Test> findByDateLike(String date);
    List<Test> findByTypeLike(String type);
    void deleteByDate(String date);
    List<Test> findTopByOrderByIdDesc();


}
