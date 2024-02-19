package dev.latvian.mods.kubejs.recipe.filter;

import dev.latvian.mods.kubejs.core.RecipeLikeKJS;

public class ModFilter implements RecipeFilter {
	private final String mod;

	public ModFilter(String m) {
		mod = m;
	}

	@Override
	public boolean test(RecipeLikeKJS r) {
		return r.kjs$getMod().equals(mod);
	}

	@Override
	public String toString() {
		return "ModFilter{" +
			"mod='" + mod + '\'' +
			'}';
	}
}