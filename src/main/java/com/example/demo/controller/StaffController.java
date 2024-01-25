package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/staffs")
public class StaffController {

    private StaffService staffService;

    // build create  REST API
    @PostMapping("/save")
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff){
        Staff savedStaff = staffService.createStaff(staff);
        return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
    }

    // build get staff by id REST API
    // http://localhost:8080/api/staffs/1
    @GetMapping("/findById/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") Long staffId){
        Staff staff = staffService.getStaffById(staffId);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    // Build Get All Staffs REST API
    // http://localhost:8080/api/staffs
    @GetMapping("/findAll")
    public ResponseEntity<List<Staff>> getAllStaffs(){
        List<Staff> staffs = staffService.getAllStaffs();
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    // Build Update Staff REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/staffs/1
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") Long staffId,
                                                   @RequestBody Staff staff){
        staff.setStaff_id(staffId);
        Staff updatedStaff = staffService.updateStaff(staff);
        return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
    }

    // Build Delete Staff REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") Long staffId){
        staffService.deleteStaff(staffId);
        return new ResponseEntity<>("Staff successfully deleted!", HttpStatus.OK);
    }
}