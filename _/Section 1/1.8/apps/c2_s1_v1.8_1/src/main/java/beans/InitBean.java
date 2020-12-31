package beans;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

/**
 *
 * @author Anghel Leonard
 */
@ManagedBean
@NoneScoped
public class InitBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(InitBean.class.getName());

    private int init;

    public InitBean() {
        LOG.info("InitBean#Constructor invoked ...");
        init = new Random().nextInt(100);
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }
}
