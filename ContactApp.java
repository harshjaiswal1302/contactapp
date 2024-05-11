package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchContact(String keyword) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(keyword) || contact.getPhoneNumber().equalsIgnoreCase(keyword)) {
                System.out.println("Contact found: " + contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

public class AddressBookApp {
    private AddressBook addressBook;
    private Scanner scanner;

    public AddressBookApp() {
        this.addressBook = new AddressBook();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    listContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter contact email: ");
        String email = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber, email);
        addressBook.addContact(contact);
    }

    private void listContacts() {
        addressBook.listContacts();
    }

    private void searchContact() {
        System.out.print("Enter name or phone number to search: ");
        String keyword = scanner.nextLine();
        addressBook.searchContact(keyword);
    }

    private void deleteContact() {
        System.out.print("Enter name of contact to delete: ");
        String name = scanner.nextLine();
        addressBook.deleteContact(name);
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();
        app.start();
    }
}
