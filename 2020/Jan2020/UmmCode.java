import java.io.*;
import java.util.*;

public class UmmCode
{
	public static void main(String[] args) throws IOException
	{
		InputReader stdinReader = new InputReader();
		
		StringBuilder binary = new StringBuilder(71424);
		StringBuilder temp = new StringBuilder(71424);
		String line = stdinReader.nextLine();
		for(String part: line.split(" "))
		{
			char[] partChars = part.toCharArray();
			boolean isMessage = true;
			for(char c: partChars)
			{
				if(!(c == 'u' || c == 'm' || c < 48 || (c > 57 && c < 65) || (c > 90 && c < 97) || c > 122))
				{
					isMessage = false;
					break;
				}
				else
				{
					if(c == 'u')
						temp.append("1");
					else if(c == 'm')
						temp.append("0");
				}
			}
			
			if(isMessage)
			{
				binary.append(temp);
			}
			
			temp.setLength(0);
		}
		
		StringBuilder sb = new StringBuilder(71424);
		for(int i = 0; i < binary.length(); i+=7)
		{
			sb.append((char)(binary.charAt(i)-'0' << 6 | binary.charAt(i+1)-'0' << 5 | binary.charAt(i+2)-'0' << 4 | binary.charAt(i+3)-'0' << 3 |  binary.charAt(i+4)-'0' << 2 | binary.charAt(i+5)-'0' << 1 | binary.charAt(i+6) - '0'));
		}
		
		System.out.print(sb);
	}
}

class InputReader {
  
  /**
   * The default size of the InputReader's buffer is 2<sup>16</sup>.
   */
  private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
  
  /**
   * The default stream for the InputReader is standard input.
   */  
  private static final InputStream DEFAULT_STREAM = System.in;
  
  /**
   * The maximum number of accurate decimal digits the method {@link #nextDoubleFast() nextDoubleFast()} can read.
   * Currently this value is set to 21 because it is the maximum number of digits a double precision float can have at the moment.
   */
  private static final int MAX_DECIMAL_PRECISION = 21;
  
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

  // A reusable character buffer when reading string data.
  private char[] charBuffer;

  // Primitive data type lookup tables used for optimizations
  private static byte[] bytes = new byte[58];
  private static  int[] ints  = new int[58];
  private static char[] chars = new char[128];

  static {
    char ch = ' '; int value = 0; byte _byte = 0;
    for (int i = 48; i <  58; i++ ) bytes[i] = _byte++;
    for (int i = 48; i <  58; i++ )  ints[i] = value++;
    for (int i = 32; i < 128; i++ ) chars[i] = ch++;
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
    if (stream == null || bufferSize <= 0)
      throw new IllegalArgumentException();
    buf = new byte[bufferSize];
    charBuffer = new char[128];
    this.bufferSize = bufferSize;
    this.stream = stream;
  }
  
  /**
   * Reads a single character from the input stream.
   * @return Returns the byte value of the next character in the buffer and EOF 
   * at the end of the stream.
   * @throws IOException throws exception if there is no more data to read
   */
  private byte read() throws IOException {

    if (numBytesRead == EOF) throw new IOException();

    if (bufIndex >= numBytesRead) {
      bufIndex = 0;
      numBytesRead = stream.read(buf);
      if (numBytesRead == EOF)
        return EOF;
    }

    return buf[bufIndex++];
  }
  
  /**
   *  Read values from the input stream until you reach a character with a 
   *  higher ASCII value than 'token'.
   * @param token The token is a value which we use to stop reading junk out of
   * the stream.
   * @return Returns 0 if a value greater than the token was reached or -1 if
   * the end of the stream was reached.
   * @throws IOException Throws exception at end of stream.
   */
  private int readJunk(int token) throws IOException { 
    
    if (numBytesRead == EOF) return EOF;

    // Seek to the first valid position index
    do {
      
      while(bufIndex < numBytesRead) {
        if (buf[bufIndex] > token) return 0;
        bufIndex++;
      }

      // reload buffer
      numBytesRead = stream.read(buf);
      if (numBytesRead == EOF) return EOF;
      bufIndex = 0;

    } while(true);

  }
  
  /**
   * Reads a single byte from the input stream.
   * @return The next byte in the input stream
   * @throws IOException Throws exception at end of stream.
   */
  public byte nextByte() throws IOException {
    return (byte) nextInt();
  }
  
  /**
   * Reads a 32 bit signed integer from input stream.
   * @return The next integer value in the stream.
   * @throws IOException Throws exception at end of stream.
   */
  public int nextInt() throws IOException {
    
    if (readJunk(DASH-1) == EOF) throw new IOException();
    int sgn = 1, res = 0;

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
  
  /**
   * Doubles the size of the internal char buffer for strings
   */
  private void doubleCharBufferSize() {
    char[] newBuffer = new char[charBuffer.length << 1];
    for(int i = 0; i < charBuffer.length; i++) newBuffer[i] = charBuffer[i];
    charBuffer = newBuffer;
  }
  
  /**
   * Reads a line from the input stream.
   * @return Returns a line from the input stream in the form a String not 
   * including the new line character. Returns <code>null</code> when there are 
   * no more lines. 
   * @throws IOException Throws IOException when something terrible happens.
   */
  public String nextLine() throws IOException {

    try { c=read(); } catch (IOException e) { return null; }
    if (c == NEW_LINE) return ""; // Empty line
    if (c == EOF) return null; // EOF
    
    int i = 0;
    charBuffer[i++] = (char)c;

    do {

      while(bufIndex < numBytesRead) {
        if (buf[bufIndex] != NEW_LINE) {
          if (i == charBuffer.length) doubleCharBufferSize();
          charBuffer[i++] = (char) buf[bufIndex++];
        } else {
          bufIndex++;
          return new String(charBuffer, 0, i);
        }
      }

      // Reload buffer
      numBytesRead = stream.read(buf);
      if (numBytesRead == EOF)
        return new String(charBuffer, 0, i);
      bufIndex = 0;

    } while(true);

  }


  // Closes the input stream
  public void close() throws IOException {
    stream.close();
  }

}
