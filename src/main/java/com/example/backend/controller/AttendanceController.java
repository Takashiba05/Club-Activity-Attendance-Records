package com.example.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.backend.entity.Attendance;
import com.example.backend.repository.AttendanceRepository;

@RestController
@CrossOrigin(origins = "*")
public class AttendanceController {

    private final AttendanceRepository repository;

    public AttendanceController(
            AttendanceRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/api/attendance")
    public List<Attendance> getAll() {

        return repository.findAll();

    }

    @GetMapping("/api/attendance/date/{date}")
    public List<Attendance> getByDate(
            @PathVariable String date) {

        return repository.findByActivityDate(
                date
        );

    }

    @PostMapping("/api/attendance")
    public Attendance save(
            @RequestBody Attendance attendance) {

        Optional<Attendance> oldData =
                repository.findByMemberNameAndActivityDate(
                        attendance.getMemberName(),
                        attendance.getActivityDate()
                );

        if (oldData.isPresent()) {

            Attendance data =
                    oldData.get();

            data.setStatus(
                    attendance.getStatus()
            );

            return repository.save(data);

        }

        return repository.save(attendance);

    }

    @DeleteMapping("/api/attendance/{date}/{name}")
    public void deleteAttendance(
            @PathVariable String date,
            @PathVariable String name) {

        Optional<Attendance> data =
                repository.findByMemberNameAndActivityDate(
                        name,
                        date
                );

        data.ifPresent(
                repository::delete
        );

    }

}