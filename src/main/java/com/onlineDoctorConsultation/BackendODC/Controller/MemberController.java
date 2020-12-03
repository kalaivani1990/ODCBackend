package com.onlineDoctorConsultation.BackendODC.Controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineDoctorConsultation.BackendODC.Dao.MemberDAO;
import com.onlineDoctorConsultation.BackendODC.Model.Member;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/testcall")
public class MemberController {

	@Autowired
	MemberDAO memberDAO;
	
	@GetMapping("/simple")
	public ResponseEntity<String> getString() {
		System.out.println("i am here");
		return ResponseEntity.ok("vani");
	}

	/* to create a new member */
	@PostMapping("/members")
	public Member createMember(@Valid @RequestBody Member mem) throws IOException {
		return memberDAO.save(mem);
	}

	/* to list existing members */
	@GetMapping("/members")
	public List<Member> getAllMembers() {
		return memberDAO.findAll();
	}

	/* to read an existing member by member id */
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long memid) {

		/*Member mem = memberDAO.findOne(memid); */
		Member mem = new Member();

		if (mem == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mem);

	}

	/* to update an existing member */
	@PutMapping("/members/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long memid,
			@Valid @RequestBody Member memDetails) {

		/*Member mem = memberDAO.findOne(memid);*/
		
		Member mem = new Member();
		if (mem == null) {
			return ResponseEntity.notFound().build();
		}

		mem.setFirstName(memDetails.getFirstName());
		mem.setLastName(memDetails.getLastName());
		mem.setDateofBirth(memDetails.getDateofBirth());
		mem.setPostalCode(memDetails.getPostalCode());
		mem.setPic(memDetails.getPic());

		Member updateMember = memberDAO.save(mem);
		return ResponseEntity.ok().body(updateMember);

	}

	/* to delete a member */
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Member> deleteMember(@PathVariable(value = "id") Long memid) {

		/*Member mem = memberDAO.findOne(memid);*/
		Member mem = new Member();
		if (mem == null) {
			return ResponseEntity.notFound().build();
		}
		memberDAO.delete(mem);

		return ResponseEntity.ok().build();

	}

}
