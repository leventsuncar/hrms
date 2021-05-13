package com.hrms.entites.concretes;


import lombok.Data;

import javax.persistence.*;
//not null anotasyonun çalışması için import edilmesi gereken yer
//not null hala düzgün çalışmıyor...
import javax.validation.constraints.NotNull;

//bu bir entitydir
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

    //unique = true bu kolonun unique olduğunu belirtir. aynı adla kayıt olunamaz
    @Column(name = "company_name", unique = true)
    //bu alanın boş olamayacağını belirtir.
    @NotNull
    private String companyName;

    @Column(name = "website", unique = true)
    @NotNull
    private String website;

    //lenght verinin karakter uzunluğunu belirtir
    @Column(name = "telephone_number", length = 11, unique = true)
    @NotNull
    private Long telephoneNumber;

    // base user adlı tablo ile 1 e 1 ilişki kurulduğunu belirtir.
    @OneToOne
    @NotNull
    private Login login;
}
