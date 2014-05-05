package testing;


import static org.junit.Assert.*;
import Client;
import NetException;
import Protocol;
import Response;
import Server;
import Task2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AssgTest {

	@Test
	public void test() {
		Server s = Task2.makeServer();
		Client c = Task2.makeClient();
		
		try {
			ArrayList<String> f = new ArrayList<String>();
			//f.add("127.0.0.1");
			
			s.start(1337, "hello", f);
			c.start("localhost", 1337);
			
			Response r = c.connect();
			System.out.println(r);
			
			r = c.sendPassword("hello");
			System.out.println(r);
			
			r = c.echoString("testing echo");
			System.out.println(r);
			
			//c.clientExit();
			//c.serverExit();
			c.echoString("hello");
			
		} catch (NetException e) {
			System.out.println(e.msg);
			fail();
		}
	}
	
	@Test
	public void test12() {
		String s = Protocol.formatFileData("hello.txt", "");
		String[] p = Protocol.readFileData(s);
		
		System.out.println("Original : " + s);
		System.out.println("Parts -->  name: " + p[0] + " -- data: " + p[1]);
	}
	
	/**
	@Test
	public void testEcho() {
		Server s = Task2.makeServer();
		Client c = Task2.makeClient();
		
		try {
			s.start(1234, "a", new ArrayList<String>());
			c.start("localhost", 1234);
			
			Response r;
			r = c.echoString("testing echo");
			System.out.println(r);

			assertTrue("The server should have sent back an echo", r instanceof StringContent);
		} catch (NetException e) {
			System.out.println(e.msg);
			fail();
		}
	}
	
	@Test
	public void testFileSend() {
		Server s = Task2.makeServer();
		Client c = Task2.makeClient();
		
		try {
			s.start(1234, "a", new ArrayList<String>());
			c.start("localhost", 3321);
			
			Response r;
			r = c.sendFile("Test.txt", "Hello");
			System.out.println(r);

			assertTrue("The server should have sent back an OK", r instanceof OK);
		} catch (NetException e) {
			System.out.println(e.msg);
			fail();
		}
	}
	**/

}