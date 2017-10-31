import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

/*** 
 * This is class is for testing the class MyTrie.
 * 
 * author: Raudel Ravelo (rrave070@uottawa.ca)
 */


public class TestTrie2 {
    
   public static boolean cmpLexTest1(String a, String[] correct)
    {
        String[] s = a.split("[,]+|[ ]+|[\\r\\n]+", 0);
        
        if(s.length != correct.length)
            return false;
        for(int i = 0; i < correct.length; i++)
            if(!correct[i].equals(s[i]))
                return false;
        return true;
    }
  
    public static void Test1(){
    
        // This main method is doing a simple test on the class with 
        // the same tree as Figure 1-2 in the handout
        System.out.println("-------------------------------------------");
        System.out.println("Test1");
        MyTrie tree = new MyTrie();
        System.out.println("\n**** Insert tests. ****\n");
        boolean result;
        int ins = 0;
        int nod = 0;
        int lex = 0;
        String[] mySequence = {"0", "001", "1010", "1010100", "110001011", "111", "1111", "11111"};
        String Lexicographical = "";
        String[] mySearchSeq = {"110001011", "0", "111111", "10100", "001"};

        for (int i = 0; i < mySequence.length; i++) {
            Lexicographical = Lexicographical + mySequence[i] + ",";
            result = tree.insert(mySequence[i]);
            if (!result) { 
                ins++;
                System.out.println("Expected true, but received : " + result); 
            } else { 
                System.out.println("Inserted : " + mySequence[i]); 
            }
        }

        System.out.println("\n**** Search tests. ****\n");

        result = tree.search("110001011"); //true
        if (!result) { 
            nod++; 
            System.out.println("Wrong, didn't find it. (110001011)");
        } else { System.out.println("Found it.(110001011)"); }
        result = tree.search("0"); //true
        if (!result) { 
            nod++; 
            System.out.println("Wrong, didn't find it. (0)");
        } else { System.out.println("Found it.(0)"); }
        result = tree.search("111111"); //false
        if (result) { 
            nod++; 
            System.out.println("Wrong, did find it. Impossible. (111111)");
        } else { System.out.println("Didn't find it.(111111)"); }
        result = tree.search("10100"); //false
        if (result) { 
            nod++; 
            System.out.println("Wrong, did find it. Impossible. (10100)");
        } else { System.out.println("Didn't find it.(10100)"); }
        result = tree.search("001"); //true
        if (!result) { 
            nod++; 
            System.out.println("Wrong, didn't find it. (001)");
        } else { System.out.println("Found it.(001)"); }

        System.out.println("\n**** Lexicographical tests. ****\n");

        System.out.println("Result :");
        tree.printStringsInLexicoOrder();
        System.out.println("\nExpected :\n" + Lexicographical);
                
        System.out.println("\nTest1 results:");
        System.out.println("Correct Answers (Inserting): " + (8-ins) + "/8");
        System.out.println("Correct Answers (Search): " + (5-nod) + "/5");
        //System.out.println("Correct Answers (Lexicographical): " + (1-lex) + "/1");
        System.out.println("-------------------------------------------\n");
    }
    
    public static void main(String[] args) {
  
        Test1(); // Method that tests what I've implemented.
    }
    
}
