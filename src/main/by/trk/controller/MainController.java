package main.by.trk.controller;


import main.by.trk.domain.CreditCard;
import main.by.trk.domain.Person;
import main.by.trk.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/main")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "personService")
    private PersonService personService;

    public MainController() {
    }



    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersons(Model model){
        logger.debug("recieving request to show all persons");
        List<Person> persons = personService.getAll();
        model.addAttribute("persons",persons);
        return "personpage";
    }
    @RequestMapping(value = "/persons/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        logger.debug("recieving request to show add page");
        model.addAttribute("personAttribute",new Person());
        return "addpage";
    }
    @RequestMapping(value = "/persons/add",method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") Person person){
        logger.debug("recieving reqouest to add new person");
        personService.add(person);
        return "addedpage";
    }
    @RequestMapping(value = "/persons/delete",method = RequestMethod.GET)
    public String delete(@RequestParam(value="id",required = true) Integer id, Model model){
        logger.debug("receiving request to delete existing person");
        personService.delete(id);
        model.addAttribute("id",id);
        return "deletedpage";
    }
    @RequestMapping(value = "/persons/edit",method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id",required = true) Integer id, Model model){
        logger.debug("recieving request to show edit page");
        model.addAttribute("personAttribute",personService.get(id));
        return "editpage";
    }
     @RequestMapping(value = "/persons/edit",method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person, @RequestParam(value = "id",required = true) Integer id,
                           Model model){
        logger.debug("received request to update person");
        person.setPersonId(id);
        personService.edit(person);
        model.addAttribute("id",id);
        return "editedpage";
    }
    @RequestMapping(value = "/persons/info/{personId}",method = RequestMethod.GET)
    public String getInfo(@PathVariable(value = "personId")Integer id, Model model){
        logger.debug("receiving request to show info page");
        model.addAttribute("personAttribute",personService.get(id));
        return "infopage";
    }
   @RequestMapping(value = "/persons/{personId}/addcard",method = RequestMethod.GET)
    public String getAddCard(Model model,@PathVariable(value = "personId") Integer id){
        logger.debug("adding new card to person");
        model.addAttribute("cardAttribute",new CreditCard());

        return "addcardpage";
    }
    @RequestMapping(value = "/persons/{personId}/addcard",method = RequestMethod.POST)
    public String addCard(Model model,@ModelAttribute("cardAttribute") CreditCard card,@PathVariable("personId") Integer id) {
        logger.debug("recieving request to add new card to person");
        Person person = personService.get(id);
        person.getCreditCards().add(card);
        personService.edit(person);
        return "addedcardpage";
    }
}
