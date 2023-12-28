package lms.library.management.system.Controllers;


import lms.library.management.system.DataAccessLayer.Users;
import lms.library.management.system.DataAccessLayer.UsersRepository;
import lms.library.management.system.Requests.UsersReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/addUser")
    public void addUser(@RequestBody UsersReq usersReq) {
        Users user= new Users(usersReq.getUserName(), usersReq.getPhone());
        usersRepository.save(user);
    }

    @GetMapping("/usersList")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

}
