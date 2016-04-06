package alg_hwk6;

public class HashMap {
    private final static int TABLE_SIZE = 36;

    HashEntry[] table;

    HashMap() 
    {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    public void get(int key) 
    {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          if (table[hash] == null)
                System.out.println("There is no record");
          else
                System.out.println("The value for key " + table[hash].getKey() + " is " + table[hash].getValue());
    }
    
    public void put(int key, int value) 
    {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          table[hash] = new HashEntry(key, value);
    }
    
}
