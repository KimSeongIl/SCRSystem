package scr.util;



public class DefaultContext {

	private static DefaultContext instance;

    public static void createInstance(String path) {
        instance = new DefaultContext(path);
    }

    public static DefaultContext getInstance() {
        if (instance == null) {
            throw new NullPointerException("not yet");
        } else
            return instance;
    }

    final String baseDir;

    private DefaultContext(String path) {
        baseDir = path;
    }

    public String getPath() {
        return baseDir;
    }
}
