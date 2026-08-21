import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        Contact contact1 = new Contact("Ada Lovelace", "+1 617 555 0101");
        Contact contact2 = new Contact("Grace Hopper", "+1 202 555 0147");
        Contact contact3 = new Contact("Alan Turing", "+44 20 7946 0182");
        Contact contact4 = new Contact("Katherine Johnson", "+1 757 555 0128");
        Contact contact5 = new Contact("Tim Berners-Lee", "+44 20 7946 0235");
        Contact contact6 = new Contact("Margaret Hamilton", "+1 617 555 0194");

        contacts.put(contact1.getName(), contact1);
        contacts.put(contact2.getName(), contact2);
        contacts.put(contact3.getName(), contact3);
        contacts.put(contact4.getName(), contact4);
        contacts.put(contact5.getName(), contact5);
        contacts.put(contact6.getName(), contact6);
 
        // Step 5: look up a contact 
        System.out.println("=== Contact Lookup ===");
        Contact contact = contacts.get("Ada Lovelace");
        if (contact == null){
            System.out.println("Contact not found.");
        } else {
            System.out.println(contact);
        }

        Contact missingContact = contacts.get("John Smith");
        if (missingContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missingContact);
        }
        
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());  
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  
        
        System.out.println("=== All Contacts ===");
        for(Contact currentContact : sorted){
            System.out.println(currentContact);
        }


    } 
}