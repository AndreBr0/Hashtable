import java.util.Scanner;

class HashEntry
{
    String key;
    int value;

    // Конструктор
    HashEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

// сам класс
class HashTable
{
    public int tablsize;

    public int size;

    public HashEntry[] table;

    public int primeSize;

    public HashTable(int tablsiz)
    {
        size = 0;
        tablsize = tablsiz;
        table = new HashEntry[tablsize];
        for (int i = 0; i < tablsize; i++)
            table[i] = null;
        primeSize = Primenumb();
    }

    // Функция которая выдает хеш-значение для данной строки
    public int hashv(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= tablsize;
        if (hashVal < 0)
            hashVal += tablsize;
        return hashVal;
    }

    // Вставляет в табилцу пару
    public void add(String key, int value)
    {
        if (size == tablsize)
        {
            System.out.println("Table full");
            return;
        }
        int hash1 = hashv( key );
        int hash2 = hashdouble( key );
        while (table[hash1] != null)
        {
            hash1 += hash2;
            hash1 %= tablsize;
        }
        table[hash1] = new HashEntry(key, value);
        size++;
    }

    // удаление ключа
    public void remove(String key)
    {
        int hash1 = hashv( key );
        int hash2 = hashdouble( key );
        while (table[hash1] != null && !table[hash1].key.equals(key))
        {
            hash1 += hash2;
            hash1 %= tablsize;
        }
        table[hash1] = null;
        size--;
    }

    // Достать нужный value по key
    public int get(String key)
    {
        int hash1 = hashv( key );
        int hash2 = hashdouble( key );

        while (table[hash1] != null && !table[hash1].key.equals(key))
        {
            hash1 += hash2;
            hash1 %= tablsize;
        }
        return table[hash1].value;
    }

    // Проверка на пустосту
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Очистить таблицу
    public void makeclear()
    {
        size = 0;
        for (int i = 0; i < tablsize; i++)
            table[i] = null;
    }

    // Узнаёт количество пар key-value
    public int getSize()
    {
        return size;
    }

    // Двойное хеширование
    public int hashdouble(String x )
    {
        int hashVal = x.hashCode( );
        hashVal %= tablsize;
        if (hashVal < 0)
            hashVal += tablsize;
        return primeSize - hashVal % primeSize;
    }


    // Функция получения простого числа котрое меньше размера таблицы для hashdouble
    public int Primenumb()
    {
        for (int i = tablsize - 1; i >= 1; i--)
        {
            int fact = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
                if (i % j == 0)
                    fact++;
            if (fact == 0)
                return i;
        }
        // Возвращает простое число
        return 3;
    }

    public void printHashTable()
    {
        System.out.println("\nHash Table");
        for (int i = 0; i < tablsize; i++)
            if (table[i] != null)
                System.out.println(table[i].key +" "+table[i].value);
    }
}

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