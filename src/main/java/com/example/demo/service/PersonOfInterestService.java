package com.example.demo.service;

import com.example.demo.model.PersonOfInterest;
import java.util.List;

public interface PersonOfInterestService {
    PersonOfInterest createPersonOfInterest(PersonOfInterest personOfInterest);

    PersonOfInterest getPersonOfInterestById(Long personOfInterestId);

    List<PersonOfInterest> getAllPersonOfInterests();

    void deletePersonOfInterest(Long personOfInterestId);

    public List<PersonOfInterest> findByLastNameAndDob(String lastName, int dobMonth, int dobDay, int dobYear);

    public List<PersonOfInterest> findByFirstNameLastNameDobYear(String firstName, String lastName, int dobYear);
}