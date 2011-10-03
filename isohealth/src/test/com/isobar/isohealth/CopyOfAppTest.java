package test.com.isobar.isohealth;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CopyOfAppTest extends TestCase {
    
	public CopyOfAppTest( String authtoken ) {
        super( authtoken );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( CopyOfAppTest.class );
    }

    public void testApp() {
    	System.out.println();
        assertTrue( true );
    }
}
