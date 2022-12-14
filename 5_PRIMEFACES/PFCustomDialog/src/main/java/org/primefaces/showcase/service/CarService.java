/*
 * Copyright 2009-2013 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.showcase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.primefaces.showcase.domain.Car;

@Named
@ApplicationScoped
public class CarService {

  private final static String[] colors;

  private final static String[] brands;

  static {
    colors = new String[10];
    colors[0] = "Black";
    colors[1] = "White";
    colors[2] = "Green";
    colors[3] = "Red";
    colors[4] = "Blue";
    colors[5] = "Orange";
    colors[6] = "Silver";
    colors[7] = "Yellow";
    colors[8] = "Brown";
    colors[9] = "Maroon";

    brands = new String[10];
    brands[0] = "Mercedes";
    brands[1] = "BMW";
    brands[2] = "Volvo";
    brands[3] = "Audi";
    brands[4] = "Renault";
    brands[5] = "Opel";
    brands[6] = "Volkswagen";
    brands[7] = "Chrysler";
    brands[8] = "Ferrari";
    brands[9] = "Ford";
  }

  public List<Car> populateCars(int size) {
    List<Car> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add(new Car(i, getRandomYear(), getRandomBrand(), getRandomColor()));
    }

    return list;
  }

  private String getRandomVin() {
    return UUID.randomUUID().toString().substring(0, 8);
  }

  private int getRandomYear() {
    return (int) (Math.random() * 50 + 1960);
  }

  private String getRandomColor() {
    return colors[(int) (Math.random() * 10)];
  }

  private String getRandomBrand() {
    return brands[(int) (Math.random() * 10)];
  }
}
