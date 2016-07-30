package ru.reizy.kb1990.model.base.artifact;

import ru.reizy.kb1990.model.base.PasleElement;
import ru.reizy.kb1990.model.base.Player;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

//... и фрагмент карты для по-
//иска Посоха Власти
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@type")
public interface Artifact extends PasleElement {
	Artifact[] artifacts = {//
	new RingOfHeroism(), new ArticlesOfNobility(), //
			new AnchorOfAdmiralty(), new ShieldOfProtection(), //
			new BookOfNecros(), new CrownOfCommand(), //
			new SwordOfProwess(), new AmuletOfAugmentation() };

	void activate(Player player);

}
