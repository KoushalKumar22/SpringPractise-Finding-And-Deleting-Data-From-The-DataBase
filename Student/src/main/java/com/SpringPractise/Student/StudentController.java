package com.SpringPractise.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository srepo;

    @RequestMapping("/test")
    public String test(){
        return "This Is A Test Run";
    }

    @RequestMapping("/save")
    public String save(@RequestBody Student student){
        srepo.save(student);
        return "The Data Is Saves";
    }

    @RequestMapping("/all")
    public List<Student> all(){
        return srepo.findAll();
    }


    @RequestMapping("/{id}")
    public Optional<Student> byid(@PathVariable int id)
    {
        return srepo.findById(id);
    }
    @RequestMapping("/name/{name}")
    public List<Student> byname (@PathVariable String name)
    {
        return srepo.findByName(name);
    }

    @RequestMapping("/rollno/{roll}")
    public List<Student> byRoll (@PathVariable int roll){
        return srepo.findByRoll(roll);
    }

    @RequestMapping("/del/{id}")
    public String delete(@PathVariable int id){
        srepo.findById(id);
        srepo.deleteById(id);
        return "The Data Has Been Deleted";
    }
}
