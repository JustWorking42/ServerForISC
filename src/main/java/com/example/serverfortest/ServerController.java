package com.example.serverfortest;

import com.example.serverfortest.domain.Test;
import com.example.serverfortest.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ServerController {
    @Autowired
    private TestRepo testRepo;

    @GetMapping("/get.tests")
    public @ResponseBody Iterable<Test> findAll() {
        return testRepo.findAll();
    }

    @GetMapping("/get_tests")
    public @ResponseBody Iterable<Test> all() {
        return testRepo.findAll();
    }

    @GetMapping("/find_tests")
    public @ResponseBody Iterable<Test> findByDate(
            @RequestParam(value = "date", required = true) String date) {
        return testRepo.findByDateLike(date);
    }

    @GetMapping("/delete_tests/all")
    public @ResponseBody Iterable<Test> deleteAll() {
        testRepo.deleteAll();
        return testRepo.findAll();
    }

    @DeleteMapping("/delete_tests/by_date")
    public @ResponseBody Iterable<Test> deleteByDate(
            @RequestParam(value = "date", required = true) String date) {
        testRepo.deleteByDate(date);
        return testRepo.findAll();
    }

    @PostMapping("/add_test")
    public @ResponseBody Iterable<Test> add(@RequestBody Test test, Map<String, Object> model){
        testRepo.save(test);
        return testRepo.findAll();
    }
    @GetMapping("/last")
    public @ResponseBody Iterable<Test> lats(){
        return testRepo.findTopByOrderByIdDesc();
    }
}
