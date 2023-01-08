/*
 * http://www.primefaces.org/showcase/ui/panel/toolbar.xhtml
 */
package org.primefaces.showcase.view.panel;
 
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
 
@Named("toolbarView")
@RequestScoped
public class ToolbarView {
     
  public void save() {
    addMessage("Success", "Data saved");
  }

  public void update() {
    addMessage("Success", "Data updated");
  }

  public void delete() {
    addMessage("Success", "Data deleted");
  }

  public void addMessage(String summary, String detail) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
}

