package net.pm.revanil.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.*;

@Mixin(JsonDataLoader.class)
public class JsonDataLoaderMixin {
    @Unique
    private static LinkedHashSet<Identifier> banned = new LinkedHashSet<>();

    static {
        banRecipe("golden_axe");
        banRecipe("golden_hoe");
        banRecipe("golden_pickaxe");
        banRecipe("golden_shovel");
        banRecipe("golden_sword");
        banRecipe("golden_spear");
        banRecipe("golden_helmet");
        banRecipe("golden_chestplate");
        banRecipe("golden_leggings");
        banRecipe("golden_boots");
        banRecipe("golden_horse_armor");
        banRecipe("iron_axe");
        banRecipe("iron_hoe");
        banRecipe("iron_pickaxe");
        banRecipe("iron_shovel");
        banRecipe("iron_sword");
        banRecipe("iron_spear");
        banRecipe("iron_helmet");
        banRecipe("iron_chestplate");
        banRecipe("iron_leggings");
        banRecipe("iron_boots");
        banRecipe("iron_horse_armor");
        banRecipe("iron_nugget_from_smelting");
        banRecipe("iron_nugget_from_blasting");
        banRecipe("gold_nugget_from_smelting");
        banRecipe("gold_nugget_from_blasting");
    }

    @Unique
    private static void banRecipe(String name) {
        banRecipe("minecraft", name);
    }
    @Unique
    private static void banRecipe(String namespace, String name) {
        banned.add(Identifier.of(namespace, "recipe/" + name + ".json"));
    }

    @WrapOperation(method = "load(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/resource/ResourceFinder;Lcom/mojang/serialization/DynamicOps;Lcom/mojang/serialization/Codec;Ljava/util/Map;)V", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;next()Ljava/lang/Object;"))
    private static <E> E revanil$makeSkip(Iterator<E> instance, Operation<E> original) {
        E next = original.call(instance);
        while (banned.contains(((Map.Entry<Identifier, Resource>) next).getKey())) {
            //FIXME: If the next element is the last element that will probably cause issues.
            next = instance.next();
        }
        return next;
    }
}
