package ru.reizy.kb1990.view.android.resource;

import java.io.File;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Environment;

public class Util {
	public static final int ANIMATION_SPEED = 250;

	public static String countToView(int c) {
		String count = Integer.toString(c);
		if (c > 1000) {
			count = c / 1000 + "K";
		}
		return count;
	}

	public static boolean isLocalStorage(Context context) {
		String permission = "android.permission.WRITE_EXTERNAL_STORAGE";
		int res = context.checkCallingOrSelfPermission(permission);
		boolean b = (res == PackageManager.PERMISSION_GRANTED);
		return !b;
	}

	public static File getDir(Context context) {
		final File directory = isLocalStorage(context) ? getLocalDir(context) : getExternalDir();
		if (!directory.exists()) {
			directory.mkdir();
		}
		return directory;
	}

	public static File getLocalDir(Context context) {
		ContextWrapper cw = new ContextWrapper(context);
		final File directory = cw.getDir("media", Context.MODE_PRIVATE);
		return directory;
	}

	public static File getExternalDir() {
		final File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		return directory;
	}
}
