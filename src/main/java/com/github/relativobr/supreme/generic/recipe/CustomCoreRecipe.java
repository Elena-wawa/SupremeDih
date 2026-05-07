package com.github.relativobr.supreme.generic.recipe;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.inventory.ItemStack;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CustomCoreRecipe {

  private SlimefunItemStack material;
  private String name;

  // why did we hardcode the recipe ingredients as bukkit materials
  // this is so unbelievably stupid
  //index 0,1,2
  private ItemStack mainItem;
  //index 3,4,5
  private ItemStack secondItem;
  //index 6,7,8
  private ItemStack lastItem;


  public CustomCoreRecipe(SlimefunItemStack material, ItemStack mainItem) {
    this.material = material;
    this.name = material.getItemId();
    this.mainItem = mainItem;
    this.secondItem = mainItem;
    this.lastItem = mainItem;
  }

  public CustomCoreRecipe(SlimefunItemStack material, ItemStack mainItem, ItemStack secondItem) {
    this.material = material;
    this.name = material.getItemId();
    this.mainItem = mainItem;
    this.secondItem = secondItem;
    this.lastItem = mainItem;
  }

  public CustomCoreRecipe(SlimefunItemStack material, ItemStack mainItem, ItemStack secondItem,
      ItemStack lastItem) {
    this.material = material;
    this.name = material.getItemId();
    this.mainItem = mainItem;
    this.secondItem = secondItem;
    this.lastItem = lastItem;
  }

  public CustomCoreRecipe(SlimefunItemStack material, org.bukkit.Material mainItem) {
    this(material, new ItemStack(mainItem, 1));
  }

  public CustomCoreRecipe(SlimefunItemStack material, org.bukkit.Material mainItem,
      org.bukkit.Material secondItem) {
    this(material, new ItemStack(mainItem, 1), new ItemStack(secondItem, 1));
  }

  public CustomCoreRecipe(SlimefunItemStack material, org.bukkit.Material mainItem,
      org.bukkit.Material secondItem, org.bukkit.Material lastItem) {
    this(material, new ItemStack(mainItem, 1), new ItemStack(secondItem, 1), new ItemStack(lastItem, 1));
  }

  private static ItemStack asMaxStack(ItemStack item) {
    if (item == null) {
      return null;
    }
    ItemStack clone = item.clone();
    clone.setAmount(clone.getType().getMaxStackSize());
    return clone;
  }

  public static ItemStack[] getRecipe(CustomCoreRecipe customCoreRecipe) {
    return new ItemStack[]{
        asMaxStack(customCoreRecipe.getMainItem()),
        asMaxStack(customCoreRecipe.getMainItem()),
        asMaxStack(customCoreRecipe.getMainItem()),
        asMaxStack(customCoreRecipe.getSecondItem()),
        asMaxStack(customCoreRecipe.getSecondItem()),
        asMaxStack(customCoreRecipe.getSecondItem()),
        asMaxStack(customCoreRecipe.getLastItem()),
        asMaxStack(customCoreRecipe.getLastItem()),
        asMaxStack(customCoreRecipe.getLastItem())
    };
  }

  public static SlimefunItemStack getOutput(CustomCoreRecipe customCoreRecipe) {
    return new SlimefunItemStack(customCoreRecipe.getMaterial(), 1);
  }

}
