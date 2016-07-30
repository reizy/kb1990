package ru.reizy.kb1990.view.android.resource;

import static ru.reizy.kb1990.R.anim.villains_0;
import static ru.reizy.kb1990.R.anim.villains_1;
import static ru.reizy.kb1990.R.anim.villains_10;
import static ru.reizy.kb1990.R.anim.villains_11;
import static ru.reizy.kb1990.R.anim.villains_12;
import static ru.reizy.kb1990.R.anim.villains_13;
import static ru.reizy.kb1990.R.anim.villains_14;
import static ru.reizy.kb1990.R.anim.villains_15;
import static ru.reizy.kb1990.R.anim.villains_16;
import static ru.reizy.kb1990.R.anim.villains_2;
import static ru.reizy.kb1990.R.anim.villains_3;
import static ru.reizy.kb1990.R.anim.villains_4;
import static ru.reizy.kb1990.R.anim.villains_5;
import static ru.reizy.kb1990.R.anim.villains_6;
import static ru.reizy.kb1990.R.anim.villains_7;
import static ru.reizy.kb1990.R.anim.villains_8;
import static ru.reizy.kb1990.R.anim.villains_9;
import static ru.reizy.kb1990.R.drawable.artifact_0;
import static ru.reizy.kb1990.R.drawable.artifact_1;
import static ru.reizy.kb1990.R.drawable.artifact_2;
import static ru.reizy.kb1990.R.drawable.artifact_3;
import static ru.reizy.kb1990.R.drawable.artifact_4;
import static ru.reizy.kb1990.R.drawable.artifact_5;
import static ru.reizy.kb1990.R.drawable.artifact_6;
import static ru.reizy.kb1990.R.drawable.artifact_7;
import static ru.reizy.kb1990.R.drawable.villains_0_1;
import static ru.reizy.kb1990.R.drawable.villains_10_1;
import static ru.reizy.kb1990.R.drawable.villains_11_1;
import static ru.reizy.kb1990.R.drawable.villains_12_1;
import static ru.reizy.kb1990.R.drawable.villains_13_1;
import static ru.reizy.kb1990.R.drawable.villains_14_1;
import static ru.reizy.kb1990.R.drawable.villains_15_1;
import static ru.reizy.kb1990.R.drawable.villains_16_1;
import static ru.reizy.kb1990.R.drawable.villains_1_1;
import static ru.reizy.kb1990.R.drawable.villains_2_1;
import static ru.reizy.kb1990.R.drawable.villains_3_1;
import static ru.reizy.kb1990.R.drawable.villains_4_1;
import static ru.reizy.kb1990.R.drawable.villains_5_1;
import static ru.reizy.kb1990.R.drawable.villains_6_1;
import static ru.reizy.kb1990.R.drawable.villains_7_1;
import static ru.reizy.kb1990.R.drawable.villains_8_1;
import static ru.reizy.kb1990.R.drawable.villains_9_1;

import java.util.ArrayList;

import ru.reizy.kb1990.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class VillainsTexture extends Texture {
	public final Bitmap[] MONEY = { null, null, null };
	public final ArrayList<Integer> villains_a = new ArrayList<Integer>();
	public final ArrayList<Integer> villains_i = new ArrayList<Integer>();
	public final ArrayList<Integer> artifacts_i = new ArrayList<Integer>();

	public VillainsTexture(Resources resources) {
		super(resources);
		// l a
		villains_a.add(villains_0);
		villains_a.add(villains_1);
		villains_a.add(villains_2);
		villains_a.add(villains_3);
		villains_a.add(villains_4);
		villains_a.add(villains_5);
		villains_a.add(villains_6);
		villains_a.add(villains_7);
		villains_a.add(villains_8);
		villains_a.add(villains_9);
		villains_a.add(villains_10);
		villains_a.add(villains_11);
		villains_a.add(villains_12);
		villains_a.add(villains_13);
		villains_a.add(villains_14);
		villains_a.add(villains_15);
		villains_a.add(villains_16);
		// l 1
		villains_i.add(villains_0_1);
		villains_i.add(villains_1_1);
		villains_i.add(villains_2_1);
		villains_i.add(villains_3_1);
		villains_i.add(villains_4_1);
		villains_i.add(villains_5_1);
		villains_i.add(villains_6_1);
		villains_i.add(villains_7_1);
		villains_i.add(villains_8_1);
		villains_i.add(villains_9_1);
		villains_i.add(villains_10_1);
		villains_i.add(villains_11_1);
		villains_i.add(villains_12_1);
		villains_i.add(villains_13_1);
		villains_i.add(villains_14_1);
		villains_i.add(villains_15_1);
		villains_i.add(villains_16_1);
		// l 1
		artifacts_i.add(artifact_0);
		artifacts_i.add(artifact_1);
		artifacts_i.add(artifact_2);
		artifacts_i.add(artifact_3);
		artifacts_i.add(artifact_4);
		artifacts_i.add(artifact_5);
		artifacts_i.add(artifact_6);
		artifacts_i.add(artifact_7);

		//
		MONEY[0] = ((BitmapDrawable) getResources().getDrawable(R.drawable.money_1)).getBitmap();
		MONEY[1] = ((BitmapDrawable) getResources().getDrawable(R.drawable.money_2)).getBitmap();
		MONEY[2] = ((BitmapDrawable) getResources().getDrawable(R.drawable.money_3)).getBitmap();

	}

}
