package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.ApplicationUserService;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: Joel Angehrn
 * Version: 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserService applicationUserService;
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder,
                          ApplicationUserService applicationUserService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.applicationUserService = applicationUserService;
    }

    /**
     * Create single Account
     * @param user
     */
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    /**
     *
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationUser> getAllUsers() {
        return applicationUserRepository.findAll();
    }

    /**
     * Delete single User
     * @param id
     * @param user
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id, ApplicationUser user) {
        applicationUserService.deleteUser(id);
    }

    /**
     * Edit single User
     * @param user
     */
    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@Valid @RequestBody ApplicationUser user) {
        applicationUserService.editUser(user);
    }
}
