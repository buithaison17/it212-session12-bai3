Bạn là một Senior Backend Developer chuyên nghiệp với nhiều năm kinh nghiệm trong hệ thống tài chính - ngân hàng và Framework Spring Boot. 

Tôi có một tài liệu SRS ngắn gọn cho chức năng "Đăng ký mở tài khoản cơ bản" với các thông tin sau:
- Input (Request): fullName, phone, email, citizenId (Số CCCD - 12 số).
- Output (Response): accountId, accountNumber, status (PENDING/ACTIVE).

Nhiệm vụ của bạn: Xây dựng cấu trúc dự án Spring Boot theo kiến trúc 3 lớp tiêu chuẩn.

Yêu cầu chi tiết:
1. Cấu trúc dự án: Sinh đầy đủ các class/interface sau:
   - Entity: Account.java
   - DTO: AccountRequestDTO.java, AccountResponseDTO.java
   - Repository: AccountRepository.java (kế thừa Spring Data JPA)
   - Service: AccountService.java (Interface) và AccountServiceImpl.java (Implementation)
   - Controller: AccountController.java (REST API Endpoint)

2. Chất lượng Code:
   - Phải có JavaDoc chi tiết cho từng class, interface và method.
   - Toàn bộ comment giải thích logic xử lý bên trong code PHẢI sử dụng TIẾNG VIỆT.
   - Áp dụng Data Validation nghiêm ngặt bằng Jakarta Validation (@NotBlank, @Email, @Pattern cho phone và custom regex validation cho citizenId đảm bảo đủ 12 chữ số).

3. Bonus Task: Sinh sơ đồ Mermaid mô tả luồng đi của dữ liệu từ Client -> Controller -> Service -> Database và ngược lại.

Hãy viết code thật sạch (Clean Code), mạch lạc và sẵn sàng thực thi.