package com.belgieyt.morefeatures;

import com.belgieyt.morefeatures.blocks.GardeningTableBlock;
import com.belgieyt.morefeatures.entities.*;
import com.belgieyt.morefeatures.init.*;
import com.belgieyt.morefeatures.util.MoBConfig;
import com.belgieyt.morefeatures.world.gen.ModFeatureGen;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(MoreFeatures.MOD_ID)
public class MoreFeatures {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "morefeatures";



    public MoreFeatures() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        GardeningTableBlock.init();

        SoundInit.SOUNDS.register(bus);
        PotionInit.POTIONS.register(bus);
        PotionInit.POTION.register(bus);
        EnchantmentInit.ENCHANTMENT.register(bus);
        ItemInit.ITEMS.register(bus);
        RecipeSerializerInit.RECIPE_SERIALIZERS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(bus);
        ModContainerTypes.CONTAINER_TYPES.register(bus);
        ModEntityTypes.ENTITY_TYPES.register(bus);





        MinecraftForge.EVENT_BUS.register(this);
        MoBConfig.loadConfig(MoBConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("mofeatures-common.toml"));

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {

            ModFeatureGen.ores();
        });
    }

        private void clientRegistries(final FMLClientSetupEvent event) {
            LOGGER.info("clientRegistries method registered");
            DeferredWorkQueue.runLater(() -> {

                GlobalEntityTypeAttributes.put(ModEntityTypes.strawberrycow.get(), StrawberryCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.lemoncow.get(), LemonCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.blueberrycow.get(), LemonCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.berrycow.get(), BerryCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.pumpkincow.get(), PumpkinCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.meloncow.get(), MelonCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.kiwicow.get(), KiwiCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.blackberrycow.get(), BlackberryCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.peachcow.get(), PeachCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.mangocow.get(), MangoCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.devilcow.get(), DevilCowEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.jollyllama.get(), JollyLlamaEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.bonespider.get(), BoneSpiderEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.jumborabbit.get(), JumboRabbitEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.bonedog.get(), BoneDogEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.redtoadstool.get(), RedToadStoolEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.browntoadstool.get(), BrownToadStoolEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.mushroomboss.get(), MushroomBossEntity.setCustomAttributes().create());
                GlobalEntityTypeAttributes.put(ModEntityTypes.endblaze.get(), EndBlazeEntity.setCustomAttributes().create());

            });

        }



    public static class MoreFeaturesItemGroup extends ItemGroup {
        public static final MoreFeaturesItemGroup BLOCKS = new MoreFeaturesItemGroup(ItemGroup.GROUPS.length, "morefeaturestab");

        private MoreFeaturesItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.BLACK_PLANKS.get());
        }
    }

    public static class MoreFeaturesItemGroup2 extends ItemGroup
    {
        public static final MoreFeaturesItemGroup2 ITEMS = new MoreFeaturesItemGroup2(ItemGroup.GROUPS.length, "morefeaturestab2");
        private MoreFeaturesItemGroup2(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.MOLTEN.get());
        }

        }
    public static class MoreFeaturesItemGroup3 extends ItemGroup
    {
        public static final MoreFeaturesItemGroup3 TOOLS = new MoreFeaturesItemGroup3(ItemGroup.GROUPS.length, "morefeaturestab3");
        private MoreFeaturesItemGroup3(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.DIAMOND_KARAMBIT.get());
        }
    }
    public static class MoreFeaturesItemGroup4 extends ItemGroup
    {
        public static final MoreFeaturesItemGroup4 SPAWN_EGGS = new MoreFeaturesItemGroup4(ItemGroup.GROUPS.length, "morefeaturestab4");
        private MoreFeaturesItemGroup4(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.STRAWBERRYCOW_SPAWN_EGG.get());
        }
    }
    public static class MoreFeaturesItemGroup5 extends ItemGroup
    {
        public static final MoreFeaturesItemGroup5 VEG = new MoreFeaturesItemGroup5(ItemGroup.GROUPS.length, "morefeaturestab5");
        private MoreFeaturesItemGroup5(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.BLACK_ROSE_BUSH.get().asItem());
        }
    }
    public static ResourceLocation loc(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}



