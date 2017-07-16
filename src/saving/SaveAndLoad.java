package saving;

import Events.MyEvents;
import Utils.ImageReader;
import core.Core;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ComponentEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by bobvv on 7/13/17.
 */
public class SaveAndLoad extends JPanel{
    private Core core;
    private MapEditorSave mapEditorSave;

    public SaveAndLoad(Core core){

        this.core = core;
        this.setLayout(null);
        this.setSize(100,100);


        JButton load = new JButton();
        load.setSize(50 , 50);
        load.setLocation(0,0);
        load.setIcon(ImageReader.createImage("/Assets/saveLoadIcons/load.jpg"));
        load.addActionListener(e ->
        {
            try
            {
                load();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1)
            {
                e1.printStackTrace();
            }
        });
        add(load);
    }

    public void load() throws IOException, ClassNotFoundException
    {
        final JFileChooser fileDialog = new JFileChooser(System.getProperty("user.dir"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("LOAD FILES", "map", "binary");
        fileDialog.setFileFilter(filter);
        int returnVal = fileDialog.showOpenDialog(core.getGameFrame());

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            java.io.File file = fileDialog.getSelectedFile();
        }


        FileInputStream fis;
        fis = new FileInputStream(fileDialog.getSelectedFile());

        ObjectInputStream oin;
        oin = new ObjectInputStream(fis);


        mapEditorSave = (MapEditorSave) oin.readObject();

        core.getMap().dispatchEvent(new ComponentEvent(this, MyEvents.LOAD));
        core.getMap().dispatchEvent(new ComponentEvent(this, MyEvents.UPDATE));
    }

    public MapEditorSave getMapEditorSave() {
        return mapEditorSave;
    }
}
