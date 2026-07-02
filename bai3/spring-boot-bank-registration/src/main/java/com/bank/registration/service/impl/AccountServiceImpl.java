package com.bank.registration.service.impl;

import com.bank.registration.dto.AccountRequestDTO;
import com.bank.registration.dto.AccountResponseDTO;
import com.bank.registration.entity.Account;
import com.bank.registration.repository.AccountRepository;
import com.bank.registration.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Lớp triển khai chi tiết các nghiệp vụ đăng ký tài khoản ngân hàng.
 * Đảm bảo tính toàn vẹn dữ liệu bằng @Transactional.
 *
 * @author Senior Backend Developer
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public AccountResponseDTO registerAccount(AccountRequestDTO requestDTO) {
        
        // 1. Kiểm tra ràng buộc duy nhất (Unique Constraints)
        if (accountRepository.existsByPhone(requestDTO.getPhone())) {
            throw new IllegalArgumentException("Số điện thoại này đã được đăng ký trong hệ thống!");
        }
        if (accountRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalArgumentException("Email này đã được đăng ký trong hệ thống!");
        }
        if (accountRepository.existsByCitizenId(requestDTO.getCitizenId())) {
            throw new IllegalArgumentException("Số CCCD này đã được đăng ký trong hệ thống!");
        }

        // 2. Thuật toán sinh số tài khoản ngẫu nhiên
        String generatedAccountNumber = "99" + String.format("%08d", (int) (Math.random() * 100000000));

        // 3. Mapping dữ liệu từ DTO sang Entity
        Account account = Account.builder()
                .fullName(requestDTO.getFullName())
                .phone(requestDTO.getPhone())
                .email(requestDTO.getEmail())
                .citizenId(requestDTO.getCitizenId())
                .accountNumber(generatedAccountNumber)
                .status("ACTIVE")
                .build();

        // 4. Lưu xuống Database
        Account savedAccount = accountRepository.save(account);

        // 5. Trả về Response DTO
        return AccountResponseDTO.builder()
                .accountId(savedAccount.getId())
                .accountNumber(savedAccount.getAccountNumber())
                .status(savedAccount.getStatus())
                .build();
    }
}
