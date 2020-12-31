package beans;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.ConfigurableNavigationHandlerWrapper;
import javax.faces.context.FacesContext;

/**
 *
 * @author Anghel Leonard
 */
public class CustomNavigationHandler extends ConfigurableNavigationHandlerWrapper {

    private ConfigurableNavigationHandler configurableNavigationHandler;

    public CustomNavigationHandler() {
    }

    public CustomNavigationHandler(ConfigurableNavigationHandler configurableNavigationHandler) {
        this.configurableNavigationHandler = configurableNavigationHandler;
    }

    @Override
    public void handleNavigation(FacesContext context, String fromAction, String outcome) {

        if (outcome.equals("confirm_outcome")) {
            outcome = "confirm";
        }

        getWrapped().handleNavigation(context, fromAction, outcome);
    }

    @Override
    public ConfigurableNavigationHandler getWrapped() {
        return configurableNavigationHandler;
    }
}
