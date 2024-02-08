package com.example.demo.repository;

import com.example.demo.model.PersonOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonOfInterestRepository extends JpaRepository<PersonOfInterest, Long> {

    @Query(nativeQuery = true,

            value =
                    "SELECT * "
                            + "FROM PERSON_OF_INTEREST "
                            + "WHERE "
                            + "LAST_NAME=?1 "
                            + "AND DOB_MONTH=?2 "
                            + "AND DOB_DAY=?3 "
                            + "AND DOB_YEAR=?4 ")
    public List<PersonOfInterest> findByLastNameAndDob(String lastName, int dobMonth, int dobDay, int dobYear);

    @Query(nativeQuery = true,

            value =
                    "SELECT * "
                            + "FROM PERSON_OF_INTEREST "
                            + "WHERE "
                            + "FIRST_NAME=?1 "
                            + "AND LAST_NAME=?2 "
                            + "AND DOB_YEAR=?3 ")
    public List<PersonOfInterest> findByFirstNameLastNameDobYear(String firstName, String lastName, int dobYear);
}