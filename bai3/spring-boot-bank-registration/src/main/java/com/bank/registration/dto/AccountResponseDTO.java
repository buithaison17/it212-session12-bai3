package com.bank.registration.dto;

import lombok.*;

/**
 * DTO chứa thông tin kết quả trả về sau khi đăng ký tài khoản thành công.
 *
 * @author Senior Backend Developer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDTO {
    private Long accountId;
    private String accountNumber;
    private String status;
}
