package test;

import java.util.Vector;

public class Printer {
	public static String output = ""; 
	public static Vector<Poem> poems = new Vector();
	
	public static Vector<Poem> getPoems() {
		return poems;
	}
	public static void setPoems(Vector<Poem> poems) {
		Printer.poems = poems;
	}
	Printer(){
		//poems.clear();
	}
	public static void add(Poem p){
		poems.add(p);
	}
	public static void println(String s){
		output+=(s+"\r\n");
	}
	public static void print(String s){
		output+=s;
	}
	
	public static String getOutput() {
		return output;
	}
	public static void setOutput(String output) {
		Printer.output = output;
	}
	public static void cls(){
		output="";
		poems.clear();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
