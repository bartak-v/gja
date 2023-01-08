/*
 * Adapted from: http://www.primefaces.org/showcase/ui/data/datatable/basic.xhtml
 */
package org.primefaces.showcase.view.data.datatable;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.showcase.domain.Car;
import org.primefaces.showcase.service.CarService;
 
@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
    
  private List<Car> cars;

  @Inject
  private CarService service;

  @PostConstruct
  public void init() {
    cars = service.createCars(10);
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setService(CarService service) {
    this.service = service;
  }
}
