package menuScreen;

import Utils.ImageReader;
import gameFrame.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonLikePanel extends JPanel{

    private ImageIcon buttonImage;
    private int width,heigth,x,y;
    private int currentWidth, currentHeight;
    private int currentX, currentY;
    private String function;
    private WellcomeFrame parent;
    private String serverAddress,port;
    public ButtonLikePanel(String name,int width, int heigth, int x, int y,ImageIcon icon,WellcomeFrame parrent) {
        this.parent = parrent;
        this.function = name;
        this.width = width;
        this.heigth = heigth;
        this.x = x;
        this.y = y;
        this.currentX=x;
        this.currentY=y;
        this.buttonImage = icon;
        this.currentHeight = heigth;
        this.currentWidth = width;
        this.setSize(width,heigth);
        this.setLocation(x,y);
        this.setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(name+" got pressed");
                animate();
                doCommand();
            }
        });
    }

    private void doCommand(){
        // this part really should be handled via reflection ...
        switch (function.toLowerCase()){
            case "new game":
                parent.getTheCore().setGameFrame(new GameFrame(parent.getTheCore(),"AOE",parent.getWidth(),parent.getHeight()));
                break;
//            case "creat new server": // gotta make sure that when we have a server we dont make a new one and maybe clients and servers should be passed to the core
//                Server server = new Server();
//                parent.setLoginMassage(server.getLoginMassage());
//                parent.setServerAddress(server.getServerIP());
//                parent.setPort(server.getServerPortNumber());
//                parent.setTheServer(server);
//                parent.setPaintMainScreen(false);
//                parent.repaint();
//                break;
//            case "join a server":
//                parent.setClone(new MainFrameClone());

        }
    }
    private void animate(){
        new Thread(() -> {
            for(int i=1;i<20;i++){
//                    currentWidth+=i*100;
//                    ButtonLikePanel.this.setSize(currentWidth,currentHeight);
                ButtonLikePanel.this.repaint();
                currentX-=100;
                ButtonLikePanel.this.setLocation(currentX, currentY);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentX =x;
            currentY=y;
            ButtonLikePanel.this.setLocation(currentX, currentY);
//                currentHeight = heigth;
//                currentWidth = width;
//                ButtonLikePanel.this.setSize(width,heigth);

        }).start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(buttonImage.getImage(),0,0,currentWidth,currentHeight,null);
    }
}
