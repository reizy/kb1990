package ru.reizy.kb1990.view.swing;

import java.util.ArrayList;
import java.util.List;

import ru.reizy.kb1990.model.globalmap.villains.Villain;

public class VilliansInfo {
	private static final List<VilliansInfo> info = new ArrayList<VilliansInfo>();

	static {
		{
			add("Murray the Miser", "None",
					"Threadbare clothes, bald patch with hair combed "
							+ "to cover it, incessant cough.",
					"Murray is wanted for various petty crimes as well "
							+ "as for treason. He allowed a group of pirates "
							+ "to enter the castle and free criminals.");
		}
		{
			add("Hack the Rogue", "The Spitter",
					"Bushy ebon beard stained with tobacco juice, numerous "
							+ "battle scars, brash, arrogant behavior.",
					"Along with many minor infractions, Hack is wanted for "
							+ "conspiracy against the Crown and grave-robbing.");
		}
		{
			add("Princess Almola", "Lady Deciet",
					"Excessive use of make-up to hide aging features, ever-"
							+ "present lace handkerchief.",
					"The princess violated her status as a visiting "
							+ "dignitary by encouraging a murder and joining "
							+ "the conspiracy against the crown.");
		}

		{//
			add("Baron Johnno Makahl",
					"Johnno",
					"Expensive and gaudy clothes, overweight, and a scruffy beard.",
					"Johnno is wanted for various crimes against the kingdom, "
							+ "including leading a direct assault against the crown "
							+ "and conspiracy.");
		}

		{//
			add("Dread Pirate Rob",
					"Terror of the Sea",
					"Pencil thin mustache and elegantly trimmed beard "
							+ "never without a rapier.",
					"Rob is wanted for piracy as well as for breaking "
							+ "out five traitors sentenced to death in the royal "
							+ "dungeons.");
		}

		{//
			add("Caneghor the Mystic",
					"The Majestic Sage",
					"Voluminous robes, bald head, magic symbols engraved "
							+ "on body, levitating ability.",
					"Caneghor is wanted for grave robbing, conspiracy "
							+ "against the crown and for plundering the royal library.");
		}

		{//
			add("Sir Moradon the Cruel", "None",
					"Always wearing armor and concealed weapons, has "
							+ "two prominent front teeth and an unkept beard.",
					"Sir Moradon, from another land is wanted for his "
							+ "part in a conspiracy to topple the kingdom.");
		}

		{//
			add("Prince Barrowpine",
					"The Elf Lord",
					"Pointed ears, sharp elfin features, pale blue eyes "
							+ "with no whites, glimmering enchanted coin.",
					"The prince is one of the leaders of the conspiracy "
							+ "against the crown. He also traffics stolen artifacts.");
		}

		{//
			add("Bargash Eyesore",
					"Old One Eye",
					"Single eye in center of head,over ten feet tall, "
							+ "only hair on body is beard.",
					"Bargash is wanted for conspiracy against the crown "
							+ "andfor leading an outright attack against the king.");
		}

		{//
			add("Rinaldus Drybone",
					"The death lord",
					"Rinaldus is a magically animated skeleton, an undead,"
							+ " he is easily identified by the crown he wears.",
					"Rinaldus is wanted for leading a conspiracy against "
							+ "the crown and leading a rebellion on the continent "
							+ "of Saharia.");
		}

		{//
			add("Ragface", "none",
					"Ragface is an undead, he is covered from head "
							+ "to toe in moldering green strips of cloth, "
							+ "a rotting smell follows him.",
					"Conspiracy against the crown and leading an "
							+ "insurrection in saharia.");
		}

		{//
			add("Mahk Bellowspeak",
					"Bruiser",
					"Bright orange body hair on a fluorescent green body. "
							+ "A tendency to shout for no apparent reason.",
					"Mahk is wanted for the conspiracy against the crown, "
							+ "leading a jail break and for piracy on the open seas. ");
		}

		{//
			add("Auric Whiteskin", "The Barbarian",
					"Auric is heavily muscled and wears a protective "
							+ "skin made from the hides of baby lambs.",
					"Auric is wanted for conspiracy and for leading "
							+ "the rebellion of the continent Saharia. ");
		}

		{//
			add("Czar Nikolai the Mad",
					"The Mad Czar ",
					"The czar has eyes which change colour constantly, he "
							+ "also has a sulphur smell emmanating from his body.",
					"The czar is wanted for leading a conspiracy against "
							+ "the crown for violating diplomatic immunity and "
							+ "for murder.");
		}

		{//
			add("Magus Deathspell", "None",
					"Pupil-less eyes, white beard, always wears crimson "
							+ "robes and a matching Skull cap.",
					"Magus is wanted for conspiracy against the crown and "
							+ "for practising forbidden magics.");
		}

		{//
			add("Urthrax Killspite", "The Demon King",
					"Green, Skaly skin, over 7 feet tall, horns protruding.",
					"Urthrax is wanted for conspiracy against the crown.");
		}

		{//
			add("Arech Dragonbreath", "Mastermind",
					"Arech is an immense dragon with a green body "
							+ "and blue wings, he breathes fire.",
					"Arech is wanted for the conspiracy against "
							+ "the crown, arranging jailbreaks, formenting "
							+ "rebellion, stealing the sceptre of order.");
		}

	}

	String name;
	String alias;
	String features;
	String crimes;

	private VilliansInfo(String name, String alias, String features,
			String crimes) {
		super();
		this.name = name;
		this.alias = alias;
		this.features = features;
		this.crimes = crimes;
	}

	private static void add(String name, String alias, String features,
			String crimes) {
		info.add(new VilliansInfo(name, alias, features, crimes));
	}

	public static VilliansInfo get(Villain v) {
		if (v != null) {
			if (v.getId() < info.size()) {
				return info.get(v.getId());
			} else {
				return new VilliansInfo(v.getId().toString(), "-", "-", "-");
			}
		} else {
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public String getAlias() {
		return alias;
	}

	public String getFeatures() {
		return features;
	}

	public String getCrimes() {
		return crimes;
	}

}
