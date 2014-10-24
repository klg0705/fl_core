package fl.core.wsclient.calc.echo;

import fl.core.wsclient.calc.echo.Echo;
import fl.core.wsclient.calc.echo.Repeater;

public class EchoWSTestMain {

    public static void main(String[] args) {
        Repeater repeater = new Repeater();
        Echo echo = repeater.getEchoImplPort();
        System.out.println(echo.echo("Hello World!"));
    }

}
