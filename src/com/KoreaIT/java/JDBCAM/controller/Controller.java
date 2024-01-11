import com.KoreaIT.java.JDBCAM.dto.Member;

public abstract class Controller {

	protected static Member loginedMember = null;

	public abstract void doAction(String actionMethodName, String cmd);

	public static boolean isLogined() {
		return loginedMember != null;
	}
}