import java.util.*;
public class UserLinkidListDriver {
	public static void main(String[] args) {
		UserLinkidList<Integer> list = new UserLinkidList<>();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.addLast(70);
		list.addFirst(80);
		System.out.println(list);
		System.out.println(list.isEmpty());
		System.out.println(list.size());

		UserLinkidList<Integer> list2 = new UserLinkidList<>();

		list2.add(15);
		list2.add(25);
		list2.add(35);
		list2.add(45);
		System.out.println(list2);

		list.addAll(list2);
		System.out.println(list);
	
	
	}
}