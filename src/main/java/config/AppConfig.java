package config;


import javax.ws.rs.core.Application;
import java.util.Map;
import java.util.Set;

/**
 * Created by ww on 21.08.2017.
 */
public class AppConfig extends Application {
    @Override
    public Set<Object> getSingletons() {
        return super.getSingletons();
    }

    @Override
    public Map<String, Object> getProperties() {
        return super.getProperties();
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
