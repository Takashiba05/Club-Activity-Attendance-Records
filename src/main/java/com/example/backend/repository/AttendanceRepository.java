package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.entity.Attendance;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    Optional<Attendance>
        findByMemberNameAndActivityDate(
            String memberName,
            String activityDate
        );

    List<Attendance>
        findByActivityDate(
            String activityDate
        );

}