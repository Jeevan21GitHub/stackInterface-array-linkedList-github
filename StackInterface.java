import java.util.Scanner;
import javax.swing.text.AbstractDocument.BranchElement;
import javax.xml.transform.Source;
interface StackIn{
    public void push();
    public void pop();
    public void display();
}
class ArrayStack implements StackIn{
    int n=5;
    int stack[]=new int[n];
    int top=-1;
    Scanner sc=new Scanner(System.in);
    public void push(){
        if(top==n-1){
            System.out.println("Stack Overflow");
        }
        else{
            System.out.println("Enter the Element:");
            int element=sc.nextInt();
            stack[++top]=element;
        }
    }
    public void pop(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            int popElement=stack[top];
            --top;
            System.out.println("Pop Element:"+popElement);
        }
    }
    public void display(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            int temp=top;
            while(temp!=-1){
                System.out.print(stack[temp--]+" <-- ");
            }
        }
    }
}

class LikedListStack implements StackIn{
    Scanner sc=new Scanner(System.in);
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    LikedListStack(){
        this.head=null;
    }
    public void push(){
        System.out.println("Enter the element");
        int element=sc.nextInt();
        Node newNode=new Node(element);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;           
        }
    }
    public void pop(){
        if(head==null){
            System.out.println("List is empty");
        }
        else if(head.next==null){
            Node temp=head;
            System.out.println("Pop element:"+temp.data);
            head=temp.next;
            temp.next=null;

        }
        else{
            Node temp=head;
            Node prev=temp;

            while(temp.next!=null){
                prev=temp;
                temp=temp.next;
            }
            prev.next=null;
            System.out.println("Pop element:"+temp.data);
        }
    }
    public void display(){
        if(head==null){
            System.out.println("List is empty");
        }
        else{
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" --> ");
                temp=temp.next;
            }
        }
    }
}

class StackInterface{
    public static void main(String args[]){
        ArrayStack as=new ArrayStack();
        LikedListStack ls=new LikedListStack();
        
        Scanner sc=new Scanner(System.in);

        boolean yes=true;
        while(yes){
            System.out.println("\n1.Stack Array Interface\n2.Liked List Array Interface\n3.exit\n");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:{
                    boolean y=true;
                     while(y){
                    System.out.println("\n1.Push\n2.Pop\n3.Display\n4.exit\n");
                    int ch=sc.nextInt();    
                    switch(ch){
                        case 1:as.push();
                               break;
                        case 2:as.pop();
                               break;
                        case 3:as.display();
                               break;
                        case 4:y=false;
                              break;
                    }
                   }
                }break;
                 
                case 2:{
                    boolean y1=true;
                    while(y1){
                    System.out.println("\n1.Push\n2.Pop\n3.Display\n4.exit\n");
                    int ch=sc.nextInt();
                        switch(ch){
                            case 1:ls.push();break;
                            case 2:ls.pop();break;
                            case 3:ls.display();break;
                            case 4:y1=false;break;
                        }
                       }
                    break;
                }
                case 3:{
                    yes=false;
                      
                } break;
            }
        }
    }
    }