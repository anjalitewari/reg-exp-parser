import java.io.*;
import java.util.*;

/**
 * 
 * @author Anjali Tewari		axt6472
 *
 */
public class TM {
	
	public static void main( String[] args ) {
		
		char[] tapeCharArr;
		String l1 = null;
		
		try {
			BufferedReader r1 = new BufferedReader( new FileReader( args[0] ) );
			l1 = r1.readLine().trim();
			r1.close();
		}
		
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		tapeCharArr = l1.toCharArray();
		
		String[][] tm = readTM( args[1] );
		
		runTM( tapeCharArr, tm );
		
	}
	
	public static String[][] readTM( String file ) {
		
		BufferedReader br = null;
		ArrayList<String> al = new ArrayList<String>();
		String line = null;
		String[] temp = null;
		String[][] tmCode = null;
		try {
			br = new BufferedReader( new FileReader( file ) );
			while( (line = br.readLine() ) != null ) {
			
				temp = line.split("\\s");
				for(int a = 0; a < 5; a++) {
					al.add( temp[a] );
				}
				
				line = null;
				
				
			}
			br.close();
			tmCode = new String[ al.size()/5  ][ 5 ];
			int c = 0;
			int x = 0;
			while( c < al.size()/5  ) {  
				for( int i = 0; i < 5; i++ ) {
					//System.out.println(c + "," + i);
					tmCode[c][i] = al.get( x );
					x++;
				}
				c++;
			}
			
			
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return tmCode;
		
	}
	
	public static void runTM( char[] tape, String[][] tm ) {
		
		int head = 0;
		char read;
		String currState = tm[0][0];
		String replace = null;
		String move = null;
		String nextState = null;
		Boolean halt = false;
		Boolean match = false;
		
		
		
		System.out.println( "PresentState\tTapeHead\tTapeStatus" );
		int count = 0;
		try {
			
		
		while( !halt ) {
			read = tape[ head ];
			for( int a = 0; a < tm.length; a++ ) {
				//System.out.println(tm[a][a]);
								
				if( currState.equals( tm[a][0] ) && read == tm[a][1].charAt(0) ) {
					match = true;
					move = tm[a][2];
					replace = tm[a][3];
					read = replace.charAt(0);
					tape[ head ] = replace.charAt(0);
					nextState = tm[a][4];
					System.out.println( currState + "\t\t" + read + "\t\t" + nextState  );

				}

			}
			if( !match ) {
				System.out.println( "No match for state and input : " + currState + " " + read );
				System.out.print( "String Rejected" );
				break;
			}
			match = false;
			if( move.equals("R") ) {
				head++;
			}
			else if( move.equals("L") ) {
				head--;
			}
			
			if( nextState.equals( "accept") || Character.toString(tape[ head ]).equals("$")) {
				halt = true;
				System.out.print( "String Accepted" );
				break;
				
			}
			else {
				currState = nextState;
				nextState = null;
				move = null;
			}
			
			count++;
				
		}
		}
		catch( ArrayIndexOutOfBoundsException ae ) {
			System.out.print("String rejected");
			System.exit(0);
		}
		catch ( Exception e ) {
			System.out.print(e.getMessage());
			System.exit(0);
		}
		
	}
	
}
