package com.example.demo.service;

import com.example.demo.model.Staff;
import java.util.List;

public interface StaffService {
    Staff createStaff(Staff staff);

    Staff getStaffById(Long staffId);

    List<Staff> getAllStaffs();

    Staff updateStaff(Staff staff);

    void deleteStaff(Long staffId);
}