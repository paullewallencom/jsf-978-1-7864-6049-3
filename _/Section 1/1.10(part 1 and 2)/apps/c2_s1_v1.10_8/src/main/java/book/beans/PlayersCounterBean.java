package book.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@ApplicationScoped
public class PlayersCounterBean {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void addPlayer() {
        count++;
    }
}
