package br.com.passwordvalidator.adapter.in;

import br.com.passwordvalidator.application.port.in.ValidatePasswordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
class PasswordController {

    private final ValidatePasswordUseCase validatePasswordUseCase;

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validatePassword(@RequestParam final String password) {
        return ResponseEntity.ok(validatePasswordUseCase.validatePassword(password));
    }
}
