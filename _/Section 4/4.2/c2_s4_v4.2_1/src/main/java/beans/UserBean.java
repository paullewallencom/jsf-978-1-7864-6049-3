package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class UserBean {

    private static final Logger logger = Logger.getLogger(UserBean.class.getName());

    public String welcomeUser() {
        logger.log(Level.INFO, "welcomeUser method called ...");
        return "success?user=Holly Uim";
    }

}
