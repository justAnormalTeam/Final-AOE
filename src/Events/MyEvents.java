package Events;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarb on 7/14/17.
 */
public class MyEvents extends JLabel
{
    public static final int CAMERA_LEFT = AWTEvent.RESERVED_ID_MAX + 1;
    public static final int CAMERA_RIGHT = AWTEvent.RESERVED_ID_MAX + 2;
    public static final int CAMERA_DOWN = AWTEvent.RESERVED_ID_MAX + 3;
    public static final int CAMERA_UP = AWTEvent.RESERVED_ID_MAX + 4;
    public static final int CHANGE_TILE_SIZE = AWTEvent.RESERVED_ID_MAX +5;
}
