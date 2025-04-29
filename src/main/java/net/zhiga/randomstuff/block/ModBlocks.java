package net.zhiga.randomstuff.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zhiga.randomstuff.RandomStuff;

import static net.zhiga.randomstuff.Item.ModItems.RANDOM_STUFF_KEY;

public class ModBlocks {

    public static final Block PENIS_MUSIC_BLOCK = registerBlock("penis_music_block",
            new Block(AbstractBlock.Settings.create().strength(2f).velocityMultiplier(2f).jumpVelocityMultiplier(5f)));


    private static Block registerBlock(String name, Block block){
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RandomStuff.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(RandomStuff.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlock (){
        RandomStuff.LOGGER.info("[RandomStuff] Registering Mod Blocks");

        ItemGroupEvents.modifyEntriesEvent(RANDOM_STUFF_KEY).register(entries -> {
            entries.add(PENIS_MUSIC_BLOCK);
        });
    }
}
