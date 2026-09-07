package net.moddedmite.mitemod.bex.api;

import net.minecraft.Damage;

public interface IBEXEvasions {

    int bex$getNumEvasions();
	
	default void bex$setNumEvasions(int evasions) {
	}
	
	default void disableEvasionFromPhaseCounter(Damage damage) {
	}
}
