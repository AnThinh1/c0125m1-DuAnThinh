package contactmanager.model;

public class Contact {
    private String phoneNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dob;
    private String email;

    public Contact(String phoneNumber, String group, String name, String gender, String address, String dob, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.email = email;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SĐT: " + phoneNumber + " | Nhóm: " + group + " | Họ tên: " + name + " | Giới tính: " + gender +
                " | Địa chỉ: " + address + " | Ngày sinh: " + dob + " | Email: " + email;
    }
}
