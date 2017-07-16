package map.building;

import java.awt.*;
import java.awt.event.ComponentEvent;

/**
 * Created by bobvv on 7/16/17.
 */
public class BuildingSelectEvent extends ComponentEvent {
    /**
     * Constructs a <code>ComponentEvent</code> object.
     * <p> This method throws an
     * <code>IllegalArgumentException</code> if <code>source</code>
     * is <code>null</code>.
     *
     * @param source The <code>Component</code> that originated the event
     * @param id     An integer indicating the type of event.
     *               For information on allowable values, see
     *               the class description for {@link ComponentEvent}
     * @throws IllegalArgumentException if <code>source</code> is null
     * @see #getComponent()
     * @see #getID()
     */

    private Point point;
    public BuildingSelectEvent(Component source, int id,int x , int y) {
        super(source, id);
        this.point = new Point(x,y);
    }

    public Point getPoint()
    {
        return point;
    }

}
