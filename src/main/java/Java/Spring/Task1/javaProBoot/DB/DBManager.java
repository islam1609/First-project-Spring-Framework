package Java.Spring.Task1.javaProBoot.DB;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Item> Items = new ArrayList<Item>();
    private static Long id = 7l;

    static{
        Items.add(new Item(1L,"MacBook2020",450000,"8GB RAM 256GB SSD INTEL CORE i7"));
        Items.add(new Item(2L,"MacBook2021",850000,"16GB RAM 512GB SSD M1"));
        Items.add(new Item(3L,"MacBook2021 Pro",1000000,"16GB RAM 512GB SSD M1 PRO"));
        Items.add(new Item(4L,"Lenovo Legion",520000,"16GB RAM 1TB SSD INTEL CORE i9"));
        Items.add(new Item(5L,"Lenovo Legion",820000,"32GB RAM 1TB SSD INTEL CORE i11"));
        Items.add(new Item(6L,"iPhone 13Pro Max",620000,"512 GB Memory 8GB RAM"));
    }
    public static ArrayList<Item> getAllItems(){
        return Items;
    }

    public static Item getItem(Long id){
        return Items.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
    }
    public static void addItem(Item item){
        item.setId(id);
        Items.add(item);
        id++;
    }
}
