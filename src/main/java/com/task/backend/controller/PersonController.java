package com.task.backend.controller;

import com.task.backend.model.request.PersonIdRequest;
import com.task.backend.model.PersonModel;
import com.task.backend.service.PersonService;
import com.task.backend.utils.response.DataResponse;
import com.task.backend.utils.response.HandlerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
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
    public void getAllPerson(HttpServletRequest request, HttpServletResponse response) {
        DataResponse<List<PersonModel>> data = new DataResponse<>();
        data.setData(personService.getAllPerson());
        HandlerResponse.responseSuccessWithData(response, data);
    }

    @GetMapping("/person/{personId}")
    public void getPerson(HttpServletRequest request, HttpServletResponse response,
                                 @PathVariable int personId) {
        PersonModel person = personService.getPerson(personId);
        if (person == null) {
            HandlerResponse.responseBadRequest(response, "02", "Failed");
        } else {
            DataResponse<PersonModel> data = new DataResponse<>();
            data.setData(person);
            HandlerResponse.responseSuccessWithData(response, data);
        }
    }

    @GetMapping("/person/param")
    public void getPersonParam(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam("personId") int personId){
        PersonModel person = personService.getPerson(personId);
        if (person == null) {
            HandlerResponse.responseBadRequest(response, "02", "Failed");
        } else {
            DataResponse<PersonModel> data = new DataResponse<>();
            data.setData(person);
            HandlerResponse.responseSuccessWithData(response, data);
        }
    }

    @GetMapping("/person/body")
    public void getPersonBody(HttpServletRequest request, HttpServletResponse response,
                                     @RequestBody PersonIdRequest personIdRequest) {
        PersonModel person = personService.getPerson(personIdRequest.getPersonId());
        if (person == null) {
            HandlerResponse.responseBadRequest(response, "02", "Failed");
        } else {
            DataResponse<PersonModel> data = new DataResponse<>();
            data.setData(person);
            HandlerResponse.responseSuccessWithData(response, data);
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
    public void getPersonLogin(HttpServletRequest request, HttpServletResponse response,
                                      @PathVariable("personEmail") String personEmail,
                                      @PathVariable("personPassword") String personPassword) {
        PersonModel person = personService.getPersonLogin(personEmail, personPassword);
        if (person == null) {
            HandlerResponse.responseBadRequest(response, "02", "Failed");
        } else {
            DataResponse<PersonModel> data = new DataResponse<>();
            data.setData(person);
            HandlerResponse.responseSuccessWithData(response, data);
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
    public void getPersonLoginParam(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam("personEmail") String personEmail,
                                           @RequestParam("personPassword") String personPassword){
        PersonModel person = personService.getPersonLoginParam(personEmail, personPassword);
        if (person == null) {
            HandlerResponse.responseBadRequest(response, "02", "Failed");
        } else {
            DataResponse<PersonModel> data = new DataResponse<>();
            data.setData(person);
            HandlerResponse.responseSuccessWithData(response, data);
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
                               @RequestParam("personCreateAt") LocalDateTime personCreateAt,
                               @RequestParam("personUpdateAt") LocalDateTime personUpdateAt,
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
