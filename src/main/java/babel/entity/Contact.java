package babel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "babel_contact")
public class Contact {

		public Contact(){};
		
		public Contact(int contactId, User user1, String contact) {
			super();
			this.contactId = contactId;
			this.user1 = user1;
			this.contact = contact;
		}

		@Id
		@JsonIgnore
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected int contactId;
		
		@ManyToOne
		@JoinColumn(name = "username")
		@JsonBackReference
		protected User user1;
		
		protected String contact;

		public int getContactId() {
			return contactId;
		}

		public void setContactId(int contactId) {
			this.contactId = contactId;
		}

		public User getUser1() {
			return user1;
		}

		public void setUser1(User user1) {
			this.user1 = user1;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}		
		
}
