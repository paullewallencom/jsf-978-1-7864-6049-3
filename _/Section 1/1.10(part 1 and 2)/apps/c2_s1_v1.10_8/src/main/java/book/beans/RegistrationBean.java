package book.beans;

import java.io.Serializable;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@FlowScoped(value = "registration")
public class RegistrationBean implements Serializable {

    @Inject
    private PlayersCounterBean playersCounterBean;
    private String playerName;
    private String playerSurname;
    private String tournamentName;
    private String tournamentPlace;

    public String getTournamentName() {
        return tournamentName;
    }

    public String getTournamentPlace() {
        return tournamentPlace;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }

    public String getReturnValue() {
        return "/done";
    }

    //initializer method
    public void tournamentInitialize(String tn, String tp) {
        this.tournamentName = tn;
        this.tournamentPlace = tp;
    }

    //finalizer method
    public void tournamentFinalize() {
        playersCounterBean.addPlayer();
    }

    public String registrationAction() {

        //simulate some registration conditions
        Random r = new Random();
        int nr = r.nextInt(10);

        if (nr < 5) {
            playerName = "";
            playerSurname = "";
            FacesContext.getCurrentInstance().addMessage("password", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failed!", ""));
            return "registration";
        } else {
            return "confirm-switch-id";
        }
    }
}
