public class UserSession {
    private static int onlineCount = 0; // lưu tổng số người online

    public UserSession() {
        onlineCount++; // mỗi khi tạo 1 user => +1 người online
    }

    public void logout() {
        onlineCount--; // mỗi khi logout => -1 người online
    }

    public static int getOnlineCount() {
        return onlineCount; // trả về tổng số user đang online
    }
}
