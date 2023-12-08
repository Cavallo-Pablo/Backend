package com.crud.apiRest.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    // #region CRUD services

    public Person postPerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person getPerson(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public void putPerson(Person person) {
        personRepository.save(person);
    }

    // #endregion

    public PersonDTO login(String username, String password) {
        /* return */Person person = personRepository.findByUsernameAndPassword(username, password);
        PersonDTO personDTO = new PersonDTO(person.getId(),person.getFirstName(),person.getLastName(),person.getEmail());
        return personDTO;
    }
}