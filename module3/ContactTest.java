import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

  private Contact adaContact;
  private Contact graceContact;
  private Contact alanContact;

  @BeforeEach
  void setUp() {
    adaContact = new Contact("Ada Lovelace", "+1 617 555 0101");
    graceContact = new Contact("Grace Hopper", "555-0000");
    alanContact = new Contact("Alan Turing", "555-0001");
  }

  @Test 
  void constructor_setsNameCorrectly() { 
    assertEquals("Ada Lovelace", adaContact.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", adaContact.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    assertEquals("Grace Hopper", graceContact.getName());
  } 
 
  @Test
  void toString_containsName() { 
    assertTrue(alanContact.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    assertTrue(alanContact.toString().contains("555-0001"));
  }

  @Test
  void contactsWithSameName_areIndependentObjects() {
    Contact contact1 = new Contact("Ada Lovelace", "555-1111");
    Contact contact2 = new Contact("Ada Lovelace", "555-2222");

    assertNotSame(contact1, contact2);
    assertEquals("555-1111", contact1.getPhone());
    assertEquals("555-2222", contact2.getPhone());
  }
} 