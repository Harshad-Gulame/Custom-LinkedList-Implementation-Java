import java.util.*;
public class UserLinkidList<E> implements Cloneable{

	private int indx ;
	private Node<E> head ;
	private Node<E> tail ;

	private class Node<E>{
		E ele ;
		Node<E> next ;

		Node(E ele)
		{
			this.ele = ele ;
		}
	}
	@Override
	public String toString(){
		if (indx == 0)	return "[]";

		String op = "[" ;
		Node<E> curr = head ;

		while(curr.next!=null){
			op+=curr.ele + ", ";
			curr = curr.next ;
		}
		op+= curr.ele+"]";
		return op ;
		
	}

	public boolean add(E ele){
		Node<E> newNode = new Node<E>(ele);
		if (indx == 0) {
			head = newNode ;
			tail = head ;
			indx++;
		}
		else{
			tail.next = newNode ;
			tail = newNode ;
			indx++;
		}
		return true;
	}

	public void addLast(E ele){
		// if (size()==0) throw new UserNoSuchElementFoundEXception() ;
		add(ele);
	}

	public void addFirst(E ele)
	{
		// if (size() == 0) throw UserNoSuchElementFoundEXception();

		Node<E> newNode = new Node<E>(ele);
		newNode.next = head ;
		head = newNode ;
		indx ++ ;
	}

	public int size(){
		return indx ;
	}

	public boolean isEmpty(){
		return size() == 0;
	}

	public E removeLast(){
		// if (size() == 0) throw UserNoSuchElementFoundEXception ;
		E temp = tail.ele ;
		Node<E> curr = head ;
		for (int i = 0;i<size()-2 ;i++ ) {
			curr = curr.next;
		}

		tail = curr ;
		curr.next = null ;
		return temp ;
	}

	public E removeFirst(){
		// if(size() == 0) throw UserNoSuchElementFoundEXception();

		E temp = head.ele ;
		Node<E> curr = head ;
		head = head.next ;
		curr.next = null ;
		indx -- ;
		return temp ;
	}

	public E getFirst(){
		// if(size() == 0) throw UserNoSuchElementFoundEXception();

		return head.ele ;
	}

	public E getLast(){
		// if(size() == 0) throw UserNoSuchElementFoundEXception();

		return tail.ele ;

	}

	public void add(int indx , E ele){
		if (indx<0 || indx>size()) {
			throw new UserIndexOutOfBoundException("Index: "+indx+", size: "+size());
		}

		Node<E> newNode = new Node<>(ele);
		Node<E> curr1 = head ;
		for (int i = 0;i<indx-1 ;i++ ) {
			curr1 = curr1.next ;

		}
		Node<E> curr2 = curr1.next ;
		curr1.next = curr2 ;
		this.indx++;
	}
	public E remove(int indx){
		if (indx<0 || indx>size()) {
			throw new UserIndexOutOfBoundException("Index: "+indx+", size: "+size());
			
		}
		Node<E> curr1 = head ;
		for(int i = 0;i<indx-1;i++){
			curr1 = curr1.next ;
     	}
     	Node<E> curr2 = curr1.next ;
     	curr1.next = curr2.next ;
     	E temp = curr2.ele ;
     	curr2.next = null ;
     	this.indx--;
     	return temp ;
	}

	public boolean contains(Object obj){
		E search = (E)obj;
		if (search.equals(getLast())) return true ;
		Node<E> curr = head ;

		while(curr.next != null){
			if (curr.ele.equals(search)) return true ;
			curr = curr.next ;
		}
		return false ;
	}

	public int indexOf(Object obj){
		E search = (E) obj ;
		if (!contains(obj)) return -1 ;
		if (search.equals(getLast())) return size()-1 ;

		Node<E> curr = head ;
		int i = 0 ;
		while(curr.next!=null){
			if (curr.ele.equals(search)) return i;
			i++;
			curr = curr.next ;
		}
		return -1 ;
	}

	public E remove(){
		return removeLast();
	}
	public void clear(){
		while(!isEmpty()) removeFirst();
	}
	@Override

	public Object clone() throws CloneNotSupportedException {
		return super.clone() ;
	}

	public void addAll(UserLinkidList<E> list){
		UserLinkidList<E> list2 = new UserLinkidList<>() ;
		for (int i=1;i<list.size() ;i++ ) {
			list2.add(list.get(i));
		}
		while(!list2.isEmpty()){
			 
			 E ele = (E)list2.getFirst();
			this.addLast(ele);
			list2.removeFirst();
		}
	}

	public E get(int index) {

    if (indx < 0 || indx >= size()) {
        throw new IndexOutOfBoundsException("Index invalid");
    }

    Node<E> curr = head;

    for (int i = 0; i < indx; i++) {
        curr = curr.next;
    }

    return curr.ele;
}


}