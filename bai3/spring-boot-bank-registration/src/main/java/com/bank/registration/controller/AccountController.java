package com.bank.registration.controller;

import com.bank.registration.dto.AccountRequestDTO;
import com.bank.registration.dto.AccountResponseDTO;
import com.bank.registration.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller cung cấp API đăng ký mở tài khoản trực tuyến.
 *
 * @author Senior Backend Developer
 */
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountRequestDTO requestDTO) {
        AccountResponseDTO response = accountService.registerAccount(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
