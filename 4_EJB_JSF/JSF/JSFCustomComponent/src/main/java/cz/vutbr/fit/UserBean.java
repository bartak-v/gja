package cz.vutbr.fit;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * SessionScoped UserData bean, which holds "login data" for the user. country.
 * The data are manipulated by custom component, which is a registration form.
 */
@Named("user")
@SessionScoped
public class UserBean implements Serializable {

    private String name;
    private String email;

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return "result", used for page navigation to result.xhtml
     */
    public String registerAction() {
        return "result";
    }
}
