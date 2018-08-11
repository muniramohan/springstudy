package com.bnp.showroom.members;

import com.bnp.showroom.userprofile.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity memberSave(@RequestBody Members members) {
        try {
            ProjectMembers projectMembers = new ProjectMembers();
            for (int i = 0; i < members.getUserID().size(); i++) {
                projectMembers.setProjectID(members.getProjectID());
                projectMembers.setUserID(members.getUserID().get(i));
            }
            memberRepository.deleteByProjectID(members.getProjectID());
            memberRepository.save(projectMembers);
            logger.info("Member details saved successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    public ResponseEntity memberDelete(@RequestBody Members members) {
        try {
            memberRepository.deleteByProjectID(members.getProjectID());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value ="{id}")
    public ResponseEntity membersList(@PathVariable("id") long projectID) {
        try {
            System.out.println("inside" + projectID);
            Object result ; //= new ArrayList<UserProfile>();
            result = memberRepository.findAllByProjectID(projectID);

//            List result;
//            result = em.createQuery(
//                    "SELECT p  FROM UserProfile p JOIN ProjectMembers m ON m.userID = p.id WHERE m.projectID =:id")
//                    .setParameter("id", projectID)
//                    .getResultList();
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}