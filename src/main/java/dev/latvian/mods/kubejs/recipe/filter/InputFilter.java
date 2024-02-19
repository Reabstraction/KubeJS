package dev.latvian.mods.kubejs.recipe.filter;

import dev.latvian.mods.kubejs.core.RecipeLikeKJS;
import dev.latvian.mods.kubejs.recipe.ReplacementMatch;

public class InputFilter implements RecipeFilter {
	private final ReplacementMatch match;

	public InputFilter(ReplacementMatch match) {
		this.match = match;
	}

	@Override
	public boolean test(RecipeLikeKJS r) {
		return r.hasInput(match);
	}

	@Override
	public String toString() {
		return "InputFilter{" + match + '}';
	}
}