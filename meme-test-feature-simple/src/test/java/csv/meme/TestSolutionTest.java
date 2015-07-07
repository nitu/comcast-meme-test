package csv.meme;

import static org.junit.Assert.*;

import com.comcast.csv.meme.SolutionTest;
import com.comcast.csv.meme.SolutionUtil;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.testng.annotations.ExpectedExceptions;


public class TestSolutionTest {

	SolutionTest st = new SolutionTest();
	
	public void setUp( ) { 
		this.st = new SolutionTest( );  
		
	} 
	
	public void tearDown( ) {
		this.st = null; 
		
	} 
	
	
	@Test
	public void testInterviewSolution(){
		try {
			assertEquals(st.interviewSolution(), 1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testWriteToFileSystem(){
		try {
			assertEquals(SolutionUtil.writeToFileSystem(SolutionUtil.filePath, SolutionUtil.createData()),1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testWriteToFileSystemIOException() throws FileNotFoundException{
		SolutionUtil.writeToFileSystem("", SolutionUtil.createData());
		
	}
}
