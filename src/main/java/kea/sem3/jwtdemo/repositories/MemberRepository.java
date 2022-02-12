package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.BaseUser;
import kea.sem3.jwtdemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public interface MemberRepository extends JpaRepository<Member,String> {
    Optional<BaseUser> findByUsername(String username);
}