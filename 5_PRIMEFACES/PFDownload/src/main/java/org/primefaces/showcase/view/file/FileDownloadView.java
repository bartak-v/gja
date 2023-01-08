/*
 * Adapted from: http://www.primefaces.org/showcase/ui/file/download.xhtml
 */
package org.primefaces.showcase.view.file;
 
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@Named
@RequestScoped
public class FileDownloadView {

  private StreamedContent file;

  public FileDownloadView() {
    file = DefaultStreamedContent.builder()
           .name("downloaded_optimus.jpg")
           .contentType("image/jpg")
           .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/optimus.jpg"))
           .build();
  }

  public StreamedContent getFile() {
    return file;
  }
}
