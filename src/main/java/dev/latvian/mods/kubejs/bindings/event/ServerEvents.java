package dev.latvian.mods.kubejs.bindings.event;

import dev.latvian.mods.kubejs.command.CommandRegistryEventJS;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.event.Extra;
import dev.latvian.mods.kubejs.recipe.AfterRecipesLoadedEventJS;
import dev.latvian.mods.kubejs.recipe.CompostableRecipesEventJS;
import dev.latvian.mods.kubejs.recipe.RecipesEventJS;
import dev.latvian.mods.kubejs.recipe.special.SpecialRecipeSerializerManager;
import dev.latvian.mods.kubejs.script.data.DataPackEventJS;
import dev.latvian.mods.kubejs.server.CommandEventJS;
import dev.latvian.mods.kubejs.server.CustomCommandEventJS;
import dev.latvian.mods.kubejs.server.ServerEventJS;
import dev.latvian.mods.kubejs.server.tag.TagEventJS;

public interface ServerEvents {
	EventGroup GROUP = EventGroup.of("ServerEvents");
	EventHandler LOW_DATA = GROUP.server("lowPriorityData", () -> DataPackEventJS.class);
	EventHandler HIGH_DATA = GROUP.server("highPriorityData", () -> DataPackEventJS.class);
	EventHandler LOADED = GROUP.server("loaded", () -> ServerEventJS.class);
	EventHandler UNLOADED = GROUP.server("unloaded", () -> ServerEventJS.class);
	EventHandler TICK = GROUP.server("tick", () -> ServerEventJS.class);
	EventHandler TAGS = GROUP.server("tags", () -> TagEventJS.class).extra(Extra.REQUIRES_REGISTRY);
	EventHandler COMMAND_REGISTRY = GROUP.server("commandRegistry", () -> CommandRegistryEventJS.class);
	EventHandler COMMAND = GROUP.server("command", () -> CommandEventJS.class).extra(Extra.STRING).hasResult();
	EventHandler CUSTOM_COMMAND = GROUP.server("customCommand", () -> CustomCommandEventJS.class).extra(Extra.STRING).hasResult();
	EventHandler RECIPES = GROUP.server("recipes", () -> RecipesEventJS.class);
	EventHandler RECIPES_AFTER_LOADED = GROUP.server("afterRecipes", () -> AfterRecipesLoadedEventJS.class);
	EventHandler SPECIAL_RECIPES = GROUP.server("specialRecipeSerializers", () -> SpecialRecipeSerializerManager.class);
	EventHandler COMPOSTABLE_RECIPES = GROUP.server("compostableRecipes", () -> CompostableRecipesEventJS.class);
}