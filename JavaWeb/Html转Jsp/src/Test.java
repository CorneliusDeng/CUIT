import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Test {
	
	public static void main(String[] args) throws IOException {
		replaceSuffix(new File("D:/AllSourceCode/JavaWeb/student_5/WebContent/score"), "html", "jsp");
	}

	public static void replaceSuffix(File file, String oldSuffix, String newSuffix) throws IOException {
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			if (listFiles[i].isDirectory()) {
				replaceSuffix(listFiles[i], oldSuffix, newSuffix);
			} else {
				if (listFiles[i].isFile() && listFiles[i].getName().endsWith(oldSuffix)) {
					String absolutePath = listFiles[i].getAbsolutePath();

					List<String> lines = Files.readAllLines(listFiles[i].toPath(), Charset.forName("UTF-8"));
					lines.add(0, "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>");

					int lastIndexOf = absolutePath.lastIndexOf(".");
					String prefix = absolutePath.substring(0, lastIndexOf);
					File newFile = new File(prefix + "."+newSuffix);
					newFile.createNewFile();
					Files.write(newFile.toPath(), lines, Charset.forName("UTF-8"), StandardOpenOption.CREATE);

					System.out.println(newFile.getAbsolutePath());
				}
			}
		}
	}
}
