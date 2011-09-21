package net.oauth.example.desktop;

import com.centerkey.utils.BareBonesBrowserLaunch;

public class Get {
    public static void main(String[] args) throws Exception {
        for (String url : args) {
            BareBonesBrowserLaunch.browse(url);
        }
    }
}
