package Java.Spring.Task1.javaProBoot.DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    Long id;
    String name;
    int price;
    String description;
}
