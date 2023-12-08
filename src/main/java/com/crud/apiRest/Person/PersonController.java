package com.crud.apiRest.Person;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor

public class PersonController {

    @Autowired
    PersonServices personServices;

    // #region CRUD controller
    @GetMapping()
    @ResponseBody
    public List<Person> getPersons() {
        return personServices.getPersons();
    }

    @PostMapping()
    @ResponseBody
    public Person postPerson(@RequestBody Person person) {
        return personServices.postPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personServices.deletePerson(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Person getPerson(@PathVariable Integer id) {
        return personServices.getPerson(id);
    }

    @PutMapping()
    public void putPerson(@RequestBody Person person) {
        personServices.putPerson(person);
    }

    // #endregion

    @PostMapping("/login")
    @ResponseBody
    public PersonDTO login(@RequestBody Person person) {
        return personServices.login(person.getUsername(), person.getPassword());
    }
}