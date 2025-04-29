package net.zhiga.randomstuff.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zhiga.randomstuff.RandomStuff;

public class ModItems {

    // Item initialization zone
    public static final Item PENIS_MUSIC = registerItem("penis_music", new Item(new Item.Settings()));
    public static final Item GITSHIT = registerItem("gitshit", new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                    .alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 20, 42), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 20, 1), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 20, 4), 1.0f)
                    .build()
    )));
    public static final Item FATASS_TETO = registerItem("fatass_teto", new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                    .alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600 *20, 7), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 660 * 20, 3), 1.0f)
                    .build()
    )));




    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RandomStuff.MOD_ID, name), item);
    }

    public static final RegistryKey<ItemGroup> RANDOM_STUFF_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(RandomStuff.MOD_ID, "item_group"));
    public static final ItemGroup RANDOM_STUFF = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FATASS_TETO))
            .displayName(Text.translatable("itemGroup.random_stuff"))
            .build();


    // registring items and pushing into inventory categories
    public static void registerModItems(){

        RandomStuff.LOGGER.info("[RandomStuff] Registering Group for Mod Items");
        Registry.register(Registries.ITEM_GROUP, RANDOM_STUFF_KEY, RANDOM_STUFF);

        RandomStuff.LOGGER.info("[RandomStuff] Registering Mod Items");
        ItemGroupEvents.modifyEntriesEvent(RANDOM_STUFF_KEY).register(entries -> {
            entries.add(PENIS_MUSIC);
            entries.add(FATASS_TETO);
            entries.add(GITSHIT);
        });
    }
}
