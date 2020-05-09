package com.example.serverfortest;

import com.example.serverfortest.domain.Test;
import com.example.serverfortest.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ServerController {
    @Autowired
    private TestRepo testRepo;

    @GetMapping("/get/tests")
    public @ResponseBody Iterable<Test> findAll() {
        return testRepo.findAll();
    }

    @GetMapping("/get/by_type")
    public @ResponseBody Iterable<Test> findByType(
            @RequestParam(value = "type", required = true) String type) {
        return testRepo.findByTypeLike(type);
    }

    @GetMapping("/get/by_date")
    public @ResponseBody Iterable<Test> findByDate(
            @RequestParam(value = "date", required = true) String date) {
        return testRepo.findByDateLike(date);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll(){
        testRepo.deleteAll();
    }

    @DeleteMapping("/delete/by_date")
    public void deleteByDate(
            @RequestParam(value = "date", required = true) String date) {
        testRepo.deleteByDate(date);
    }

    @DeleteMapping("/delete/id")
    public void deleteById(
            @RequestParam(value = "id", required = true) Long id) {
        testRepo.deleteById(id);
    }

    @PostMapping("/add_test")
    public @ResponseBody Iterable<Test> add(
            @RequestBody Test test, Map<String, Object> model) {
        testRepo.save(test);
        return testRepo.findAll();
    }
    @GetMapping("/last")
    public @ResponseBody Iterable<Test> lats() {
        return testRepo.findTopByOrderByIdDesc();
    }
}
