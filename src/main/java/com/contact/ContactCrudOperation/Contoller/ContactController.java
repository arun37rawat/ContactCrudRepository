package com.contact.ContactCrudOperation.Contoller;

import com.contact.ContactCrudOperation.Entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @PostMapping("/api/contact")
    public Contact createContact(@RequestBody Contact contact){
        Contact savedContact=contactService.save(contact);
        return savedContact;
    }
    @GetMapping("/api/allcontact")
    public List<Contact> getallContacts(){
       return contactService.getAllContact();
    }
    @GetMapping("/api/contact/{id}")
     public Contact getContactById(@PathVariable Integer id){
        return contactService.getContactById(id).get();
    }
    @DeleteMapping("/api/contact/{id}")
      public String deleteContactById(@PathVariable Integer id){
        return contactService.deleteContactById(id);

            }
    @PutMapping("/api/contact/{id}")
        public Contact updateContact(@RequestBody Contact contact,@PathVariable Integer id){
            return contactService.updateContact(id,contact);

        }
    }

