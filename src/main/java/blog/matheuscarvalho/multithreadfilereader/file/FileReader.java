package blog.matheuscarvalho.multithreadfilereader.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

public interface FileReader<T> {

	public Set<T> read(Path path) throws IOException;
}
