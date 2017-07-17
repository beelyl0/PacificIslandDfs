package com.pacificisland;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class IslandsTest 
    extends TestCase
{
	
    public IslandsTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        return new TestSuite(IslandsTest.class);
    }
    
    public void testReentrantCount()  throws IOException, IllegalInputDataException
    {
    	Islands islands = new Islands("test_files/oneRowCase.txt");
    	assertTrue(islands.count() == 0);
    	islands.read();
        assertTrue(islands.count() == 4);
        assertTrue(islands.count() == 4);
        islands.read();
        assertTrue(islands.count() == 4);
    }

    public void testWithotIslands() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/withoutIslandsCase.txt");
    	islands.read();
        assertTrue(islands.count() == 0);
    }
    
    public void testOneColumn() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/oneColumnCase.txt");
    	islands.read();
        assertTrue(islands.count() == 2);
    }
    
    public void testOneRow() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/oneRowCase.txt");
    	islands.read();
        assertTrue(islands.count() == 4);
    }
    
    public void testUsualy1() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/usualyCase-1.txt");
    	islands.read();
        assertTrue(islands.count() == 5);
    }
    
    public void testUsualy2() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/usualyCase-2.txt");
    	islands.read();
        assertTrue(islands.count() == 4);
    }

    public void testMin() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/minCase.txt");
    	islands.read();
        assertTrue(islands.count() == 0);
    }

    public void testMax() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/maxCase.txt");
    	islands.read();
        assertTrue(islands.count() == 1);
    }
    
    public void testSame() throws IOException, IllegalInputDataException      
    {
    	Islands islands = new Islands("test_files/sameIslandsCase.txt");
    	islands.read();
        assertTrue(islands.count() == 12);
    }

}
