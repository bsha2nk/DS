package com.bsha2nk.sll;

public class SingleLinkedList {

	private SingleNode head;
	private SingleNode tail;
	private int size;

	public void createSLL(int value) {
		head = tail = new SingleNode();
		head.setValue(value);
		size = 1;
	}

	public void add(int value, int location) {
		if(!existsSLL()) {
			return;
		}

		SingleNode node = new SingleNode();
		node.setValue(value);

		if(location == 0) {
			node.setNext(head);
			head = node;
		} else if (location >= getSize()) {
			tail.setNext(node);
			tail = node;
		} else {
			SingleNode tempNode = head;
			for(int i=0; i<location-1; i++) {
				tempNode = tempNode.getNext();
			}

			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
		}

		size++;
	}

	public boolean search(int value) {
		SingleNode node = head;

		for(int i=0; i<size; i++) {
			if(value == node.getValue()) {
				System.out.println("Found %s at position " + (i+1));
				return true;
			}

			node = node.getNext();
		}

		System.out.println("Not found");
		return false;
	}

	public void delete(int location) {
		SingleNode node = head;

		if(!existsSLL())
			return;

		if(location == 0) {
			head = head.getNext();
			size--;

			if(size == 0) {
				tail = null;
			}
		} else if(location >= size-1) {
			for(int i=0; i<size-1; i++) {
				node = node.getNext();
			}

			size--;
			if(size == 0) {
				head = tail = null;
				return;
			}

			node.setNext(null);
			tail = node;

		} else {
			for(int i=0; i<location-1; i++) {
				node = node.getNext();
			}

			node.setNext(node.getNext().getNext());
			size--;
		}
	}

	private boolean existsSLL() {
		return head != null;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		SingleNode node = head;

		//		for(int i=0; i<size; i++) {
		//			System.out.print(node.getValue());
		//			if (i != getSize() - 1) {
		//				System.out.print(" -> ");
		//			}
		//			node = node.getNext();
		//		}

		while (node != null) {
			System.out.print(node.getValue());
			node = node.getNext();
			if (node != null) {
				System.out.print(" -> ");
			}
		}
		
		System.out.println();

		return "";
	}

//	void reverse() {
//		
//		SingleNode pointer = head.next;
//		SingleNode N = head;
//		N.next = null;
//		
//		while(pointer != null) {
//			SingleNode temp = pointer.next;
//			
//			pointer.next = N;
//			N = pointer;
//			pointer = temp;
//		}
//		
//		head = N;
//	}
	
	
	public void removeElements(int val) {
        SingleNode pointer = null;
        SingleNode node = head;
        head = null;
        
        while(node != null){
            if(node.value != val) {
            	SingleNode N = new SingleNode();
        		N.value = node.value;
            	
        		if(head == null) {
            		pointer = N;
            		head = pointer;
            	} else {
            		pointer.next = N;
            		pointer = N;
            	}
            }
            
            node = node.next;
        }
    }
	
	public void findMiddleInSinglePass() {
		SingleNode current = head;
		SingleNode mid = head;
		
		int loc = 0;
		
		while (current.next != null) {
			loc++;
			
			if(loc%2 == 0) {
				mid = mid.next;
			}
			
			current = current.next;
		}
		
		System.out.println("middle is " + mid.value);
	}
	
	void reverse() {
		
		SingleNode pointer = head;
		SingleNode previous = null;
		SingleNode current = null;
		
		while(pointer != null) {
			current = pointer;
			pointer = pointer.next;
			
			current.next = previous;
			previous = current;
			head = current;
		}
	}
	
	void nthNodeFromLast(int n) {
		
		SingleNode node = head;
		while(true) {
			SingleNode temp = node;
			for(int i=0; i<n; i++) {
				temp = temp.next;
			}
			
			if (temp == null) {
				break;
			} else if (temp.next != null) {
				node = node.next;
			} else {
				node = node.next;
				break;
			}
		}
		
		System.out.println(node.value);
	}
	
	public void getLastNode(int n) {
		SingleNode fast = head;
		SingleNode slow = head;
		
		int count = n;
		while(fast.next != null) {
			fast = fast.next;
			count--;
			
			if(count <= 0) {
				slow = slow.next;
			}
		}
		
		System.out.println(slow.value);
	}


}
