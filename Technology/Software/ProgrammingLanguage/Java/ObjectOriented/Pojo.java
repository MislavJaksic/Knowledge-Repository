import java.util.Objects;

public class Pojo {
	public Integer before;
	public String ip;
	public Integer after;

	public Pojo() {

	}

	@Override
	public boolean equals(Object o) {
		// self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    Pojo ip_message = (Pojo) o;
	    // field comparison
	    return Objects.equals(this.before, ip_message.before)
	            && Objects.equals(this.ip, ip_message.ip)
	            && Objects.equals(this.after, ip_message.after);
	}
}
