import java.io.*;
import java.util.*;

public class LooRolls
{
    public static void main(String[] args) throws Exception
    {
        InputReader ir = new InputReader();

        long l = ir.nextLong();
        long n = ir.nextLong();

        long left = l % n;

        long k = 1;

        while(left != 0)
        {
            k++;

            n = n - left;

            left = l % n;
        }

        System.out.println(k);

        ir.close();
    }
}

class InputReader {
    /**
     * The default size of the InputReader's buffer is 2<sup>16</sup>.
     */
    private static final int DEFAULT_BUFFER_SIZE = 1 << 20;
    
    /**
     * The default stream for the InputReader is standard input.
     */  
    private static final InputStream DEFAULT_STREAM = System.in;
    
    
    // 'c' is used to refer to the current character in the stream
    private int c;
    
    // Variables associated with the byte buffer. 
    private byte[] buf;
    private int bufferSize, bufIndex, numBytesRead;
    
    private InputStream stream;
  
    // End Of File (EOF) character
    private static final byte EOF   = -1;
  
    // New line character: '\n'
    private static final byte NEW_LINE = 10;
  
    // Space character: ' '
    private static final byte SPACE = 32;
  
    // Dash character: '-'
    private static final byte DASH  = 45;
  
    // Dot character: '.'
    private static final byte DOT   = 46;
  
    // Primitive data type lookup tables used for optimizations
    private static  int[] ints  = new int[58];
  
    static {
      char ch = ' '; int value = 0; byte _byte = 0;
      for (int i = 48; i <  58; i++ )  ints[i] = value++;
    }
    
    /**
     * Create an InputReader that reads from standard input.
     */
    public InputReader () {
      this(DEFAULT_STREAM, DEFAULT_BUFFER_SIZE);
    }

    /**
   * Create an InputReader that reads from standard input.
   * @param  stream        Takes an {@link java.io.InputStream#InputStream() InputStream} as a parameter to read from.
   * @param  bufferSize    The size of the buffer to use.
   */
    public InputReader (InputStream stream, int bufferSize) {
        buf = new byte[bufferSize];
        this.bufferSize = bufferSize;
        this.stream = stream;
    }
    
    /**
   * Reads a 64 bit signed long from input stream.
   * @return The next long value in the stream.
   * @throws IOException Throws exception at end of stream.
   */
    public long nextLong() throws IOException
    {  
        int sgn = 1;
        long res = 0L;
        c = buf[bufIndex];
        if (c == DASH) { sgn = -1; bufIndex++; }

        do {

        while(bufIndex < numBytesRead) {
                if (buf[bufIndex] > SPACE) {
                res = (res<<3)+(res<<1);
                res += ints[buf[bufIndex++]];
            } else {
                bufIndex++;
                return res*sgn;
            }
        }

        // Reload buffer
        numBytesRead = stream.read(buf);
        if (numBytesRead == EOF) return res*sgn;
            bufIndex = 0;
        } while(true);
    }
  
    // Closes the input stream
    public void close() throws IOException {
      stream.close();
    }
}