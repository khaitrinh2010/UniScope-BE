package usyd27.UniScope.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Use POST for saving new users
    @PostMapping()
    public ResponseEntity<String> save(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("User saved successfully");
    }

    @GetMapping("/siu")
    public ResponseEntity<String> siu(Authentication authentication) {
        if(authentication instanceof UsernamePasswordAuthenticationToken){
            System.out.println("normal");
        }
        else if(authentication instanceof OAuth2AuthenticationToken){
            System.out.println("github");
        }
        return ResponseEntity.ok("siu");
    }
}
