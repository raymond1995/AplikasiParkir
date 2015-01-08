package Parkir;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Date;
import Parkir.DB_Paris;
import Parkir.DB_Member;

public class ServerParis 
{
	
	private static ServerSocket serverSocket;
	private static final int PORT = 24;
	public static void main(String[] args)
			throws IOException
			{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		//Deklarasi Variabel
		int pil = 0;
		int pil2 = 0;
		
		
		
		System.out.println("Selamat Datang di Dashboard Admin PARIS");
		System.out.println("Time Server : " + new Date().toString());
		String username = "admin";
		String password = "admin";
		
		System.out.print("Masukkan Username : ");
		String cekuser = in.readLine();
		System.out.print("Masukkan Password : ");
		String cekpass = in.readLine();
		
		
		if((cekuser.equals(username) && (cekpass.equals(password)))){
			try
			
			{
				serverSocket = new ServerSocket(PORT);
				System.out.println();
				System.out.println();
				System.out.println("Open Connection succes : " + PORT);
			}
			catch (IOException ioEx)
			{
				System.out.println("\nTidak Dapat Membuka Port!");
				System.exit(1);
			}
			
		}
			do
			{
                            
                       
        
        
	do{
        System.out.println();
        System.out.println();
	System.out.println("Dasboard Admin PARIS");
	System.out.println("1. Data Parkir Masuk");
	System.out.println("2. Data Parkir Keluar");
	System.out.println("3. Manage Member");
	System.out.println("4. Trace PARIS");
        System.out.println("5. Keluar");
	System.out.print("Masukkan pilihan Anda : ");
	pil = Integer.parseInt(in.readLine());
	switch(pil){
	
	case 1 :
		System.out.println();
		System.out.println();
		System.out.println("ID\tUsername\tNo. Plat\tMasuk");
                for(int i = 0; i<DB_Paris.DB.size();i++){
		System.out.println(DB_Paris.DB.elementAt(i).getIdParkir()+"\t"+DB_Paris.DB.elementAt(i).getUsername()
				+"\t\t"+DB_Paris.DB.elementAt(i).getNoPlat()+"\t\t"+DB_Paris.DB.elementAt(i).getMasuk());
		}
	
		break;
	case 2 :
		System.out.println();
		System.out.println();
		System.out.println("ID\tUsername\tNo. Plat\tMasuk\tKeluar");
		
		for(int i = 0; i<DB_Paris.DB.size();i++){
			
		System.out.println(DB_Paris.DB.elementAt(i).getIdParkir()+"\t"+DB_Paris.DB.elementAt(i).getUsername()
				+"\t"+DB_Paris.DB.elementAt(i).getNoPlat()+"\t"+DB_Paris.DB.elementAt(i).getMasuk()+"\t"+DB_Paris.DB.elementAt(i).getKeluar()
				);
		}
	
		break;
	case 3 :
		
		do{
		System.out.println("Managemen Member");
		System.out.println("1. Lihat Member");
		System.out.println("2. Tambah Member");
		System.out.println("3. Hapus Member");
                System.out.println("4. Ubah No. Plat");
		System.out.println("5. Kembali");
		System.out.print("Masukkan pilihan : ");
		pil2 = Integer.parseInt(in.readLine());
		
		switch(pil2){
		case 1 :
			System.out.println();
			System.out.println("ID\tUsername\tNo. Pol");	
			for (int i = 0; i < DB_Member.DB_Client.size();i++){
			System.out.println(DB_Member.DB_Client.elementAt(i).getId()+"\t"+DB_Member.DB_Client.elementAt(i).getUsername()+"\t\t"+
                                DB_Member.DB_Client.elementAt(i).getNopol());
			}
			System.out.println();
			break;
		case 2 :
                    int idk = DB_Member.DB_Client.size()+1;
                     for(int i=0;i<DB_Member.DB_Client.size();i++){
                    if(idk==DB_Member.DB_Client.elementAt(i).getId()){
                    idk++;
                    }
                    }
                    System.out.println("ID Member : " +idk);
                    System.out.print("Masukkan Username : ");
                    String username1 = in.readLine();
                    System.out.print("Masukkan Pin : ");
                    String pin = in.readLine();
                    System.out.print("Masukkan No. Pol : ");
                    String nopol = in.readLine();
                    
                    // cek validasi member
                    
                    boolean idx=false;
                    
                    for(int i =0; i<DB_Member.DB_Client.size();i++){
                        if(username.equalsIgnoreCase(DB_Member.DB_Client.elementAt(i).getUsername())){
                        } else {
                            idx = true;
                    }
                    }
                    
                    
                    
                    if(idx!=false){
                        System.out.println("Username yang Anda masukkan sudah terdaftar");
                    }
                    else{
                        DB_Member.DB_Client.add(new DB_Member(idk,username1,pin,nopol));
                    }
			break;
		case 3 :
                    System.out.print("Masukkan ID Member : ");
                    int idc = Integer.parseInt(in.readLine());
                    System.out.print("Masukkan username : ");
                    String usernamex = in.readLine();
                    
                    int tg=0;
                    boolean tgx=false;
                    
                    for(int i =0; i<DB_Member.DB_Client.size();i++){
                        if((idc == DB_Member.DB_Client.elementAt(i).getId() ) && (usernamex.equalsIgnoreCase(DB_Member.DB_Client.elementAt(i).getUsername())))
                           tg=i;
                           tgx = true;
                    }
                    System.out.println(tgx);
                    if(tgx!=true){
                            System.out.println("ID atau Username yang Anda masukkan tidak valid!");
                            }
                    else{
                        DB_Member.DB_Client.removeElementAt(tg);
                        System.out.println("Data Berhasil dihapus!");
                    }
                    
                    tgx = false;
			break;
                case 4 :
                    
                    System.out.print("Masukkan ID Member : ");
                    int idcz = Integer.parseInt(in.readLine());
                    System.out.print("Masukkan username : ");
                    String usernamexz = in.readLine();
                    int tgz=0;
                    String nopolz;
                    boolean tgxz=false;
                    for(int i =0; i<DB_Member.DB_Client.size();i++){
                        if((idcz == DB_Member.DB_Client.elementAt(i).getId() ) && (usernamexz.equalsIgnoreCase(DB_Member.DB_Client.elementAt(i).getUsername())))
                            tgz=i;
                        
                        tgxz = true;
                    }
                    if(tgxz!=true){
                            System.out.println("ID atau Username yang Anda masukkan tidak valid!");
                            }
                    else{
                        System.out.print("Masukkan No. pol : ");
                        nopolz = in.readLine();
                        DB_Member.DB_Client.elementAt(tgz).setNopol(nopolz);
                        System.out.println("No. Pol berhasil dirubah!");
                    }
                    break;
		}
		}while(pil2<5);
	break;
        case 4 :
            String exit;
            System.out.println("Trace PARIS");
            do{
            exit = in.readLine();
            }while(exit.equalsIgnoreCase("exit"));
            break;
	}}while(pil<5);
        
        
        
                        System.out.println("Server Siap...");
			Socket client = serverSocket.accept();
			System.out.println("\nClient Baru ..masuk..\n");
			System.out.println("Host Name : " + client.getInetAddress().getHostName());
			System.out.println("IP : " + client.getInetAddress());
			//Create a thread to handle communication with
			//this client and pass the constructor for this
			//thread a reference to the relevant socket..
			ClientHandler handler =
					new ClientHandler(client);
			handler.start();//As usual, method calls run .
      
   
        String open = in.readLine();
	
	
		}while (true);
			}
}
class ClientHandler extends Thread
{
	private Socket client;
	private Scanner input;
	private PrintWriter output;
	public static int id =0;
	public ClientHandler(Socket socket)
	{
		//Set up reference to associated socket...
		client = socket;
		try
		{
			input = new Scanner(client.getInputStream());
			output = new PrintWriter(
					client.getOutputStream(),true);
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
	}
	
	

	public void run()
	{
		String received,username,pin,nopol;
		int menu, pil,valid=0;
             
		do
                {

                    menu = input.nextInt();
                  
                    System.out.println("menu ke : " +menu );
                    
                    
			if (menu == 1){
				received = input.next();
				DB_Paris.tmbhDataN(received);
                         
			}
                        else if (menu == 2){
                                username = input.next();
                                System.out.println("inputan :" +username);
                                pin = input.next();
                                System.out.println("inputan :" + pin);
                                DB_Paris.tmbhDataM(username,pin);
                                
                        }
                        
                        else if(menu ==3){
                        received = input.next();
                        DB_Paris.setKeluarN(received);
                        }
                        else if(menu==4){
                            
                            username = input.next();
                            nopol = input.next();
                            DB_Paris.setKeluaraM(username, nopol);
                            
                        }
			
			//ulangi sampai QUIT
		}while (menu<5);
		try
		{
			if (client!=null)
			{
				System.out.println(
						"Menutup koneksi...sukses..");
				client.close();
			}
		}
		catch(IOException ioEx)
		{
			System.out.println("Gagal menutup koneksi!");
		}
	}
	
	
	}
