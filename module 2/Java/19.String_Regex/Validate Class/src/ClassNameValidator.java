public class ClassNameValidator {

    public static boolean isValidClassName(String className) {
        // Regex giải thích:
        // ^         : Bắt đầu chuỗi
        // [CAP]     : Ký tự đầu là C hoặc A hoặc P
        // \\d{4}    : Theo sau là đúng 4 ký tự số
        // [GHIK]    : Kết thúc bằng G, H, I hoặc K
        // $         : Kết thúc chuỗi
        String regex = "^[CAP]\\d{4}[GHIK]$";

        return className.matches(regex);
    }

    public static void main(String[] args) {
        // Test thử
        String[] testCases = {"C0223G", "A0323K", "M0318G", "P0323A"};

        for (String className : testCases) {
            if (isValidClassName(className)) {
                System.out.println(className + " là tên lớp hợp lệ.");
            } else {
                System.out.println(className + " là tên lớp không hợp lệ.");
            }
        }
    }
}
