package gamePanel;

import java.awt.*;
import java.awt.event.ComponentEvent;

/**
 * Created by sarb on 7/14/17.
 */
public class ChangeTileSizeEvent extends ComponentEvent
{
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

    private int changeAmount;
    public ChangeTileSizeEvent(Component source, int id, int changeAmount)
    {
        super(source, id);
        this.changeAmount = changeAmount;
    }

    public int getChangeAmount()
    {
        return changeAmount;
    }
}
