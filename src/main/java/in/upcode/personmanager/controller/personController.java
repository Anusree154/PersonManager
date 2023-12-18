package in.upcode.personmanager.controller;

import in.upcode.personmanager.model.Person;
import in.upcode.personmanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")

public class personController {

    @Autowired
    PersonRepository personRepository;



    @RequestMapping(value ="")
    List<Person> showOnePerson() {


        return personRepository.findAll();

    }



    @RequestMapping("/{id}")
    Person getmepersonwithId(@PathVariable("id") Integer id){
        System.out.println(id);
        final Optional<Person> optionalPerson=personRepository.findById(id);
        if(optionalPerson.isPresent())
        {
            return optionalPerson.get();
        }
        throw new RuntimeException("Not found!!");

    }

    @RequestMapping("/name/{name}")
    Person getmepersonwithName(@PathVariable("name") String name){
        System.out.println(name);
        final Optional<Person> optionalPerson=personRepository.findByNameIgnoreCase(name);
        if(optionalPerson.isPresent())
        {
            return optionalPerson.get();
        }
        throw new RuntimeException("Not found!!");

    }
}

