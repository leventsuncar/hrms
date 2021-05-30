package com.hrms.entites;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_advertisement")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "job_description", length = 500)
    private String jobDescription;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "open_position")
    private Integer openPosition;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;


}
