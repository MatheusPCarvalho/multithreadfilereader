package blog.matheuscarvalho.multithreadfilereader.thread;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public abstract class BaseExecutor<S, T> {

	protected ExecutorService executor;

	public BaseExecutor(ExecutorService executor) {
		this.executor = executor;
	}

	public abstract Map<S, T> run() throws IOException, Exception;

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

}
