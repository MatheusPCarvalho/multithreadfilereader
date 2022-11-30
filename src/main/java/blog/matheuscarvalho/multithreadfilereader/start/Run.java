package blog.matheuscarvalho.multithreadfilereader.start;

import java.util.Map;
import java.util.Set;

import blog.matheuscarvalho.multithreadfilereader.model.Player;
import blog.matheuscarvalho.multithreadfilereader.thread.PlayerExecutor;

public class Run {

	public static void main(String[] args) throws Exception {
		Map<String, Set<Player>> mapFilePLayers = new PlayerExecutor().run();
		mapFilePLayers.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
	}
}
