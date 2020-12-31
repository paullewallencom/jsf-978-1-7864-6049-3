package beans;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Anghel Leonard
 */
public class DestroyCustomScope implements ActionListener {

    private static final Logger LOG = Logger.getLogger(DestroyCustomScope.class.getName());

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {

        LOG.log(Level.INFO, "Destroying custom scope ...");

        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> applicationMap = context.getExternalContext().getApplicationMap();
        CustomScope customScope = (CustomScope) applicationMap.get(CustomScope.SCOPE);

        if (customScope != null) {
            customScope.scopeDestroyed(context);
            applicationMap.remove(CustomScope.SCOPE);
        } else {
            LOG.log(Level.INFO, "Custom scope does not exists ...");
        }
    }
}
