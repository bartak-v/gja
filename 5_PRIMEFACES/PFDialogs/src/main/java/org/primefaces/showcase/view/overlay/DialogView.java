/*
 * http://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml
 */
package org.primefaces.showcase.view.overlay;
 
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
 
@Named
@RequestScoped
public class DialogView {

  private String name;

  public void destroyWorld() {
    addMessage("System Error", "Please try again later.");
  }

  public void addMessage(String summary, String detail) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
