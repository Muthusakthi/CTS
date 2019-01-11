package bazzifer.jobs.com.cts.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Contacts{

	@SerializedName("contacts")
	private List<ContactsItem> contacts;

	public List<ContactsItem> getContacts() {
		return contacts;    }

	public void setContacts(List<ContactsItem> contacts) {
		this.contacts = contacts;    }

	@Override
 	public String toString(){
		return 
			"Contacts{" + 
			"contacts = '" + contacts + '\'' + 
			"}";
		}


}