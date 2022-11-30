package blog.matheuscarvalho.multithreadfilereader.thread;

import java.io.IOException;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import blog.matheuscarvalho.multithreadfilereader.enums.FileEnum;
import blog.matheuscarvalho.multithreadfilereader.file.util.FileUtil;
import blog.matheuscarvalho.multithreadfilereader.model.Player;

public class PlayerExecutor extends BaseExecutor<String, Set<Player>> {

	public PlayerExecutor() {
		super(Executors.newCachedThreadPool());
	}

	@Override
	public Map<String, Set<Player>> run() throws IOException, Exception {

		Map<String, Set<Player>> mapFilesPlayers = Collections.synchronizedMap(new Hashtable<>());

		Set<String> playersFiles = FileUtil.listFiles(FileEnum.PLAYER_DIRECTORY.getValue());

		Map<String, Future<Set<Player>>> futures = Collections.synchronizedMap(new Hashtable<>());

		playersFiles.stream().forEach(f -> {
			Future<Set<Player>> future = executor.submit(new PlayerTask(f));
			futures.put(f, future);
		});

		futures.forEach((key, value) -> {
			try {
				mapFilesPlayers.put(key, value.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});

		executor.shutdown();

		return mapFilesPlayers;
	}

}
