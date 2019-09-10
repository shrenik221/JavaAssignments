package Assignment;

import java.util.HashMap;
import java.util.Scanner;

class MobileException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MobileException() {
	}

	MobileException(String s) {
		super(s);
	}
}

class CheckValidations {
	CheckValidations() {
	}

	void MinimumBalance(HashMap<String, Integer> map, String curMn, int amount) throws MobileException {
		if (amount < map.get(curMn))
			throw new MobileException("Minimum recharge amount is:" + map.get(curMn).toString());
	}

	void CheckNumberExists(HashMap<String, Integer> map, String curMn) throws MobileException {
		if (!map.containsKey(curMn))
			throw new MobileException("Mobile number not is subscriber list");
	}

	void ValidateMn(String curMn) throws MobileException {
		if (curMn.length() != 10)
			throw new MobileException("\nNot a Valid Mobile Number");
	}

	int CheckSub(String cur) throws MobileException {
		if (cur.equals("airtel") || cur.equals("jio") || cur.equals("vodafone")) {
			if (cur.equals("airtel")) {
				return 0;
			} else if (cur.equals("jio")) {
				return 1;
			} else if (cur.equals("vodafone")) {
				return 2;
			}
		} else
			throw new MobileException("We don't support this service provider");
		return -1;
	}
}

public class Mobile {
	 static String curMn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> airtel = new HashMap<String, Integer>();
		HashMap<String, Integer> jio = new HashMap<String, Integer>();
		HashMap<String, Integer> vodafone = new HashMap<String, Integer>();
		CheckValidations call = new CheckValidations();
		airtel.put("9845000001", 200);
		airtel.put("9845000002", 300);
		airtel.put("9845000003", 150);
		jio.put("9110600001", 200);
		jio.put("9110600002", 300);
		jio.put("9110600003", 150);
		vodafone.put("9886000001", 200);
		vodafone.put("9886000002", 300);
		vodafone.put("9886000003", 150);
		boolean check = false;
		boolean progress = false;
		
//		System.out.print("Enter the service provider:");
		Scanner obj = new Scanner(System.in);
		
		int amount = 0;
		int index_list = -1;
		boolean pass=true;
		while(pass){
		try {
			System.out.print("\nEnter the service provider:");
			String cur = obj.next();
			index_list = call.CheckSub(cur);
			pass=false;
		} catch (Exception e) {
			System.out.print(e);
			pass=true;
		}
		}
		pass=true;
		while(pass){
		System.out.print("\nEnter mobile number:");
		String curMns = obj.next();
		Mobile.curMn =curMns;
		try {
			call.ValidateMn(curMns);
			pass=false;
			progress = true;
		} catch (Exception e) {
			System.out.print(e);
			pass=true;
		}
		}
		if (progress) {
			
			try {
				switch (index_list) {

				case 0:
					call.CheckNumberExists(airtel, curMn);
					check = true;
					break;
				case 1:
					call.CheckNumberExists(jio, curMn);
					check = true;
					break;
				case 2:
					call.CheckNumberExists(vodafone, curMn);
					check = true;
					break;
				default:
					System.out.println("\nWrong choice entered");
					break;
				}
			} catch (Exception e) {

				System.out.println(e);
				obj.close();
			}
		}

		if (check) {

			System.out.print("Enter recharge amount:");
			amount = obj.nextInt();

			try {
				switch (index_list) {
				case 0:
					call.MinimumBalance(airtel, curMn, amount);
					break;
				case 1:
					call.MinimumBalance(jio, curMn, amount);
					break;
				case 2:
					call.MinimumBalance(vodafone, curMn, amount);
					break;
				default:
					System.out.println("\nWrong choice entered");
					break;
				}

			} catch (Exception e) {
				System.out.println(e);
				obj.close();
				return;
			}
		}

		System.out.println("Thankyou");
		obj.close();
	}

}
