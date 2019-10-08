package com.sims.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	void switchTest()
	{
		int n[]={1,2,3,4,5};
		for(int i=3;i<n.length;i++)
		{
			switch (n[i]) {
			case 1:
				System.out.println("Admin Panel");
			case 2:
				System.out.println("Administration");
			case 3:
				System.out.println("Manage user");
			case 4:
				System.out.println("Fees Config");
			case 5:
				System.out.println("Examination");
				
			default:
				System.out.println("Academic Report");
				break;
			}
		}
	}
	void ifTest()
	{
		int n[]={1,2};
		for(int i=0;i<n.length;i++)
		{if(n[i]==1){
				System.out.println("Admin Panel");
		}
		else if(n[i]==2)
		{
				System.out.println("Administration");
		}else if(n[i]==3)
		{		System.out.println("Manage user");}
		else if(n[i]==4)
		{				System.out.println("Fees Config");}
		else if(n[i]==5)
		{	System.out.println("Examination"); }
				
		}
		}	
	
	void ifTest1()
	{boolean status =true;
		boolean status1=false;
		
	boolean st=true;
	boolean sf=false;
	
	
		if(status==st){
				System.out.println("Admin Panel");
		}
		else if(status1==sf)
		{
				System.out.println("Administration");
		}
		}
		
	public void stringTest()
	{
		int mark=90;
		String name1="Student";
		String name2="Student";
		if(name1.equals("Student"))
		{if(mark>80)
		{
			System.out.println("Agni== arul ang grade A");
		}
		else{System.out.println("grade B");}
		}
		else{System.out.println("NOt equal");}
	}
	public static void main(String[] args) {
		Test t=new Test();
		//t.stringTest();
		/*Test t=new Test();
		char ch1=6;
		System.out.println("ch1 "+ch1);
		t.ifTest1();*/
		
		String Str =new String(",,,,,,,8,,9");
			List<String> al=new ArrayList<>();
		for(String l:Str.split(","))
		{	l.trim();
			if(l.equals(""))
			{
			}
			else{al.add(l);}
			
		}
		System.out.println("l : "+al);
		System.out.println("size : "+al.size());
		Iterator<String> iter=al.iterator();
		for(int i=0;i<al.size();i++)
		{
			String cid=iter.next();
			System.out.println("cid : "+cid);
		}
		
	     /* for (String retval: Str.split(",")){
	    	  retval.trim();
	    	  char delid[]=retval.toCharArray();
	    	  for(int i=0;i<delid.length;i++)
	    	  {System.out.println("delid :"+delid[i]);
	      }}*/

		
		/*List<Integer> numList = new ArrayList<Integer>();

	  String as="8 9";
	  int[] n=new int[as.length()];
	    for(String s: as.split("\\s+"))
	    {
	    	// n=Integer.parseInt(s);
	    }
	        Integer[] num = numList.toArray(new Integer[numList.size()]);
	        System.out.println("show value " + as);
	        for (Integer m : num) {
	            System.out.println("\t" + m);
	        }*/
	}

}
