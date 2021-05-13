package Hapoalim.SpringBootAssignment.Services;

import Hapoalim.SpringBootAssignment.entities.Person;
import Hapoalim.SpringBootAssignment.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;


import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private Logger LOG = LoggerFactory.getLogger(PersonService.class);

    public Optional<Person> createAndUpdateSinglePerson (Person person)
    {
        try {
            return Optional.of(personRepository.save(person));
        } catch (Exception e)
        {
            LOG.error("error accured during saving"+person.toString(),e);
        }
        return Optional.empty();
    }

    public Optional<Person> readSinglePerson(String id)
    {
        try {
            return personRepository.findById(id);
        } catch (Exception e)
        {
            LOG.error("error accured during reading person with id:"+id,e);
        }
        return Optional.empty();
    }

    public Optional<List<Person>> readMultipulePerson()
    {
        try
        {
            return Optional.of(personRepository.findAll());
        }
        catch (Exception e)
        {
            LOG.error("error accured during reading all persons",e);
        }
        return Optional.empty();
    }

    public boolean deleteSinglePerson(String id)
    {
        try {
            personRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            LOG.error("error accured during delete persson:"+id,e);
        }
        return false;
    }

}
