package net.pm.revanil.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.pm.revanil.Revanil;
import net.pm.revanil.item.RItems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Recipes extends FabricRecipeProvider {
    public Recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    static final Map<Item, Item> GOLD_UPGRADE = new LinkedHashMap<>();
    static final Map<Item, Item> IRON_UPGRADE = new LinkedHashMap<>();
    public static void mapUpgrades() {
        GOLD_UPGRADE.put(Items.WOODEN_AXE, Items.GOLDEN_AXE);
        GOLD_UPGRADE.put(Items.WOODEN_HOE, Items.GOLDEN_HOE);
        GOLD_UPGRADE.put(Items.WOODEN_PICKAXE, Items.GOLDEN_PICKAXE);
        GOLD_UPGRADE.put(Items.WOODEN_SHOVEL, Items.GOLDEN_SHOVEL);
        GOLD_UPGRADE.put(Items.WOODEN_SWORD, Items.GOLDEN_SWORD);
        GOLD_UPGRADE.put(Items.WOODEN_SPEAR, Items.GOLDEN_SPEAR);
        GOLD_UPGRADE.put(Items.LEATHER_HELMET, Items.GOLDEN_HELMET);
        GOLD_UPGRADE.put(Items.LEATHER_CHESTPLATE, Items.GOLDEN_CHESTPLATE);
        GOLD_UPGRADE.put(Items.LEATHER_LEGGINGS, Items.GOLDEN_LEGGINGS);
        GOLD_UPGRADE.put(Items.LEATHER_BOOTS, Items.GOLDEN_BOOTS);
        GOLD_UPGRADE.put(Items.LEATHER_HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR);
        GOLD_UPGRADE.put(Items.NAUTILUS_SHELL, Items.GOLDEN_NAUTILUS_ARMOR);
        IRON_UPGRADE.put(Items.WOODEN_AXE, Items.IRON_AXE);
        IRON_UPGRADE.put(Items.WOODEN_HOE, Items.IRON_HOE);
        IRON_UPGRADE.put(Items.WOODEN_PICKAXE, Items.IRON_PICKAXE);
        IRON_UPGRADE.put(Items.WOODEN_SHOVEL, Items.IRON_SHOVEL);
        IRON_UPGRADE.put(Items.WOODEN_SWORD, Items.IRON_SWORD);
        IRON_UPGRADE.put(Items.WOODEN_SPEAR, Items.IRON_SPEAR);
        IRON_UPGRADE.put(Items.LEATHER_HELMET, Items.IRON_HELMET);
        IRON_UPGRADE.put(Items.LEATHER_CHESTPLATE, Items.IRON_CHESTPLATE);
        IRON_UPGRADE.put(Items.LEATHER_LEGGINGS, Items.IRON_LEGGINGS);
        IRON_UPGRADE.put(Items.LEATHER_BOOTS, Items.IRON_BOOTS);
        IRON_UPGRADE.put(Items.LEATHER_HORSE_ARMOR, Items.IRON_HORSE_ARMOR);
        IRON_UPGRADE.put(Items.NAUTILUS_SHELL, Items.IRON_NAUTILUS_ARMOR);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                //Upgrade template recipes
                genUpgradeTemplate(RItems.IRON_UPGRADE_TEMPLATE, Items.IRON_INGOT, Blocks.IRON_BLOCK.asItem(), Items.LEATHER);
                genUpgradeTemplate(RItems.GOLD_UPGRADE_TEMPLATE, Items.GOLD_INGOT, Blocks.GOLD_BLOCK.asItem(), Items.LEATHER);

                //Upgrade template usages & new recycling
                mapUpgrades();
                genSmithing(RItems.IRON_UPGRADE_TEMPLATE, IRON_UPGRADE, net.minecraft.registry.tag.ItemTags.IRON_TOOL_MATERIALS, Items.IRON_INGOT);
                genSmithing(RItems.GOLD_UPGRADE_TEMPLATE, GOLD_UPGRADE, net.minecraft.registry.tag.ItemTags.GOLD_TOOL_MATERIALS, Items.GOLD_INGOT);

                //Chainmail Armor
                createShaped(RecipeCategory.TOOLS, Items.CHAINMAIL_HELMET)
                        .pattern("###")
                        .pattern("# #")
                        .input('#', Items.IRON_CHAIN)
                        .criterion("has_material", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.TOOLS, Items.CHAINMAIL_CHESTPLATE)
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .input('#', Items.IRON_CHAIN)
                        .criterion("has_material", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.TOOLS, Items.CHAINMAIL_LEGGINGS)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', Items.IRON_CHAIN)
                        .criterion("has_material", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.TOOLS, Items.CHAINMAIL_BOOTS)
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', Items.IRON_CHAIN)
                        .criterion("has_material", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);
            }

            public void genUpgradeTemplate(Item template, Item material, Item core, Item other) {
                createShaped(RecipeCategory.TOOLS, template)
                        .pattern("OMO")
                        .pattern("MXM")
                        .pattern("OMO")
                        .input('O', other)
                        .input('M', material)
                        .input('X', core)
                        .group(Registries.ITEM.getId(template.asItem()).toString())
                        .criterion("has_material", conditionsFromItem(material))
                        .offerTo(recipeExporter, getRecipeName(template)+"_core");
                createShaped(RecipeCategory.TOOLS, template, 2)
                        .pattern("OMO")
                        .pattern("MXM")
                        .pattern("OMO")
                        .input('O', other)
                        .input('M', material)
                        .input('X', template)
                        .group(Registries.ITEM.getId(template.asItem()).toString())
                        .criterion("has_material", conditionsFromItem(material))
                        .offerTo(recipeExporter, getRecipeName(template)+"_duplication");
            }

            public void genSmithing(Item template, Map<Item, Item> upgrades, TagKey<Item> material) {
                //Create the smithing recipe for each item.
                for (Item key : upgrades.keySet()) {
                    SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItem(template), Ingredient.ofItem(key), ingredientFromTag(material), RecipeCategory.TOOLS, upgrades.get(key))
                            .criterion("has_template", conditionsFromItem(template))
                            .offerTo(recipeExporter, getRecipeName(upgrades.get(key))+"_smithing");
                }
            }

            public void genSmithing(Item template, Map<Item, Item> upgrades, TagKey<Item> material, Item matRep) {
                genSmithing(template, upgrades, material);

                //Reducing back to material
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(upgrades.values().stream()), RecipeCategory.MISC, matRep, 0.5f, 200)
                        .criterion("has_material", conditionsFromItem(template))
                        .offerTo(recipeExporter, getRecipeName(matRep)+"_reduction_from_smelting");
                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(upgrades.values().stream()), RecipeCategory.MISC, matRep, 0.5f, 100)
                        .criterion("has_material", conditionsFromItem(template))
                        .offerTo(recipeExporter, getRecipeName(matRep)+"_reduction_from_blasting");
            }
        };
    }

    @Override
    public String getName() {
        return Revanil.MOD_ID;
    }
}
