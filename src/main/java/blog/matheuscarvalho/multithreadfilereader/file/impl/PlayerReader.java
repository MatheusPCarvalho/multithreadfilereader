package blog.matheuscarvalho.multithreadfilereader.file.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import blog.matheuscarvalho.multithreadfilereader.enums.FileEnum;
import blog.matheuscarvalho.multithreadfilereader.file.FileReader;
import blog.matheuscarvalho.multithreadfilereader.model.Player;

public class PlayerReader implements FileReader<Player> {

	@Override
	public Set<Player> read(Path path) throws IOException {
		Set<Player> players = Collections.synchronizedSet(new HashSet<>());

		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach(s -> {
				String[] splited = s.split(FileEnum.PLAYER_SPLITTER.getValue());
				if (splited.length > 0 && splited.length == 3) {
					players.add(new Player(splited[0], splited[1], splited[2]));
				}
			});
		}
		return players;
	}

}
