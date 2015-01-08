package Parkir;
import java.util.*;
import java.io.*;
import Parkir.DB_Member;
import java.text.SimpleDateFormat;

public class DB_Paris {



		private int idparkir;
		private String username ;
		private String noplat;
		private String wkt_masuk;
		private String wkt_keluar;
                private String status;
		
		
		
	public DB_Paris (int idparkir,String username, String noplat, String wkt_masuk, String wkt_keluar, String status){
		this.idparkir = idparkir;
		this.username = username;
		this.noplat = noplat;
		this.wkt_masuk = wkt_masuk;
		this.wkt_keluar = wkt_keluar;
                this.status = status;
		
	}
	
        
        public String getUsername(){
            return username;
        }
        
       public  String getStatus(){
           return status;
       }
       
       public void setStatus(String status){
           this.status = status;
       }
        
	public static Vector<DB_Paris> DB = new Vector<DB_Paris>();
        
        //Methode tambah parkir non member
	public static void tmbhDataN(String nopol){
		int idk;
                idk=DB.size()+1;
                  for(int i=0;i<DB.size();i++){
                    if(idk==DB.elementAt(i).getIdParkir()){
                    idk++;
                    }
                  }
                
                int idx=0;
                boolean cek = false;
                
                for(int i=0;i<DB.size();i++){
                if((nopol.equalsIgnoreCase(DB.elementAt(i).getNoPlat()) && (DB.elementAt(i).getStatus().equalsIgnoreCase("waiting")))){
                    idx = i;
                    cek = true;
                }
                }
                
                if (cek != false){
                      System.out.println("No. Plat yang Anda masukkan tidak valid!");
                }
                
                else {
                    DB.add(new DB_Paris(idk,"regular",nopol,new Date().toString(),new Date().toString(),"waiting"));
                    System.out.println();
                    System.out.println("No. Karcis\t:" + idk);
                    System.out.println("No. Plat\t:" + nopol);
                    System.out.println("Open Gate!");
                }
                
               cek = false;
	}
        
        //Print keluaran Parkir non member (regular)
        
        
        //methode set jam keluar non member (reguler);
        public static void setKeluarN(String nopol){
            
            boolean cek = false;
            
            for(int i =0; i<DB.size();i++){
            if(!nopol.equalsIgnoreCase(DB.elementAt(i).getNoPlat())) {   
            cek = true;
            }
            }
           
            if(cek=false){
            int idx=0;
            for(int i =0; i<DB.size();i++){
            if((nopol.equalsIgnoreCase(DB.elementAt(i).getNoPlat())) && (DB.elementAt(i).getStatus().equalsIgnoreCase("waiting"))){
            idx = i;
            }
        }
            DB.elementAt(idx).setStatus("Succes");
        }
        }
            
        //methode set jam keluar member
        public static void setKeluaraM(String username,String nopol){
            boolean cek = true;
            int idx =0;
            for(int i =0;i<DB.size();i++){
                if ((username.equalsIgnoreCase(DB.elementAt(i).getUsername())) && (nopol.equalsIgnoreCase(DB.elementAt(i).getNoPlat()))){
                    idx =i;
                    cek =false;
                }
            }
            if(cek=false){
            DB.elementAt(idx).setStatus("Succes");
            }
            else{
            System.out.println("data yang Anda masukkan tidak Valid!");
            }
        }
        
        //methode tambah parkir member
        public static void tmbhDataM(String username, String pin){
                int idk;
                idk=DB.size()+1;
                  for(int i=0;i<DB.size();i++){
                    if(idk==DB.elementAt(i).getIdParkir()){
                    idk++;
                    }
                  }
                
                int idx=0;
                boolean cek = false;
                for(int i=0;i<DB_Member.DB_Client.size();i++){
                if((!username.equalsIgnoreCase(DB_Member.DB_Client.elementAt(i).getUsername())) && 
                        (!pin.equalsIgnoreCase(DB_Member.DB_Client.elementAt(i).getPin())) && (idx == i)){
                    idx=i;
                    cek = true;
                  
                }
                }

                
                for(int i=0;i<DB.size();i++){
                        if ((username.equalsIgnoreCase(DB.elementAt(i).getUsername())) && (DB.elementAt(i).getStatus().equalsIgnoreCase("Waiting"))){
                         System.out.println("Data yang Anda masukkan tidak valid!");
                         cek=true;
                        }
                    }
                
                int x=0;
                if(cek != false){
                      System.out.println("Data yang Anda masukkan tidak valid!");
                }
                
                
                else {
                    
                    
                    for(int i=0;i<DB_Member.DB_Client.size();i++){
                    if((username.equalsIgnoreCase(DB_Member.DB_Client.elementAt(i).getUsername())) && 
                        (pin.equalsIgnoreCase(DB_Member.DB_Client.elementAt(i).getPin()))){
                    x=i;
                    }
                    }
                    DB.add(new DB_Paris(idk,username,DB_Member.DB_Client.elementAt(x).getNopol(),new Date().toString(),new Date().toString(),"waiting"));
                    System.out.println();
                    System.out.println("No. Karcis\t:" + idk);
                    System.out.println("No. Plat\t:" + DB_Member.DB_Client.elementAt(x).getNopol());
                    System.out.println("Open Gate!");
                }
                
                cek = false;
        }
        
        
	
	
	//Methode Getter
	public int getIdParkir(){
		return idparkir;
	}
	
	public String getNoPlat(){
		return noplat;
	}
	
	public String getMasuk(){
		return wkt_masuk;
	}
	
	public String getKeluar(){
		return wkt_keluar;
	}
	


	//Methode Setter
	public void setIdParkir(int id){
		idparkir = id ;
	}
	
	public void setNoPlat(String no){
		noplat = no;
	}
	
	public void setMasuk(String masuk){
		wkt_masuk = masuk;
	}
	
	public void setKeluar(String keluar){
		wkt_keluar = keluar;
	}
}