package Hapoalim.SpringBootAssignment.controllers;

import Hapoalim.SpringBootAssignment.Services.PersonService;
import Hapoalim.SpringBootAssignment.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/readSinglePerson")
    public ResponseEntity readSinglePerson(String id)
    {
        Optional person = personService.readSinglePerson(id);
        if(person.isPresent())
        {
            return new ResponseEntity(person.get(),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/readMultipulPersons")
    public ResponseEntity readMultipulPersons()
    {
        Optional personList = personService.readMultipulePerson();
        if(personList.isPresent())
        {
            return new ResponseEntity(personList.get(),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createSinglePerson")
    public ResponseEntity createSinglePerson(@RequestBody Person person)
    {
        return createAndUpdateSinglePerson(person);
    }

    @PutMapping("/updateSinglePerson")
    public ResponseEntity updateSinglePerson(@RequestBody Person person) {
        return createAndUpdateSinglePerson(person);
    }

    @DeleteMapping("/deleteSinglePerson")
    public ResponseEntity deleteSinglePerson(@RequestBody String id)
    {
        if(personService.deleteSinglePerson(id))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }



    private ResponseEntity createAndUpdateSinglePerson(@RequestBody Person person)
    {
        Optional personResponse = personService.createAndUpdateSinglePerson(person);
        if(personResponse.isPresent())
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
