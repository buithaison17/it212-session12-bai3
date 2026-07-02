package com.bank.registration.service;

import com.bank.registration.dto.AccountRequestDTO;
import com.bank.registration.dto.AccountResponseDTO;

/**
 * Interface định nghĩa các nghiệp vụ (Business Logic) liên quan đến tài khoản.
 *
 * @author Senior Backend Developer
 */
public interface AccountService {
    AccountResponseDTO registerAccount(AccountRequestDTO requestDTO);
}
