package babel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "Babel_message")
@JsonInclude(Include.NON_NULL)
public class Message {

		public Message() {};
		
		public Message(int messageId, String sender, String receiver,
				String title, String content) {
			super();
			this.messageId = messageId;
			this.sender = sender;
			this.receiver = receiver;
			this.title = title;
			this.content = content;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected int messageId;
		
		protected String sender;
		
		protected String receiver;
		
		protected String title;
		
		protected String content;

		public int getMessageId() {
			return messageId;
		}

		public void setMessageId(int messageId) {
			this.messageId = messageId;
		}

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public String getReceiver() {
			return receiver;
		}

		public void setReceiver(String receiver) {
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
		
		
}
