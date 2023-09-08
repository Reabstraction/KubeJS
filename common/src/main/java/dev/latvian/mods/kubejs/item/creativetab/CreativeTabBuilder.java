package dev.latvian.mods.kubejs.item.creativetab;

import dev.latvian.mods.kubejs.platform.MiscPlatformHelper;
import dev.latvian.mods.kubejs.registry.BuilderBase;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class CreativeTabBuilder extends BuilderBase<CreativeModeTab> {
	public transient Component displayNameComponent;
	public transient CreativeTabIconSupplier icon;
	public transient CreativeTabContentSupplier content;

	public CreativeTabBuilder(ResourceLocation i) {
		super(i);
		this.displayNameComponent = null;
		this.icon = CreativeTabIconSupplier.DEFAULT;
		this.content = CreativeTabContentSupplier.DEFAULT;
	}

	@Override
	public final RegistryInfo getRegistryType() {
		return RegistryInfo.CREATIVE_MODE_TAB;
	}

	@Override
	public CreativeModeTab createObject() {
		return MiscPlatformHelper.get().creativeModeTab(
			displayNameComponent == null ? Component.translatable(getBuilderTranslationKey()) : displayNameComponent,
			new CreativeTabIconSupplier.Wrapper(icon),
			new CreativeTabContentSupplier.Wrapper(content)
		);
	}

	public CreativeTabBuilder displayNameComponent(Component displayNameComponent) {
		this.displayNameComponent = displayNameComponent;
		return this;
	}

	public CreativeTabBuilder icon(CreativeTabIconSupplier icon) {
		this.icon = icon;
		return this;
	}

	public CreativeTabBuilder content(CreativeTabContentSupplier content) {
		this.content = content;
		return this;
	}
}
