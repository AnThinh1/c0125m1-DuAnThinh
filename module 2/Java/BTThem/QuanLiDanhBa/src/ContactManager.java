import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactManager {
    private HashMap<String, Contact> contacts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== Menu chính ===");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Sửa liên lạc");
            System.out.println("3. Xoá liên lạc");
            System.out.println("4. Tìm kiếm liên lạc");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    editContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    searchContact();
                    break;
                case "5":
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private void addContact() {
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        if (contacts.containsKey(phone)) {
            System.out.println("Số điện thoại đã tồn tại. Bạn có muốn ghi đè? (y/n)");
            String confirm = scanner.nextLine();
            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("Đã huỷ thao tác thêm liên lạc.");
                return;
            }
        }
        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        contacts.put(phone, new Contact(name, email));
        System.out.println("Liên lạc đã được thêm thành công!");
    }

    private void editContact() {
        System.out.print("Nhập số điện thoại cần sửa: ");
        String phone = scanner.nextLine();
        if (!contacts.containsKey(phone)) {
            System.out.println("Không tìm thấy liên lạc với số điện thoại này.");
            return;
        }
        Contact contact = contacts.get(phone);
        System.out.println("Thông tin hiện tại: " + contact);

        System.out.print("Nhập họ tên mới (bỏ trống nếu không muốn thay đổi): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            contact.setName(name);
        }

        System.out.print("Nhập email mới (bỏ trống nếu không muốn thay đổi): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            contact.setEmail(email);
        }

        System.out.println("Liên lạc đã được cập nhật.");
    }

    private void deleteContact() {
        System.out.print("Nhập số điện thoại cần xoá: ");
        String phone = scanner.nextLine();
        if (contacts.containsKey(phone)) {
            contacts.remove(phone);
            System.out.println("Đã xoá liên lạc thành công.");
        } else {
            System.out.println("Không tìm thấy liên lạc với số điện thoại này.");
        }
    }

    private void searchContact() {
        System.out.print("Nhập từ khoá tìm kiếm: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            String phone = entry.getKey();
            Contact contact = entry.getValue();

            if (contact.getName().toLowerCase().contains(keyword) || contact.getEmail().toLowerCase().contains(keyword)) {
                System.out.println(phone + " - " + contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy kết quả phù hợp.");
        }
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.run();
    }
}
