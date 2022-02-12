package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.dto.UserResponse;
import kea.sem3.jwtdemo.service.MemberService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    MemberService memberService;

    public UserController(MemberService memberService) {
        this.memberService = memberService;
    }

    //access-all
    @GetMapping
    public List<UserResponse> getMembers(){
        return memberService.getMembers();
    }

    //access-all
    @GetMapping("/{username}")
    public UserResponse getMembers(@PathVariable String username) throws Exception{
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(username);
        return memberService.getMember(username,false);
    }


}