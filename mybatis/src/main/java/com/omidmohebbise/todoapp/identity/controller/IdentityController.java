package com.omidmohebbise.todoapp.identity.controller;


import com.omidmohebbise.todoapp.identity.usecase.SignInUC;
import com.omidmohebbise.todoapp.identity.usecase.SignOutUC;
import com.omidmohebbise.todoapp.identity.usecase.SignUpUC;
import com.omidmohebbise.todoapp.identity.usecase.dto.SignInRequestDto;
import com.omidmohebbise.todoapp.identity.usecase.dto.SignUpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class IdentityController {
    private final SignInUC signInUC;
    private final SignUpUC signUpUC;
    private final SignOutUC signOutUC;

    public IdentityController(SignInUC signInUC, SignUpUC signUpUC, SignOutUC signOutUC) {
        this.signInUC = signInUC;
        this.signUpUC = signUpUC;
        this.signOutUC = signOutUC;
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> signIn(@RequestBody @Valid SignInRequestDto authenticationRequestDto) {
        try {
            return ResponseEntity.ok().body(signInUC.execute(authenticationRequestDto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        try {
            signUpUC.execute(signUpRequest);
            return ResponseEntity.ok().body("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/auth/sign-out")
    public ResponseEntity<?> signOut() {
        try {
            signOutUC.execute();
            return ResponseEntity.ok().body("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

}
