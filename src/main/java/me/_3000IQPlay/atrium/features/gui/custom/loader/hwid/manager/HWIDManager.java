package me._3000IQPlay.atrium.features.gui.custom.loader.hwid.manager;

import me._3000IQPlay.atrium.features.gui.custom.loader.hwid.util.DisplayUtil;
import me._3000IQPlay.atrium.features.gui.custom.loader.hwid.util.NoStackTraceThrowable;
import me._3000IQPlay.atrium.features.gui.custom.loader.hwid.util.SystemUtil;
import me._3000IQPlay.atrium.features.gui.custom.loader.hwid.util.URLReader;

import java.util.ArrayList;
import java.util.List;

public class HWIDManager {

    /**
     * Your pastebin URL goes inside the empty string below.
     * It should be a raw pastebin link, for example: pastebin.com/raw/pasteid
     */

    public static final String pastebinURL = "https://pastebin.com/raw/LVn3crjy";

    public static List<String> hwids = new ArrayList<>();

    public static void hwidCheck() {
        hwids = URLReader.readURL();
        boolean isHwidPresent = hwids.contains(SystemUtil.getSystemInfo());
        if (!isHwidPresent) {
            DisplayUtil.Display();
            throw new NoStackTraceThrowable("");
        }
    }
}
