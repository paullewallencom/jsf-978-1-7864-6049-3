package beans;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.ConfigurableNavigationHandlerWrapper;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anghel Leonard
 */
public class CustomScopeNavigationHandler extends ConfigurableNavigationHandlerWrapper {

    private static final Logger logger = Logger.getLogger(CustomScopeNavigationHandler.class.getName());
    private final ConfigurableNavigationHandler configurableNavigationHandler;

    public CustomScopeNavigationHandler(ConfigurableNavigationHandler configurableNavigationHandler) {
        this.configurableNavigationHandler = configurableNavigationHandler;
    }

    @Override
    public void handleNavigation(FacesContext context, String fromAction, String outcome) {

        if (outcome != null) {
            if (outcome.equals("sponsored")) {
                logger.log(Level.INFO, "Creating custom scope ...");

                Map<String, Object> applicationMap = context.getExternalContext().getApplicationMap();
                CustomScope customScope = (CustomScope) applicationMap.get(CustomScope.SCOPE);

                if (customScope == null) {
                    customScope = new CustomScope();
                    applicationMap.put(CustomScope.SCOPE, customScope);

                    customScope.scopeCreated(context);
                } else {
                    logger.log(Level.INFO, "Custom scope exists ...");
                }
            } else {
                logger.log(Level.INFO, "Destroying custom scope ...");

                Map<String, Object> applicationMap = context.getExternalContext().getApplicationMap();
                CustomScope customScope = (CustomScope) applicationMap.get(CustomScope.SCOPE);

                if (customScope != null) {
                    customScope.scopeDestroyed(context);
                    applicationMap.remove(CustomScope.SCOPE);
                } else {
                    logger.log(Level.INFO, "Custom scope does not exist ...");
                }
            }
        }

        configurableNavigationHandler.handleNavigation(context, fromAction, outcome);
    }

    @Override
    public ConfigurableNavigationHandler getWrapped() {
        return configurableNavigationHandler;
    }
}
