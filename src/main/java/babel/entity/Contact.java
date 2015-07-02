package babel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "babel_contact")
public class Contact {

		public Contact(){};
		
		public Contact(int contactId, User user1, User contact, String contactName) {
			super();
			this.contactId = contactId;
			this.user1 = user1;
			this.contact = contact;
			this.contactName = contactName;
		}

		@Id
		@JsonIgnore
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected int contactId;
		
		@ManyToOne
		@JoinColumn(name = "contact")
		@JsonBackReference
		protected User user1;
		
		@ManyToOne
		@JoinColumn(name = "manageContact")
		@JsonBackReference
		protected User contact;
		
		@Transient
		protected String contactName;

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

		public User getContact() {
			return contact;
		}

		public void setContact(User contact) {
			this.contact = contact;
		}

		public String getContactName() {
			return this.getContact().username;
		}

		public void setContactName(String contactName) {
			this.contactName = contactName;
		}		
		
}
