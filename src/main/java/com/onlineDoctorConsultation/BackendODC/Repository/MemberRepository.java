package com.onlineDoctorConsultation.BackendODC.Repository;

import com.onlineDoctorConsultation.BackendODC.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
