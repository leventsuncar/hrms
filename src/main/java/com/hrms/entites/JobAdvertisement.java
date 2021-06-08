package com.hrms.entites;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_advertisement")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "job_description", length = 500)
    private String jobDescription;

    @NotNull
    @Column(name = "salary")
    private Integer salary;

    @NotNull
    @Column(name = "open_position")
    private Integer openPosition;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
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
