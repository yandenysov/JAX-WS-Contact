package org.example.server.repository;

import org.example.server.entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    public List<Contact> fetchData() {
        List<Contact> list = new ArrayList<>();
        list.add(new Contact(1, "Bob", "357 935-1714"));
        list.add(new Contact(2, "Alice", "821 777-0481"));
        list.add(new Contact(3, "Bart", "385 128-1339"));
        return list;
    }
}
