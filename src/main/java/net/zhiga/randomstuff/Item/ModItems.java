package net.zhiga.randomstuff.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zhiga.randomstuff.RandomStuff;

public class ModItems {

    public static final Item PENIS_MUSIC = registerItem("penis_music", new Item(new Item.Settings()));
    public static final Item EXAMPLE_ITEM = registerItem("example_item", new Item(new Item.Settings()));
    public static final Item FATASS_TETO = registerItem("fatass_teto", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RandomStuff.MOD_ID, name), item);
    }

    public static void registerModItems(){
        RandomStuff.LOGGER.info("Registering ModItems");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(PENIS_MUSIC);
            entries.add(EXAMPLE_ITEM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.HOTBAR).register(entries -> {
            entries.add(FATASS_TETO);
        });
    }
}
