/*
 * http://www.primefaces.org/showcase/ui/panel/wizard.xhtml
 */
package org.primefaces.showcase.view.panel;
 
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;
import org.primefaces.showcase.domain.User;
 
@Named
@ViewScoped
public class UserWizard implements Serializable {
 
  private User user = new User();

  private boolean skip;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void save() {
    FacesMessage msg = new FacesMessage("Successful", 
                                        "Welcome " + user.getFirstname());
    FacesContext.getCurrentInstance().addMessage(null, msg);
  }

  public boolean isSkip() {
    return skip;
  }

  public void setSkip(boolean skip) {
    this.skip = skip;
  }

  public String onFlowProcess(FlowEvent event) {
    if (skip) {
      skip = false;  // reset in case user goes back
      return "confirm";
    } else {
      return event.getNewStep();
    }
  }
}
