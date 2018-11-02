
public class LinkedList implements List {
	
	public Node head;

	@Override
	public void add(Object obj) throws Exception {
		
		Node node = new Node();
		node.value = obj;
		
		if(this.head == null) {
			this.head = node;
		} else {
			Node pointer = head;
			while(pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = node;
		}
		
	}

	@Override
	public void add(int pos, Object obj) throws Exception {
		
		Node node = new Node();
		node.value = obj;
		
		Node other = this.head;
		if(pos == 0) {
			this.head = node;
			node.next = other;
		} else {
			int i = 0;
			while(i != pos - 1) {
				other = other.next;
				i++;
			}
			Node temp = other.next;
			other.next = node;
			node.next = temp;
		}
		
	}

	@Override
	public Object get(int pos) throws Exception {
		Node n = this.head;
		
		if(pos == 0) {
			return n;
		}
		
		int i = 0;
		while(i != pos) {
			n = n.next;
			i++;
		}
		
		return n;
	}

	@Override
	public Object remove(int pos) throws Exception {
		
		Node n = this.head;
		
		if(pos == 0) {
			this.head = n.next;
			return n;
		}
		
		int i = 0;
		while(i != pos - 1) {
			n = n.next;
			i++;
		}
		
		Node temp = n.next;
		n.next = temp.next;
		
		return temp;
	}

	@Override
	public int size() {
		int size = 0;
		
		if(this.head == null) {
			return size;
		}
		
		size++;
		
		Node n = this.head;
		while(n.next != null) {
			size++;
			n = n.next;
		}
		return size;
	}
	
	private class Node {
		
		public Object value;
		public Node next;
		
		@Override
		public String toString() {
			return this.value.toString();
		}
	}
	
	public void print() {
		if(this.head != null) {
			System.out.print(this.head.toString());
			Node n = this.head;
			while(n.next != null) {
				System.out.print(" ");
				System.out.print(n.next.toString());
				n = n.next;
			}
		}
		System.out.println();
	}

}
