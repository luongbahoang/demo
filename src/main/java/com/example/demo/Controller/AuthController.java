package com.example.demo.Controller;

import com.example.demo.dto.request.EditUserForm;
import com.example.demo.dto.request.SignInForm;
import com.example.demo.dto.request.SignUpForm;
import com.example.demo.dto.respond.JwtRespond;
import com.example.demo.dto.respond.RespondMessage;
import com.example.demo.model.Role;
import com.example.demo.model.RoleName;
import com.example.demo.model.User;
import com.example.demo.security.jwt.JwtProvider;
import com.example.demo.security.jwt.JwtTokenFilter;
import com.example.demo.security.userPrinciple.UserPrinciple;
import com.example.demo.service.impl.RoleService;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleService roleService;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    JwtTokenFilter jwtTokenFilter;
    @PostMapping("/signUp")
    public ResponseEntity <?> register(@Valid @RequestBody SignUpForm signUpForm){
        System.out.println("====================================================register");
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new RespondMessage("username_exist"),HttpStatus.OK);
        }
        if(userService.existsByCode(signUpForm.getCode())){
            return new ResponseEntity<>(new RespondMessage("code_exist"),HttpStatus.OK);
        }
       User user= new User(signUpForm.getFullname(),signUpForm.getUsername(),passwordEncoder.encode(signUpForm.getPassword()),
                            signUpForm.getGender(),signUpForm.getCode(),signUpForm.getPosition(),signUpForm.getType(),
                            signUpForm.getHireDate(),signUpForm.getComment());
        // kiểm tra giá trị của role và set vào đối tượng user
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role->{
            switch (role){
                case "admin":
                    Role adminRole= roleService.findByName(RoleName.ADMIN).orElseThrow(()->new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "guess":
                    Role guessRole= roleService.findByName(RoleName.GUESS).orElseThrow(()->new RuntimeException("Role not found"));
                    roles.add(guessRole);
                    break;
                default:
                    Role userRole= roleService.findByName(RoleName.USER).orElseThrow(()->new RuntimeException("Role not found"));
                    roles.add(userRole);

            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new RespondMessage("yes"), HttpStatus.OK);}

    @PostMapping(value="/signIn")
    public ResponseEntity<?> SignIn(@Valid @RequestBody SignInForm signInForm){
            //Xác thực người dùng {username, password }
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(),signInForm.getPassword()));

        // sau khi xác thực thành công sẽ lưu đối tượng Authentication vào SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // sau đó tạo token

        String token= jwtProvider.createToken(authentication);
        //tạo đối tượng principle

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
    return ResponseEntity.ok(new JwtRespond(token,userPrinciple.getUsername(),userPrinciple.getAuthorities()));
    }
    @PutMapping("/editUser")
    public ResponseEntity<?> EditUser(HttpServletRequest request, @Valid @RequestBody EditUserForm editUserForm){
//            String token= jwtTokenFilter.getJwt(request);
//             String  username=jwtProvider.getUserNameFromToken(token);
        try {
            if (editUserForm.getPersonalEmail() == null) {
                return new ResponseEntity<>(new RespondMessage("PersonalEmail_not_null"), HttpStatus.OK);
            }

            if (editUserForm.getFullName() == null) {
                return new ResponseEntity<>(new RespondMessage("Fullname_not_null"), HttpStatus.OK);
            }

            User user = userService.findByCode(editUserForm.getCode()).orElseThrow(() -> new UsernameNotFoundException("User Not Found -> code" + editUserForm.getCode()));
            user.setFullname(editUserForm.getFullName());
            user.setPersonalemail(editUserForm.getPersonalEmail());
            user.setPhoneNumber(editUserForm.getPhoneNumber());
            user.setTypeContract(editUserForm.getTypeContract());
            user.setCode(editUserForm.getCode());
            user.setGender(editUserForm.getGender());
            user.setCmnd(editUserForm.getCmnd());
            user.setTown(editUserForm.getTown());
            user.setCountry(editUserForm.getCountry());
            user.setReligion(editUserForm.getReligion());
            user.setYear(editUserForm.getYear());
            user.setBirthplace(editUserForm.getBirthplace());
            user.setMarital_status(editUserForm.getMarital_status());
            user.setAcademic_standard(editUserForm.getAcademic_standard());
            user.setEducation_level(editUserForm.getEducation_level());
            user.setEthnic(editUserForm.getEthnic());
            user.setStatus(editUserForm.isStatus());
            userService.save(user);
            return new ResponseEntity<>(new RespondMessage("yes"), HttpStatus.OK);
        } catch (UsernameNotFoundException exception){
            return new ResponseEntity<>(new RespondMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/delete/user/{code}")
    public ResponseEntity<?> DeleteUser(HttpServletRequest request, @PathVariable String code){
//        String token= jwtTokenFilter.getJwt(request);
//        String  username=jwtProvider.getUserNameFromToken(token);
        User user = userService.findByCode(code).orElseThrow(() -> new UsernameNotFoundException("User Not Found -> code" + code));
            userService.deleteById(user.getId());
        return new ResponseEntity<>(new RespondMessage("yes"), HttpStatus.OK);
    }
}
