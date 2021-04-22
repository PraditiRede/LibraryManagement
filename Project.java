import java.util.Scanner;

class Dll
{
    Node start;
    static class Node
    {  
        int book_id , student_id ,issue_date , return_date;
        Node next;
        Node prev;
        Node(int a , int b ,int c ,int d)
        {
            book_id = a;
            student_id = b;
            issue_date = c;
            return_date = d;
        }
    }   

    static Dll add(Dll list, int a, int b , int c , int d)
    {
        Node new_node = new Node(a,b,c,d);
        new_node.next = null;
        new_node.prev = null;
        if(list.start== null)
        {
            list.start = new_node;
        }
        else
        {
            Node last = list.start;
            Node prev = list.start;
            while(last.next!=null)
            {
                last.prev = last;
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    } 

    static void print(Dll list)
    {
        Node q = list.start;
        System.out.println("Book id"+"\t "+"Student id"+"\t"+ "Issue date"+"\t"+ "Return date");
        while(q != null)
        {
            System.out.println(q.book_id+"\t"+"\t"+q.student_id+"\t"+"\t"+ q.issue_date+"\t"+"\t"+ q.return_date);
            q=q.next;
        }
        return;
    }

    static void issue( Dll list)
    {
        Node n = list.start;
        Scanner obj3 = new Scanner(System.in);
        System.out.println("Enter Book id");
        int a = obj3.nextInt();
        System.out.println("Enter student id");
        int b = obj3.nextInt();
        System.out.println("Enter Issue date");
        int c = obj3.nextInt();
        System.out.println("Return book date");
        int d = obj3.nextInt();
        while(n.book_id!=a)
        {
            n = n.next;
        }
        n.student_id = b;
        n.issue_date = c;
        n.return_date = d;
        return;
    }

    static void returnbook( Dll list)
    {
        Node n = list.start;
        System.out.println("Enter Book id ");
        Scanner c = new Scanner(System.in);
        int a = c.nextInt();
        while(n.book_id!=a)
        {
            n = n.next;
        }
        n.student_id = 0;
        n.issue_date = 0;
        n.return_date = 0;
        return;
    }
}

public class Project 
{
    public static void main(String [] args)
    {
        Dll list = new Dll();
        list = Dll.add(list,111,0,0,0);
        list = Dll.add(list,222,0,0,0);
        list = Dll.add(list,333,0,0,0);
        list = Dll.add(list,444,0,0,0);
        list = Dll.add(list,555,0,0,0);

        while(true)
        {
            System.out.println("Library Management");
            System.out.println("Press 1 to Add a book to the library");
            System.out.println("Press 2 to Issue a book from the library");
            System.out.println("Press 3 to Return a book to the library");
            System.out.println("Press 4 to Print library books details");
            System.out.println("Press 5 to Exit");

            Scanner obj1 = new Scanner(System.in);
            System.out.println("Enter any number");
            int choice = obj1.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Enter the book id");
                    int x = obj1.nextInt();
                    list = Dll.add(list, x, 0,0,0);
                    break;

                case 2:
                    Dll.issue(list);
                    break;

                case 3:
                    Dll.returnbook(list);
                    break;

                case 4:
                    Dll.print(list);
                    break;

                case 5: 
                    System.exit(0); 
                    break;           
            }
        }
    }
}
