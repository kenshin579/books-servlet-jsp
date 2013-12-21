import java.awt.*;
import java.applet.Applet;

public class PluginTest extends Applet {
    String name;

    public void init() {
        name = getParameter("name");
    }

    public void paint(Graphics g) {
        g.drawString(name, 10, 10);
    }
}
