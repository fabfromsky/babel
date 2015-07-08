package babel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "babel_contact")
public class Contact {

		public Contact(){};
		
		public Contact(int contactId, String user, String contact) {
			super();
			this.contactId = contactId;
			this.user = user;
			this.contact = contact;
		}

		@Id
		@JsonIgnore
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected int contactId;
		
		protected String user;
		
		protected String contact;

		public int getContactId() {
			return contactId;
		}

		public void setContactId(int contactId) {
			this.contactId = contactId;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}	
		
}
