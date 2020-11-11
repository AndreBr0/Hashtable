import java.util.Scanner;

// Для проведения тестов
class DoubleHashingHashTableTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        HashTable hashtable = new HashTable(scan.nextInt() );
        char ch;
        do
        {
            System.out.println("\nOperations\n");
            System.out.println("1. add ");
            System.out.println("2. remove");
            System.out.println("3. get");
            System.out.println("4. check empty");
            System.out.println("5. clear");
            System.out.println("6. hash table size");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter key and value");
                    hashtable.add(scan.next(), scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter key");
                    hashtable.remove( scan.next() );
                    break;
                case 3 :
                    System.out.println("Enter key");
                    System.out.println("Value = "+ hashtable.get( scan.next() ));
                    break;
                case 4 :
                    System.out.println("Empty Status " +hashtable.isEmpty());
                    break;
                case 5 :
                    hashtable.makeclear();
                    System.out.println("Hash Table Cleared\n");
                    break;
                case 6 :
                    System.out.println("Size = "+ hashtable.getSize() );
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            hashtable.printHashTable();

            System.out.println("\nContinue? (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}