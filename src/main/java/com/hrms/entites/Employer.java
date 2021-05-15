package com.hrms.entites;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//bu bir entity'dir
@Entity
//all args cons no args cons getter setter
@Data
//tablo adı
@Table(name = "employer")
public class Employer {

    //primary key tanımı
    @Id
    //Column adı
    @Column(name = "id")
    //otomatik olusturulan alan
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    //unique = true bu kolonun unique olduğunu belirtir. aynı adla kayıt olunamaz nullable = false bu alan boş olamaz
    @Column(name = "company_name", unique = true, nullable = false)
    //bu alanın boş olamayacağını belirtir.
    @NotNull
    private String companyName;

    @Column(name = "website", unique = true, nullable = false)
    @NotNull
    private String website;

    //lenght verinin karakter uzunluğunu belirtir ama buradan ayarlayamadım.
    @Column(name = "telephone_number", length = 11, unique = true, nullable = false)
    @NotNull
    private Long telephoneNumber;

    // user adlı tablo ile 1 e 1 ilişki kurulduğunu belirtir.
    @OneToOne
    private User user;
}
