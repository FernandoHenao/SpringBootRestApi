package com.example.demo.service;

import lombok.AllArgsConstructor;
import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.StaffService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff getStaffById(Long staffId) {
        Optional<Staff> optionalStaff = staffRepository.findById(staffId);
        return optionalStaff.get();
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public Staff updateStaff(Staff staff) {
        Staff existingStaff = staffRepository.findById(staff.getStaff_id()).get();
        existingStaff.setFirstName(staff.getFirstName());
        existingStaff.setLastName(staff.getLastName());
        existingStaff.setLast_Update(staff.getLast_Update());
        Staff updatedStaff= staffRepository.save(existingStaff);
        return updatedStaff;
    }

    @Override
    public void deleteStaff(Long staffId) {
        staffRepository.deleteById(staffId);
    }
}