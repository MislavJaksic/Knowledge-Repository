import java.util.Objects;

public class PlainOldJavaObject {
	public Integer before;
	public String middle;
	public Integer after;

	public PlainOldJavaObject() {

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
	    PlainOldJavaObject pojo = (PlainOldJavaObject) o;
	    // field comparison
	    return Objects.equals(this.before, pojo.before)
	            && Objects.equals(this.middle, pojo.middle)
	            && Objects.equals(this.after, pojo.after);
	}
}
