package Java.Spring.Task1.javaProBoot.Controllers;

import Java.Spring.Task1.javaProBoot.DB.DBManager;
import Java.Spring.Task1.javaProBoot.DB.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Item> items = DBManager.getAllItems();
        model.addAttribute("tovary",items);
        return "homePage";
    }
    @GetMapping(value = "/details/{itemId}")
    public String detailsPage(@PathVariable(name = "itemId") Long id,
                              Model model){
        Item item = DBManager.getItem(id);
        model.addAttribute("tovar",item);
        return "details";
    }


    @GetMapping(value = "/addItem")
    public String addItem(){
        return "addItem";
    }

    @PostMapping(value = "/addItem")
    public String addItem(@RequestParam(name = "itemName") String name,
                          @RequestParam(name = "itemPrice") int price,
                          @RequestParam(name = "itemDescription") String description){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setDescription(description);

        DBManager.addItem(item);

        return "redirect:/";
    }

}
