package contactmanager.service;

import contactmanager.model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    private List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public boolean updateContact(String phoneNumber, Contact newContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                contacts.set(i, newContact);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteContact(String phoneNumber) {
        return contacts.removeIf(c -> c.getPhoneNumber().equals(phoneNumber));
    }

    @Override
    public List<Contact> searchContacts(String keyword) {
        return contacts.stream()
                .filter(c -> c.getPhoneNumber().contains(keyword) || c.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}