/*
 * Adapted from: http://www.primefaces.org/showcase/push/chat.xhtml
 */
package org.primefaces.showcase.push.chat;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ApplicationScoped;
import jakarta.faces.bean.ManagedBean;
 
@ManagedBean
@ApplicationScoped
public class ChatUsers implements Serializable {
  
  private List<String> users;

  @PostConstruct
  public void init() {
    users = new ArrayList<String>();
  }

  public List<String> getUsers() {
    return users;
  }

  public void remove(String user) {
    this.users.remove(user);
  }

  public void add(String user) {
    this.users.add(user);
  }

  public boolean contains(String user) {
    return this.users.contains(user);
  }
}
