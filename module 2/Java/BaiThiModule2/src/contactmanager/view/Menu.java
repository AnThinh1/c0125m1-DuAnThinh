package contactmanager.view;

import contactmanager.model.Contact;
import contactmanager.service.ContactService;
import contactmanager.service.ContactServiceImpl;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final ContactService service = new ContactServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        while (true) {
            System.out.println("\n---- QUẢN LÝ DANH BẠ ----");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");

            String input = scanner.nextLine();
            if (input.matches("[1-8]")) {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1 -> showContacts();
                    case 2 -> addContact();
                    case 3 -> updateContact();
                    case 4 -> deleteContact();
                    case 5 -> searchContact();
                    case 6 -> System.out.println("(Tính năng Đọc file chưa cài đặt)");
                    case 7 -> System.out.println("(Tính năng Ghi file chưa cài đặt)");
                    case 8 -> {
                        System.out.println("Thoát chương trình.");
                        return;
                    }
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 1 đến 8.");
            }
        }
    }

    private void showContacts() {
        List<Contact> list = service.getAllContacts();
        if (list.isEmpty()) {
            System.out.println("Danh bạ trống.");
            return;
        }
        int count = 0;
        for (Contact c : list) {
            System.out.println(c);
            count++;
            if (count % 5 == 0) {
                System.out.print("Nhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        }
    }

    private void addContact() {
        Contact contact = inputContact();
        service.addContact(contact);
        System.out.println("Đã thêm danh bạ thành công.");
    }

    private void updateContact() {
        while (true) {
            System.out.print("Nhập số điện thoại cần sửa (Enter để thoát): ");
            String phone = scanner.nextLine();
            if (phone.isEmpty()) {
                System.out.println("Quay về Menu.");
                return;
            }
            boolean found = service.getAllContacts().stream().anyMatch(c -> c.getPhoneNumber().equals(phone));
            if (found) {
                Contact contact = inputContact();
                if (service.updateContact(phone, contact)) {
                    System.out.println("Cập nhật thành công.");
                }
                return;
            } else {
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            }
        }
    }

    private void deleteContact() {
        while (true) {
            System.out.print("Nhập số điện thoại cần xoá (Enter để thoát): ");
            String phone = scanner.nextLine();
            if (phone.isEmpty()) {
                System.out.println("Quay về Menu.");
                return;
            }
            boolean found = service.getAllContacts().stream().anyMatch(c -> c.getPhoneNumber().equals(phone));
            if (found) {
                System.out.print("Bạn có chắc muốn xoá? (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    if (service.deleteContact(phone)) {
                        System.out.println("Xoá thành công.");
                    }
                }
                return;
            } else {
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            }
        }
    }

    private void searchContact() {
        System.out.print("Nhập từ khoá tìm kiếm (số điện thoại hoặc họ tên): ");
        String keyword = scanner.nextLine();
        List<Contact> list = service.searchContacts(keyword);
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy kết quả.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private Contact inputContact() {
        String phone;
        while (true) {
            System.out.print("Số điện thoại (10 số): ");
            phone = scanner.nextLine();
            if (phone.matches("\\d{10}")) break;
            System.out.println("Số điện thoại không hợp lệ. Phải đúng 10 số.");
        }

        String group;
        while (true) {
            System.out.print("Nhóm (số nguyên từ 0 đến 9): ");
            group = scanner.nextLine();
            if (group.matches("\\d") && Integer.parseInt(group) >= 0) break;
            System.out.println("Nhóm không hợp lệ. Phải là số nguyên từ 0 đến 9.");
        }

        String name;
        while (true) {
            System.out.print("Họ tên (Viết hoa chữ cái đầu): ");
            name = scanner.nextLine();
            if (name.matches("[\\p{L}]+(\\s[\\p{L}]+)*")) break;
            System.out.println("Họ tên không hợp lệ. Viết hoa chữ cái đầu mỗi từ.");
        }

        String gender;
        while (true) {
            System.out.print("Giới tính (Nam hoặc Nữ): ");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("Nam") || gender.equalsIgnoreCase("Nữ")) break;
            System.out.println("Giới tính chỉ được nhập Nam hoặc Nữ.");
        }

        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Ngày sinh: ");
        String dob = scanner.nextLine();

        String email;
        while (true) {
            System.out.print("Email (@gmail.com): ");
            email = scanner.nextLine();
            if (email.matches("[a-z0-9]+@gmail\\.com")) break;
            System.out.println("Email không hợp lệ. Phải có dạng tên@gmail.com, chỉ chứa chữ thường và số.");
        }

        return new Contact(phone, group, name, gender, address, dob, email);
    }
}
