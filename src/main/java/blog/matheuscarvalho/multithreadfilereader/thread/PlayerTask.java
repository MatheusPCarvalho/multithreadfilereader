package blog.matheuscarvalho.multithreadfilereader.thread;

import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.Callable;

import blog.matheuscarvalho.multithreadfilereader.file.FileReader;
import blog.matheuscarvalho.multithreadfilereader.file.impl.PlayerReader;
import blog.matheuscarvalho.multithreadfilereader.model.Player;

public class PlayerTask implements Callable<Set<Player>> {

	private FileReader<Player> reader = new PlayerReader();

	private String path;

	PlayerTask(String path) {
		this.reader = new PlayerReader();
		this.path = path;
	}

	@Override
	public Set<Player> call() throws Exception {
		System.out.println("Thread ID");
		System.out.println(Thread.currentThread().getId());
		return reader.read(Paths.get(path));
	}

}
