package com.example.demo.service;

import lombok.AllArgsConstructor;
import com.example.demo.model.PersonOfInterest;
import com.example.demo.repository.PersonOfInterestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonOfInterestServiceImpl implements PersonOfInterestService {

    private PersonOfInterestRepository personOfInterestRepository;

    @Override
    public PersonOfInterest createPersonOfInterest(PersonOfInterest personOfInterest) {
        return personOfInterestRepository.save(personOfInterest);
    }

    @Override
    public PersonOfInterest getPersonOfInterestById(Long personOfInterestId) {
        Optional<PersonOfInterest> optionalPersonOfInterest = personOfInterestRepository.findById(personOfInterestId);
        return optionalPersonOfInterest.get();
    }

    @Override
    public List<PersonOfInterest> getAllPersonOfInterests() {
        return personOfInterestRepository.findAll();
    }

    @Override
    public void deletePersonOfInterest(Long personOfInterestId) {
        personOfInterestRepository.deleteById(personOfInterestId);
    }

    @Override
    public List<PersonOfInterest> findByLastNameAndDob(String lastName, int dobMonth, int dobDay, int dobYear) {
        return personOfInterestRepository.findByLastNameAndDob(lastName, dobMonth, dobDay, dobYear);

    }
    @Override
    public List<PersonOfInterest> findByFirstNameLastNameDobYear(String firstName, String lastName, int dobYear) {
        return personOfInterestRepository.findByFirstNameLastNameDobYear(firstName, lastName, dobYear);

    }

}