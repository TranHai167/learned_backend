- Project có sử dụng khai triển microservice đơn giản.
- Module library-service sẽ lấy thông tin các quyển sách từ DB MongoDB để hiện thị lên web là các quyển sách có sẵn để user có thể mượn, xóa.
- Module user-service liên kết với entity user trong csdl mysql, mỗi user sẽ có một foreinkey -> table lưu dữ liệu account, sử dụng spring security để phân quyền và đăng nhập để bt đc đâu là client, admin.
- Khi 2 module đã hoạt động tốt thì cho chạy service-registry (eureka server) để quản lý các api-gateway, library-service và user-service (các client).

