import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (ObjectOutputStream output = 
        		new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        } 
        outputData();
    }
    
    public static void outputData() {
    	double loanTotal = 0;
    	try (ObjectInputStream input = 
        		new ObjectInputStream(new BufferedInputStream(new FileInputStream("Exercise17_07.dat")));) {
            while (true) {
            	Loan loanA = (Loan) (input.readObject());
            	loanTotal += loanA.getLoanAmount();
            }
        } 
        catch (EOFException ex) {
            System.out.println(loanTotal);
        }
    	catch (IOException ex) {
			ex.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}