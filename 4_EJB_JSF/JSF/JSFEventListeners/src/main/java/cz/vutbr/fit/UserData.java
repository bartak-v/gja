package cz.vutbr.fit;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * SessionScoped UserData bean, which holds data about first and second user
 * country. The data are manipulated by comboboxes and button in home.xhtml
 */
@Named("userData")
@SessionScoped
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Map<String, String> countryMap;
    public static final String DEFAULT_LOCALE = "United Kingdom";

    // 2 countries so this example can show more approaches to event listening 
    private String selectedCountry = DEFAULT_LOCALE;
    private String secondCountry = DEFAULT_LOCALE;

    static {
        countryMap = new LinkedHashMap<>();
        countryMap.put("en", "United Kingdom"); // locale, country name
        countryMap.put("cs", "Czech Republic");
        countryMap.put("fr", "France");
        countryMap.put("de", "Germany");
    }

    /**
     * Method directly called by <h:selectOneMenu/> element, configured in
     * valueChangeListener attribute
     *
     * @param e
     */
    public void localeChanged(ValueChangeEvent e) {
        //assign new value to country
        selectedCountry = e.getNewValue().toString();
    }

    /**
     * Method called by <f:event/> element in home.xhtml
     * @param event
     */
    public void preRenderView(ComponentSystemEvent event) {
        System.out.println("pre render event fired");
    }

    /**
     *
     * @return possible countries
     */
    public Map<String, String> getCountries() {
        return countryMap;
    }

    /**
     *
     * @return selected country
     */
    public String getSelectedCountry() {
        return selectedCountry;
    }

    /**
     *
     * @param selectedCountry
     */
    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    /**
     *
     * @return secondCountry
     */
    public String getSecondCountry() {
        return secondCountry;
    }

    /**
     *
     * @param selectedCountry
     */
    public void setSecondCountry(String selectedCountry) {
        this.secondCountry = selectedCountry;
    }
}
