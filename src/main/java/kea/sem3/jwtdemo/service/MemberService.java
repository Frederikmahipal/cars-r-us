package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.UserResponse;
import kea.sem3.jwtdemo.entity.BaseUser;
import kea.sem3.jwtdemo.entity.Member;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CarRepository;
import kea.sem3.jwtdemo.repositories.MemberRepository;
import kea.sem3.jwtdemo.security.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<UserResponse> getMembers(){
        List<Member> users = memberRepository.findAll();
        return UserResponse.getMembersFromEntities(users);
    }

    public UserResponse getMember(String username, boolean all) throws Exception {
        UserResponse response = new UserResponse(memberRepository.findByUsername(username).orElseThrow(() ->new Client4xxException("no member with this username")), false);
        return response;
    }
}
