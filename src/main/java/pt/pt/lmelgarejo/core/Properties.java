package pt.pt.lmelgarejo.core;

import org.openqa.selenium.remote.Browser;

public class Properties {

    public static boolean FECHAR_BROWSER = true;
    public static Browsers browser = Browsers.CHROME;

    public enum Browsers{
        CHROME,
        FIREFOX
    }
}
