package ru.reizy.kb1990.view.android;

import java.io.Serializable;

public class KbViewOptions implements Serializable {
	private static final long serialVersionUID = 2716186334228551435L;

	private boolean lifeBarVisible;
	private boolean unitCountVisible;
	private boolean moraleVisible;
	private boolean exitButtonVisible;
	private int battleGridVisible;
	private boolean richMinimap;
	private boolean spellOnTownPortalVisible;

	public KbViewOptions() {
		super();
		this.lifeBarVisible = true;
		this.unitCountVisible = true;
		this.moraleVisible = true;
		this.battleGridVisible = 2;
		this.richMinimap = true;
		this.spellOnTownPortalVisible = true;
	}

	public boolean isLifeBarVisible() {
		return lifeBarVisible;
	}

	public boolean isUnitCountVisible() {
		return unitCountVisible;
	}

	public boolean isMoraleVisible() {
		return moraleVisible;
	}

	public int getBattleGridVisible() {
		return battleGridVisible;
	}

	public boolean isRichMinimap() {
		return richMinimap;
	}

	public boolean isSpellOnTownPortalVisible() {
		return spellOnTownPortalVisible;
	}

	public boolean isExitButtonVisible() {
		return exitButtonVisible;
	}

	public void setLifeBarVisible(boolean lifeBarVisible) {
		this.lifeBarVisible = lifeBarVisible;
	}

	public void setUnitCountVisible(boolean unitCountVisible) {
		this.unitCountVisible = unitCountVisible;
	}

	public void setMoraleVisible(boolean moraleVisible) {
		this.moraleVisible = moraleVisible;
	}

	public void setExitButtonVisible(boolean exitButtonVisible) {
		this.exitButtonVisible = exitButtonVisible;
	}

	public void setBattleGridVisible(int battleGridVisible) {
		this.battleGridVisible = battleGridVisible;
	}

	public void setRichMinimap(boolean richMinimap) {
		this.richMinimap = richMinimap;
	}

	public void setSpellOnTownPortalVisible(boolean spellOnTownPortalVisible) {
		this.spellOnTownPortalVisible = spellOnTownPortalVisible;
	}

}
