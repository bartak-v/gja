# JSF Examples

## JSFPageNavigation

- Showcase of types of navigations between pages that can be used in JSF.  There are navigation rules in *faces-config.xml*, usage of commandLinks and commandButtons. Also a difference between redirection and forwarding. All the necessary information can be found in comments in source code.
- application runs at http://localhost:8080/JSFPageNavigation

## JSFEventListeners

- Showing some basic events and listeners in JSF. There is:
   - ActionListener which is called on button click
   - SystemListener which listens on application start and stop
   - ValueChangeListener which listens on second *selectOneMenu* element in *homepage.xhtml*. There is also shown a direct method call in first *selectOneMenu* element.
- The listeners (except SystemListener) change values in UserData bean.
- application runs at http://localhost:8080/JSFEventListeners

## JSFCustomComponent

- Creation of custom register component in JSF. Take a look at *register.xml* and see its usage in *default.xhtml*.
- The new component is configured via defined attributes like *<composite:attribute name="emailLabel" />*, which must be provided when you want to use the new component. Then its implementation is rendered.
- application runs at http://localhost:8080/JSFCustomComponent

## JSFAjax

- in *home.xml* is shown a usage of ajax to change *UserData* bean attribute *name*. After the Ajax call is processed, the *outputText* element is rerendered ( defined in *render="outputMessage"* attribute in *f:ajax* element).
- application runs at http://localhost:8080/JSFAjax
