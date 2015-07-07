package csv.meme;

import static org.junit.Assert.*;

import com.comcast.csv.meme.SolutionTest;
import com.comcast.csv.meme.SolutionUtil;

import org.junit.Test;


public class TestSolutionTest {

	SolutionTest st = new SolutionTest();
	
	@Test
	public void test() {
		
		
		
	}
	
	@Test
	public void testInterviewSolution(){
		assertEquals(st.interviewSolution(), 1);
		
	}
	

	@Test
	public void testWriteToFileSystem(){
		assertEquals(SolutionUtil.writeToFileSystem(SolutionUtil.filePath, SolutionUtil.createData()),1);
		
	}
}
