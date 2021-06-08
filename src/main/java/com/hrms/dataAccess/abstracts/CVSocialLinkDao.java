package com.hrms.dataAccess.abstracts;

import com.hrms.entites.CVSocialLinks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVSocialLinkDao extends JpaRepository<CVSocialLinks,Integer> {
}
