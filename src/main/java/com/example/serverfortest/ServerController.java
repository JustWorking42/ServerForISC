package com.example.serverfortest;

import com.example.serverfortest.domain.Test;
import com.example.serverfortest.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.Map;

@Controller
public class ServerController {
    @Autowired
    private TestRepo testRepo;

    @GetMapping("/tests/get/all")
    public @ResponseBody Iterable<Test> findAll() {
        return testRepo.findAll();
    }

    @GetMapping("/tests/get/by_type")
    public @ResponseBody Iterable<Test> findByType(
            @RequestParam(value = "type", required = true) String type) {
        return testRepo.findByTypeLike(type);
    }

    @GetMapping("/tests/get/by_date")
    public @ResponseBody Iterable<Test> findByDate(
            @RequestParam(value = "date", required = true) String date) {
        return testRepo.findByDateLike(date);
    }

    @GetMapping("/tests/get/last")
    public @ResponseBody Iterable<Test> lats() {
        return testRepo.findTopByOrderByIdDesc();
    }

    @Transactional
    @DeleteMapping("/tests/delete/by_date/{date}")
    public ResponseEntity<Void> deleteByDate(@PathVariable("date") String date) {
        testRepo.deleteByDate(date);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/tests/delete/by_id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        testRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/tests/delete/all")
    public ResponseEntity<Void> deleteAllTests() {
        testRepo.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tests/add")
    public @ResponseBody Iterable<Test> add(
            @RequestBody Test test, Map<String, Object> model) {
        testRepo.save(test);
        return testRepo.findAll();
    }
}
