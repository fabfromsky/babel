package babel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Babel_message")
@JsonInclude(Include.NON_NULL)
public class Message {

		public Message() {};
		
		public Message(int messageId, User sender, User receiver,
				String title, String content, String date) {
			super();
			this.messageId = messageId;
			this.sender = sender;
			this.receiver = receiver;
			this.title = title;
			this.content = content;
			this.date = date;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected int messageId;
		
		@ManyToOne
		@JoinColumn(name = "sender")
		@JsonBackReference(value = "sender")
		protected User sender;

		@ManyToOne
		@JoinColumn(name = "receiver")
		@JsonBackReference(value = "receiver")
		protected User receiver;
		
		protected String title;
		
		protected String content;
		
		protected String date;

		public int getMessageId() {
			return messageId;
		}

		public void setMessageId(int messageId) {
			this.messageId = messageId;
		}

		public User getSender() {
			return sender;
		}

		public void setSender(User sender) {
			this.sender = sender;
		}

		public User getReceiver() {
			return receiver;
		}

		public void setReceiver(User receiver) {
			this.receiver = receiver;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
		
		public String getSenderName() {
			return sender.getUsername();
		}
		
		public String getReceiverName() {
			return receiver.getUsername();
		}
			
}
