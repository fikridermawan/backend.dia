package com.task.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<PersonModel> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/person/{personId}")
    public PersonModel getPerson(@PathVariable int personId) {
        PersonModel person = personService.getPerson(personId);
        if (person == null) {
            return new PersonModel();
        } else {
            return person;
        }
    }

    @GetMapping("/person/param")
    public PersonModel getPersonParam(@RequestParam("personId") int personId){
        PersonModel person = personService.getPerson(personId);
        if (person == null) {
            return new PersonModel();
        } else {
            return person;
        }
    }

    @GetMapping("/person/body")
    public PersonModel getPersonBody(@RequestBody PersonIdRequest personIdRequest) {
        PersonModel person = personService.getPerson(personIdRequest.getPersonId());
        if (person == null) {
            return new PersonModel();
        } else {
            return person;
        }
    }

//    @GetMapping("/person/login/{personEmail}")
//    public PersonModel getByLogin(@PathVariable("personEmail") String personEmail) {
//        PersonModel person = personService.getByLogin(personEmail);
//        if (person == null) {
//            return new PersonModel();
//        } else {
//            return person;
//        }
//    }
    @GetMapping("/person/login/{personEmail}/{personPassword}")
    public PersonModel getPersonLogin(@PathVariable("personEmail") String personEmail,
                                      @PathVariable("personPassword") String personPassword) {
        PersonModel person = personService.getPersonLogin(personEmail, personPassword);
        if (person == null) {
            return new PersonModel();
        } else {
            return person;
        }
    }
//    @GetMapping("/person/login/body")
//    public PersonModel getPersonLoginBody(@RequestBody PersonLoginRequest personLoginRequest) {
//        PersonModel person = personService.getPerson(personLoginRequest.getPersonEmail());
//        if (person == null) {
//            return new PersonModel();
//        } else {
//            return person;
//        }
//    }
    @GetMapping("/person/login/param")
    public PersonModel getPersonLoginParam(@RequestParam("personEmail") String personEmail,
                                           @RequestParam("personPassword") String personPassword){
        PersonModel person = personService.getPersonLoginParam(personEmail, personPassword);
        if (person == null) {
            return new PersonModel();
        } else {
            return person;
        }
    }

    @PostMapping("/person/register")
    public String createPerson(
                               @RequestParam("personName") String personName,
                               @RequestParam("personPassword") String personPassword,
                               @RequestParam("personEmail") String personEmail,
                               @RequestParam("personPhone") String personPhone,
                               @RequestParam("personAddress") String personAddress,
                               @RequestParam("personResume") String personResume,
                               @RequestParam("personCreateAt") String personCreateAt,
                               @RequestParam("personUpdateAt") String personUpdateAt,
                               @RequestParam("personStatus") String personStatus) {
        if(personService.createPerson(personName, personPassword, personEmail, personPhone,
                personAddress, personResume, personCreateAt, personUpdateAt, personStatus)) {
            return "Sukses Regiter";
        } else {
            return "Failed Register";
        }
    }

    @GetMapping("/person/register/get")
    public PersonModel getEmail(@RequestParam("personEmail") String personEmail){
        PersonModel person = personService.getEmail(personEmail);
        if (person == null) {
            return new PersonModel();
        } else {
            return person;
        }
    }
}
