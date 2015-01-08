package Parkir;

import java.io.*;
import java.util.*;
public class DB_Member {

	int id;
	String username;
	String pin;
	String nopol;
	
	public DB_Member(int id, String username, String pin, String nopol) {
		this.id = id;
		this.username = username;
		this.pin = pin;
                this.nopol = nopol;
	}

        
        
	public static Vector<DB_Member> DB_Client = new Vector<DB_Member>();
	
	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public int getId() {
		return id;
	}

        public String getNopol(){
                return nopol;
        }
        
        public void setNopol(String nopol){
            this.nopol = nopol;
        }
	public String getUsername() {
		return username;
	}
	
}
