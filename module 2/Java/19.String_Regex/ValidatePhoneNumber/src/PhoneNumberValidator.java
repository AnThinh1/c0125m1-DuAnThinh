public class PhoneNumberValidator {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Giải thích Regex:
        // ^            : Bắt đầu chuỗi
        // \\(\\d{2}\\) : Dấu mở ngoặc, 2 chữ số, dấu đóng ngoặc (vd: (84))
        // -            : Dấu gạch ngang
        // \\(0\\d{9}\\) : Dấu mở ngoặc, số 0, 9 chữ số, dấu đóng ngoặc
        // $            : Kết thúc chuỗi
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

        return phoneNumber.matches(regex);
    }

    public static void main(String[] args) {
        String[] testCases = {
                "(84)-(0978489648)",   // Hợp lệ
                "(a8)-(22222222)",     // Không hợp lệ
                "(84)-(22b22222)",     // Không hợp lệ
                "(84)-(9978489648)"    // Không hợp lệ (bắt đầu sau dấu - phải là 0)
        };

        for (String phone : testCases) {
            if (isValidPhoneNumber(phone)) {
                System.out.println(phone + " là số điện thoại hợp lệ.");
            } else {
                System.out.println(phone + " là số điện thoại không hợp lệ.");
            }
        }
    }
}
