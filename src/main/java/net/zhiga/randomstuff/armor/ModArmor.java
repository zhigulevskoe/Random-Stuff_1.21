package net.zhiga.randomstuff.armor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.zhiga.randomstuff.Item.ModItems;
import net.zhiga.randomstuff.RandomStuff;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmor {

    public static final RegistryEntry<ArmorMaterial> FATASS = registerMaterial("fatass",
            Map.of(ArmorItem.Type.HELMET, 3),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
            () -> Ingredient.ofItems(ModItems.PENIS_MUSIC),
            0.0F,
            0.0F,
            false);

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(
                // The ID of the texture layer, the suffix, and whether the layer is dyeable.
                // We can just pass the armor material ID as the texture layer ID.
                // We have no need for a suffix, so we'll pass an empty string.
                // We'll pass the dyeable boolean we received as the dyeable parameter.
                new ArmorMaterial.Layer(Identifier.of(RandomStuff.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(RandomStuff.MOD_ID, id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return RegistryEntry.of(material);
    }


    public static void registerModArmor(){
        RandomStuff.LOGGER.info("[RandomStuff] Registering Mod Armor");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

        });
    }
}
