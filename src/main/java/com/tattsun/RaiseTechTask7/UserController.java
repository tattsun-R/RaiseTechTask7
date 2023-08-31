package com.tattsun.RaiseTechTask7;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.*;

@RestController
public class UserController {

    Map<Integer,String> userProfile = new LinkedHashMap<>();
    {
        userProfile.put(1, "Taro Inaba");
        userProfile.put(2, "Ichiro Matsumoto");
        userProfile.put(3, "Jiro Masuda");
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<UserProfile> getUserProfile (@PathVariable int id) {
        String userProfile = this.userProfile.get(id);
            if (userProfile != null) {
                UserProfile profile = new UserProfile(id, userProfile);
                return ResponseEntity.ok(profile);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @Value("${app.baseurl}")
    private String baseUrl;

    @PostMapping("/profiles")
    public ResponseEntity<CreateResponse> createUserProfile(@Valid @RequestBody  CreateForm form) {

        String name = form.getName();
        LocalDate birthDate = form.getBirthDate();

        URI url = UriComponentsBuilder.fromUriString(this.baseUrl)
                .path("/profiles")
                .queryParam("name", name)
                .queryParam("birthDate", birthDate)
                .build()
                .toUri();
              return ResponseEntity.created(url).body(new CreateResponse("UserProfile successfully created"));
    }

    @PatchMapping("profiles/{id}")
    public ResponseEntity<UpdateResponse> updateUserProfile(@PathVariable("id") int id, @RequestBody UpdateForm form) {
                return ResponseEntity.ok(new UpdateResponse("UserProfile successfully updated"));
    }

    @DeleteMapping("profiles/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable("id") int id) {
             return ResponseEntity.noContent().build();
    }

}
