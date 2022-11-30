package blog.matheuscarvalho.multithreadfilereader.model;

import java.util.Objects;

public class Player {

	private String name;

	private String position;

	private String country;

	public Player(String name, String position, String country) {
		this.name = name;
		this.position = position;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getPosition() {
		return position;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Nome do jogador: ").append(this.name).append(" | Posição: ").append(position).append(" | País: ")
				.append(country);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, name, position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(country, other.country) && Objects.equals(name, other.name)
				&& Objects.equals(position, other.position);
	}

}
