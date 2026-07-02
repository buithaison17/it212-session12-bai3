package com.bank.registration.repository;

import com.bank.registration.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository quản lý các thao tác CRUD và truy vấn nâng cao cho Entity Account.
 * Kế thừa Spring Data JPA để tự động hóa các câu lệnh SQL.
 *
 * @author Senior Backend Developer
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
    boolean existsByCitizenId(String citizenId);
}
