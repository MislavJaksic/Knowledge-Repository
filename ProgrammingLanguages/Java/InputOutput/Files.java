//Byte streams
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//Character streams
import java.io.FileReader;
import java.io.FileWriter;
//Line by line streams
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Files
{
	public static void main(String[] args) throws IOException
	{
		//Must be declared outside because the finally block needs to see it
		//Must throw an exception if something is wrong
		BufferedReader inputLineStream = null;
		PrintWriter outputLineStream = null;
        try 
		{
			//Read until you hit a \n or \r
            inputLineStream = new BufferedReader(new FileReader("TestText.txt"));
			outputLineStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            while ((l = inputLineStream.readLine()) != null) {
                System.out.println(l);
				outputLineStream.println(l);
            }
        } 
		finally 
		{
            if (inputLineStream != null) {
                inputLineStream.close();
            }
			if (outputLineStream != null) {
                outputLineStream.close();
            }
        }
		/*FileInputStream inputByteStream = null;
		try
		{
			//Files
			//InputSteam reads a file 8bits by 8bits; don't use it
			inputByteStream = new FileInputStream("TestText.txt");
			int c;
			while ((c = inputByteStream.read()) != -1)
			{
				System.out.print(c + " ");
			}
		}
		finally
		{
			if (inputByteStream != null)
			{
				inputByteStream.close();
			}
		}
		
		FileReader inputCharStream = null;
		try 
		{
			//Character stream
            inputCharStream = new FileReader("TestText.txt");

            int c;
            while ((c = inputCharStream.read()) != -1) {
                System.out.print(c + " ");
            }
        } 
		finally 
		{
            if (inputCharStream != null) {
                inputCharStream.close();
            }
        }
		*/
	}
}