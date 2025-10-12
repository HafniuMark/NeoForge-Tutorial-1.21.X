package net.kaupenjoe.tutorialmod.item;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.entity.ModEntities;
import net.kaupenjoe.tutorialmod.item.custom.*;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.registerItem("bismuth",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.registerItem("raw_bismuth",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHISEL = ITEMS.registerItem("chisel",
            ChiselItem::new, new Item.Properties().durability(32));

    public static final DeferredItem<Item> RADISH = ITEMS.registerItem("radish",
            (properties) -> new Item(properties.food(ModFoodProperties.RADISH, ModFoodProperties.RADISH_EFFECT)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, TooltipDisplay tooltipDisplay, Consumer<Component> components, TooltipFlag tooltipFlag) {
                    components.accept(Component.translatable("tooltip.tutorialmod.radish.tooltip"));
                    super.appendHoverText(pStack, pContext, tooltipDisplay, components, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.registerItem("frostfire_ice",
            (properties) -> new FuelItem(properties, 800));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.registerItem("starlight_ashes",
            Item::new);

    public static final DeferredItem<Item> BISMUTH_SWORD = ITEMS.registerItem("bismuth_sword",
            (properties) -> new Item(properties.sword(ModToolTiers.BISMUTH, 5, -2.4f)));
    public static final DeferredItem<Item> BISMUTH_PICKAXE = ITEMS.registerItem("bismuth_pickaxe",
            (properties) -> new Item(properties.pickaxe(ModToolTiers.BISMUTH, 1.0F, -2.8f)));
    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.registerItem("bismuth_shovel",
            (properties) -> new ShovelItem(ModToolTiers.BISMUTH, 1.5F, -3.0f, properties));
    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.registerItem("bismuth_axe",
            (properties) -> new AxeItem(ModToolTiers.BISMUTH, 6.0F, -3.2f, properties));
    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.registerItem("bismuth_hoe",
            (properties) -> new HoeItem(ModToolTiers.BISMUTH, 0F, -3.0f, properties));

    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.registerItem("bismuth_hammer",
            (properties) -> new HammerItem(properties.pickaxe(ModToolTiers.BISMUTH, 7F, -3.5f)));

    public static final DeferredItem<Item> BISMUTH_HELMET = ITEMS.registerItem("bismuth_helmet",
            (properties) -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> BISMUTH_CHESTPLATE = ITEMS.registerItem("bismuth_chestplate",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> BISMUTH_LEGGINGS = ITEMS.registerItem("bismuth_leggings",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> BISMUTH_BOOTS = ITEMS.registerItem("bismuth_boots",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final DeferredItem<Item> BISMUTH_HORSE_ARMOR = ITEMS.registerItem("bismuth_horse_armor",
            (properties) -> new Item( properties.stacksTo(1).horseArmor(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> KAUPEN_SMITHING_TEMPLATE = ITEMS.registerItem("kaupen_armor_trim_smithing_template",
            SmithingTemplateItem::createArmorTrimTemplate);

    public static final DeferredItem<Item> KAUPEN_BOW = ITEMS.registerItem("kaupen_bow",
            (properties) -> new BowItem(properties.durability(500)));

    public static final DeferredItem<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.registerItem("bar_brawl_music_disc",
            (properties) -> new Item(properties.jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> RADISH_SEEDS = ITEMS.registerItem("radish_seeds",
            (properties) -> new BlockItem(ModBlocks.RADISH_CROP.get(), properties));
    public static final DeferredItem<Item> GOJI_BERRIES = ITEMS.registerItem("goji_berries",
            (properties) -> new BlockItem(ModBlocks.GOJI_BERRY_BUSH.get(), properties.food(ModFoodProperties.GOJI_BERRY)));

    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.registerItem("gecko_spawn_egg",
            (properties) -> new SpawnEggItem(properties.spawnEgg(ModEntities.GECKO.get())));

    public static final DeferredItem<Item> TOMAHAWK = ITEMS.registerItem("tomahawk",
            (properties) -> new TomahawkItem(properties.stacksTo(16)));

    public static final DeferredItem<Item> RADIATION_STAFF = ITEMS.registerItem("radiation_staff",
            (properties) -> new Item(properties.stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
