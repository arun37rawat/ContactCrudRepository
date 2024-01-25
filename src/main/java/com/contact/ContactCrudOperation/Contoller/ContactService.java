package com.contact.ContactCrudOperation.Contoller;

import com.contact.ContactCrudOperation.Entity.Contact;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;
    public Contact save(Contact contact) {
         Contact savedContact=contactRepository.save(contact);
        return savedContact;
    }

    public List<Contact> getAllContact() {
        List<Contact> contactList=contactRepository.findAll();
        return contactList;
    }

    public Optional<Contact> getContactById(Integer id) {
        return contactRepository.findById(id);
    }

    public String deleteContactById(Integer id) {
        contactRepository.deleteById(id);
        return "Successfully Deleted";
    }

    public Contact updateContact(Integer id,Contact contact) {
        Optional<Contact> ifExistContact=contactRepository.findById(id);
        if(ifExistContact.isPresent()){
            Contact presentContact=ifExistContact.get();
            presentContact.setCity(contact.getCity());
            presentContact.setName(contact.getName());
            presentContact.setNumber(contact.getNumber());
            contactRepository.save(presentContact);
            return presentContact;
        }
       return null;
    }
}
