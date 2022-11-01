package com.task.backend.service;

import com.task.backend.model.PersonModel;
import com.task.backend.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private boolean personStatus;

    public boolean isPersonStatus() {
        return personStatus;
    }

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<PersonModel> getAllPerson(){
        return personRepository.findAll();
    }

    public boolean createPerson(String personName, String personPassword,
                                String personEmail, String personPhone,
                                String personAddress, String personResume,
                                LocalDateTime personCreateAt, LocalDateTime personUpdateAt,
                                String personStatus){
        PersonModel personModel = new PersonModel();
//        personModel.setPersonId(personId);
        personModel.setPersonName(personName);
        personModel.setPersonPassword(personPassword);
        personModel.setPersonEmail(personEmail);
        personModel.setPersonPhone(personPhone);
        personModel.setPersonAddress(personAddress);
        personModel.setPersonResume(personResume);
        personModel.setPersonCreateAt(personCreateAt);
        personModel.setPersonUpdateAt(personUpdateAt);
        personModel.setPersonStatus(personStatus);

        personRepository.save(personModel);

        return true;
    }
    public PersonModel getEmail(String personEmail) {
        Optional<PersonModel> personOpt = personRepository.findByPersonEmail(personEmail);
        if (personOpt.isEmpty()) {
            return null;
        } else {
            return personOpt.get();
        }
    }
    public PersonModel getPerson(int personId) {
        Optional<PersonModel> personOpt = personRepository.findById(personId);
        if (personOpt.isEmpty()) {
            return null;
        } else {
            return personOpt.get();
        }
    }

//    public PersonModel getByLogin(String personEmail) {
//        Optional<PersonModel> personOpt = personRepository.findByLogin(personEmail);
//        if (personOpt.isEmpty()) {
//            return null;
//        } else {
//            return personOpt.get();
//        }
//    }

    public PersonModel getPersonLoginParam(String personEmail, String personPassword) {
        Optional<PersonModel> personOpt = personRepository.findByPersonEmail(personEmail); personRepository.findByPersonPassword(personPassword);
        if (personOpt.isEmpty()) {
            return null;
        } else {
            return personOpt.get();
        }
    }
    public PersonModel getPersonLogin(String personEmail, String personPassword) {
        Optional<PersonModel> personOpt = personRepository.findByPersonEmail(personEmail); personRepository.findByPersonPassword(personPassword);
        if (personOpt.isEmpty()) {
            return null;
        } else {
            return personOpt.get();
        }
    }
}
