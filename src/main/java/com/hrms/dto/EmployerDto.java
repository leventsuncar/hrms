package com.hrms.dto;

import lombok.Data;


@Data
public class EmployerDto {

    //Her Employer bir userdır.
    //Her User bir employer değildir.
    //Bu yüzden employer eklerken user da eklemem gerekiyor
    //Bu Dtoda employer için gerekli bilgiler olduğu gibi user için gerekli bilgiler de bulunuyor.
    //Ekleme işlemlerini bu Dtodaki fieldlara göre yapıyorum.
    //Database'e eklelemek içinse ModelMapper kullanıyorum.
    //Bunun yerinde getter ve setterlar kullanılabilir.
    //Aynı şey bütün tablolar için geçerlidir.

    private String companyName;
    private String website;
    private Long telephoneNumber;
    private String email; //Employer entity'sinde böyle bir bilgi yok. Bu bilgi User entitysinden gelecek.
    private String password; //Employer entity'sinde böyle bir bilgi yok. Bu bilgi User entitysinden gelecek.
}
