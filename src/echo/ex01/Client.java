package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
	
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("=============================");
		
		System.out.println("[서버연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.1.8", 10001));
		System.out.println("[서버에 연결되었습니다.]");
		
		//메세지 보내기 영역
		OutputStream os = socket.getOutputStream();
		Writer osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//메세지 받기 영역
		InputStream is = socket.getInputStream();
		Reader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//스캔영역
	    Scanner sc = new Scanner(System.in);
	    String str = sc.next();

	    while(true) {
	    	str = sc.nextLine();
	    			
	    	if("/q".equals(str)) {
	    	System.out.println("[접속종료되었습니다.]");
	    	break; }
	   	
	    	bw.write(str);
		    bw.newLine();
		    bw.flush();
		 
	    }
	  
		
	    
		
	    
		/*String str = "테스트입니다.";*/
	
		String reMsg = br.readLine();
		System.out.println("server:["+reMsg+"]");
		
		bw.close();
		br.close();
		
		System.out.println("==============================");
		System.out.println("<클라이언트 종료>");
		
		
		socket.close();
	}

}
