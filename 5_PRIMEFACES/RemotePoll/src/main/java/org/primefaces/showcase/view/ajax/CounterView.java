/*
 * http://www.primefaces.org/showcase/ui/ajax/poll.xhtml
 */
package org.primefaces.showcase.view.ajax;
 
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
 
@Named
@ViewScoped
public class CounterView implements Serializable {
  
  private int number;

  public int getNumber() {
    return number;
  }

  public void increment() {
    number++;
  }
}
 
