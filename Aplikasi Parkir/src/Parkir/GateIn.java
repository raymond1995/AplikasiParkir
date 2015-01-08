package parkir;

import Parkir.DB_Member;
import Parkir.DB_Paris;
import java.io.*;
import java.net.*;
import java.util.*;
public class GateIn
{
	private static InetAddress host;
	private static final int PORT = 24;
	
	//Koneksi Server
	private static void sendMessages()
	{
		Socket socket = null;

		try
		{
			socket = new Socket("ROOT",PORT);
			Scanner networkInput = new Scanner(socket.getInputStream());
			PrintWriter networkOutput = new PrintWriter(socket.getOutputStream(),true);
			Scanner userEntry = new Scanner(System.in);
			String message, response;
			int pil=0;
			
			do
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
				String nopol;
				String ID;
				String pin;
				int menu=0;
                                int valid=0;
			
				System.out.println("Selamat Datang di PARIS (Parking Information System)");
				System.out.println("1. Parkir Regular");
				System.out.println("2. Parkir Member");
				System.out.print("Pilihan :");
				pil = userEntry.nextInt();
				
				switch(pil){
				
				case 1 :
					menu = 1;
					networkOutput.println(menu);
					System.out.print("Masukkan nomor polisi : ");
					nopol = in.readLine();
					networkOutput.println(nopol);
					System.out.println();
                                        menu=0;
                                        networkOutput.println(menu);
                                        //Karcis Non Member
                                        
                                        
                                        //End of karcis non member
					break;
                                    
					
				case 2 :
                                        menu = 2;
                                        networkOutput.println(menu);
					System.out.print("Masukkan Username : ");
					ID = in.readLine();
                                        networkOutput.println(ID);
                                        System.out.print("Masukkan Password : ");
                                        pin = in.readLine();
                                        networkOutput.println(pin);
					
					System.out.println();
                                        
                                        //Keluar Karcis
                                        int hasil;
                                        
                                        for(int x=0;x<DB_Member.DB_Client.size();x++){
                                            if((ID.equalsIgnoreCase(DB_Member.DB_Client.elementAt(x).getUsername())) ){
                                                
                                        //cek didalam DB_Paris
                                        for(int i =0; i<DB_Paris.DB.size();i++){
                                        if((ID.equalsIgnoreCase(DB_Paris.DB.elementAt(i).getUsername())))
                                        {
                                            hasil=i;
                                        }
                                        }
                                        //End of check
                                            
                                            }
                                        }
                                        System.out.println();
                                        System.out.println("No. Karis"  );
                                       //End of keluar karcis
                                        
                                        
                                        
                                        menu=0;
                                        networkOutput.println(menu);
					break;
				
				}
				
			}while (pil<3);
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();
		}
		finally
		{
			try
			{
				System.out.println("\nPenutupan Koneksi...");
				socket.close();
			}
			catch(IOException ioEx)
			{
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
	}

        
	// End of Koneksi Server
	public static void main(String[] args) throws IOException
	{

		
		sendMessages();
		
	}

}