package vinylStoreHiber.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vinylStoreHiber.model.User;
import vinylStoreHiber.services.IUserService;

@Controller
@RequestMapping(value = "/admin/utils")
public class addDB {

    @Autowired
    IUserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setName("adminName");
        user.setSurname("adminSurname");
        user.setLogin("admin");
        String hashedPassword = DigestUtils.md5Hex("admin");
        user.setPass(hashedPassword);
        user.setRole(User.Role.ADMIN);

        User user1 = new User();
        user1.setName("kamil");
        user1.setSurname("kamil");
        user1.setLogin("kamil");
        user1.setPass("11d462a4a1b14b00580d8020d6f64998");
        user1.setRole(User.Role.USER);




        userService.addUser(user);
        userService.addUser(user1);

        return "redirect:/login";
    }
}
