package blog.matheuscarvalho.multithreadfilereader.file.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {

	public static Set<String> listFiles(String dir) throws IOException {
		try (Stream<Path> stream = Files.list(Paths.get(dir)).parallel()) {
			return stream.filter(file -> !Files.isDirectory(file)).map(Path::toString).collect(Collectors.toSet());
		}
	}
}
