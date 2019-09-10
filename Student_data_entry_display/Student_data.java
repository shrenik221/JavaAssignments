package collections_framework;
import java.util.*;
class Data{
	ArrayList<Integer> age= new ArrayList<Integer>();
	ArrayList<Integer> sub1= new ArrayList<Integer>();
	ArrayList<Integer> sub2= new ArrayList<Integer>();
	ArrayList<Integer> sub3= new ArrayList<Integer>();

	ArrayList<String>	addr= new ArrayList<String>();
	public static int i =0;
	 
	Data(){
		
	}
	void entry(){
		Scanner obj= new Scanner(System.in);
		int count_students=0;
		int temp=0;
		System.out.println("Enter the number of students:\n");
		count_students=obj.nextInt();
		for(int i=0;i<count_students;i++){
			System.out.println("Enter detalis of "+(i+1)+" student:");
			System.out.println("Age of "+(i+1)+" student:");
			age.add(obj.nextInt());
			System.out.println("Marks of 1st subject of "+(i+1)+" student:");
			sub1.add(obj.nextInt());
			System.out.println("Marks of 2st subject of "+(i+1)+" student:");
			sub2.add(obj.nextInt());
			System.out.println("Marks of 3st subject of "+(i+1)+" student:");
			sub3.add(obj.nextInt());
			System.out.println("Address of "+(i+1)+" student:");
			addr.add(obj.next());
		}
		System.out.println("Do you want to display(0/1)?");
		temp=obj.nextInt();
		if(temp==1){
			display();
		}else{
			System.out.println("Thankyou");
		}
		obj.close();
	}
	void display(){
		Iterator<Integer> age_itr= age.iterator();
		Iterator<Integer> sub1itr= sub1.iterator();
		Iterator<Integer> sub2itr= sub2.iterator();
		Iterator<Integer> sub3itr= sub3.iterator();
		Iterator<String> addr_itr= addr.iterator();
		while(age_itr.hasNext()){
			System.out.println(" Age: "+age_itr.next()+" Subject_1: "+ 
		sub1itr.next()+" Subject_2: "+ sub2itr.next()+" Subject_3: "+
					sub3itr.next()+" Address: "+ addr_itr.next());
		}
	}
}
public class Student_data {
  public static void main(String[] args) {
	 Data obj= new Data();
	 obj.entry();
	 }
}
