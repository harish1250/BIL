package scripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class Report_copy {
	
	@Test
	 public void copyFile() throws IOException{
		File source = new File("G:/Seleniu_workspace/pract/test-output/index.html");
        File dest = new File("G:/Seleniu_workspace/pract/src/Reports/index.html");
        FileUtils.copyFile(source, dest);
}
}