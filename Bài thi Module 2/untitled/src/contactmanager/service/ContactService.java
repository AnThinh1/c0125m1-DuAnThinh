package contactmanager.service;

import contactmanager.model.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    void addContact(Contact contact);
    boolean updateContact(String phoneNumber, Contact newContact);
    boolean deleteContact(String phoneNumber);
    List<Contact> searchContacts(String keyword);
}