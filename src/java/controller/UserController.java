
package controller;

import model.dao.UserDAO;
import model.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author igor
 */

@Controller
@RequestMapping(value = "/user")
public class UserController { 
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute (value = "user") User user){
        UserDAO dao = new UserDAO();
        dao.create(user);
        return "redirect:all.htm";
    }
    
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam (value = "id") int id, Model m){
        UserDAO dao = new UserDAO();
        User user = dao.getById(id);
        m.addAttribute("user", user);
        return "edit";
    }
    

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute (value = "user") User user){
        UserDAO dao = new UserDAO();
        dao.update(user);
        return "redirect:all.htm";
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.GET)   
    public String remove(@RequestParam (value = "id") int id){
        UserDAO dao = new UserDAO();
        dao.remove(id);
        return "redirect:all.htm";
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(Model m){
        UserDAO model = new UserDAO();
        m.addAttribute("lst", model.readAll());
        return "index";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchByNameOrEmail(@RequestParam( value = "regEx") String regEx, 
            Model m){
        UserDAO dao = new UserDAO();
        m.addAttribute("lst", dao.searchByNameOrEmail(regEx));
        return "index";
    }
    
    @RequestMapping(value = "/redirectCreate", method = RequestMethod.GET)
    public String redirectCreate(){
        return "create";
    }
    
    @RequestMapping(value = "/redirectToListing", method = RequestMethod.GET)
    public String redirectToListing(){
        return "redirect:all.htm";
    }
  
}
