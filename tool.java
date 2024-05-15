import java.util.Scanner;


public class Main
{
  public static long packedPos = 6053910974308400L;
  public static final int NUM_X_BITS = 26;
  public static final int NUM_Z_BITS = NUM_X_BITS;
  public static final int NUM_Y_BITS = 64 - NUM_X_BITS - NUM_Z_BITS;
  public static final long X_MASK = (1L << NUM_X_BITS) - 1L;
  public static final long Y_MASK = (1L << NUM_Y_BITS) - 1L;
  public static final long Z_MASK = (1L << NUM_Z_BITS) - 1L;
  public static final int INVERSE_START_BITS_Z = NUM_Y_BITS;
  public static final int INVERSE_START_BITS_X = NUM_Y_BITS + NUM_Z_BITS;
  public static int unpackX (long packedPos)
  {
	return (int) (packedPos << 64 - INVERSE_START_BITS_X - NUM_X_BITS >> 64 -
				  NUM_X_BITS);
  }

  public static int unpackY (long packedPos)
  {
	return (int) (packedPos << 64 - NUM_Y_BITS >> 64 - NUM_Y_BITS);
  }

  public static int unpackZ (long packedPos)
  {
	return (int) (packedPos << 64 - INVERSE_START_BITS_Z - NUM_Z_BITS >> 64 -
				  NUM_Z_BITS);
  }
  public static long pack (int x, int y, int z)
  {
	long i = 0L;
	i = i | ((long) x & X_MASK) << INVERSE_START_BITS_X;
	i = i | ((long) y & Y_MASK) << 0;
	return i | ((long) z & Z_MASK) << INVERSE_START_BITS_Z;
  }
  public static void main (String[]args)
  {
	while (1 == 1)
	  {
        Scanner scanner = new Scanner(System.in);

		System.out.print ("> ");
		String input = scanner.nextLine();
		String[]arg = input.split (" ");
		if (arg.length == 1)
		  {
			long packedPos = Long.valueOf (arg[0]);
			System.out.println (unpackX (packedPos) + ", " +
								unpackY (packedPos) + ", " +
								unpackZ (packedPos));

		  }
		else
		  {
			int x = Integer.valueOf (arg[0]);
			int y = Integer.valueOf (arg[1]);
			int z = Integer.valueOf (arg[2]);
			System.out.println (pack (x, y, z));
		  }
	  }
  }
}
