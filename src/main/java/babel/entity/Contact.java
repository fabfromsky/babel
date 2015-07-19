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
		
		public Contact(int contactId, User user, User contact) {
			super();
			this.contactId = contactId;
			this.user = user;
			this.contact = contact;
		}

		@Id
		@JsonIgnore
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected int contactId;
		
		@ManyToOne
		@JoinColumn(name = "user")
		@JsonBackReference(value = "contact")
		protected User user;
		

		@ManyToOne
		@JoinColumn(name = "contact")
		@JsonBackReference(value = "manageContact")
		protected User contact;

		public int getContactId() {
			return contactId;
		}

		public void setContactId(int contactId) {
			this.contactId = contactId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public User getContact() {
			return contact;
		}

		public void setContact(User contact) {
			this.contact = contact;
		}	
		
		public String getUserName(){
			return user.getUsername();
		}
		
		public String getContactName(){
			return contact.getUsername();
		}
		
}
