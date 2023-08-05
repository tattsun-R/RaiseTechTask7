package com.tattsun.RaiseTechTask7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/profiles")
    public ResponseEntity<List<UserProfile>> getUserProfile(
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "birthdate", required = false) String stBirthDate
    ) {
        List<UserProfile> userProfiles = new ArrayList<>();

        // nameとbirthdateがnullもしくは空文字でない場合、その値を使用してUserProfileを作成
        if (name != null && !name.isEmpty() && stBirthDate != null && !stBirthDate.isEmpty()) {
            try {
                LocalDate birthDate = LocalDate.parse(stBirthDate);
                userProfiles.add(new UserProfile(name, birthDate));
            } catch (DateTimeParseException e) {
                // 無効な日付の文字列が渡された場合のエラーハンドリング
                return ResponseEntity.badRequest().build();

            }
        } else {
            // クエリ文字列が指定されていない場合、ダミーデータを返す
            userProfiles.add(new UserProfile("Taro Inaba", LocalDate.of(2004, 9, 23)));
            userProfiles.add(new UserProfile("Ichiro Matsumoto", LocalDate.of(2000, 3, 27)));
        }

            return ResponseEntity.ok(userProfiles);
    }

    @PostMapping("/profiles")
    public ResponseEntity<CreateResponse> createUserProfile(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/profiles/1")
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
