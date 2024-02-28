package graph;

import java.util.ArrayList;

public class Exa {
	
	static class student{
		String name;
		int roll;
		
		student(String name, int roll){
			this.name=name;
			this.roll=roll;
		}
	}

	public static void main(String[] args) {
		
		ArrayList<student>  one= new ArrayList<>();
		one.add(new student("abhishek", 1));
		one.add(new student("saurabh", 2));
		one.add(new student("prateek", 3));
		System.out.println(one.get(1).roll);
		for(int i=0;i<one.size();i++) {
			student s1=one.get(i);
			System.out.println(s1.name  +" "+ s1.roll);
		}
		
		
		// TODO Auto-generated method stub

	}

}
