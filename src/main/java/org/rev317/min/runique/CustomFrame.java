package org.rev317.min.runique;

import org.parabot.core.Context;
import org.parabot.core.reflect.RefClass;
import org.parabot.core.ui.BotDialog;
import org.parabot.core.ui.BotUI;
import org.parabot.core.ui.components.GamePanel;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.input.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Parnassian, JKetelaar
 */
public class CustomFrame extends JFrame {

    @Override
    public void setTitle(String title) {
        RefClass refClass = new RefClass(this);
        final Object object = refClass.getField("l").asObject();
        Context.getInstance().setClientInstance(object);

        super.setTitle("Parabot - Runique");

        BotUI.getInstance().remove(GamePanel.getInstance());
        GamePanel.getInstance().removeAll();
        GamePanel.getInstance().removeComponents();

        BotUI.getInstance().setSize(new Dimension(BotUI.getInstance().getInsets().left + 769, BotUI.getInstance().getInsets().top + 525));

        final Context context = Context.getInstance();
        final Mouse mouse = new Mouse(BotUI.getInstance());
        final Keyboard keyboard = new Keyboard(BotUI.getInstance());
        BotUI.getInstance().addMouseListener(mouse);
        BotUI.getInstance().addMouseMotionListener(mouse);
        BotUI.getInstance().addKeyListener(keyboard);

        context.setMouse(mouse);
        context.setKeyboard(keyboard);

        BotDialog.getInstance().validate();

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.toBack();
        this.dispose();

        Context.getInstance().getServerProvider().addMenuItems(BotUI.getInstance().getJMenuBar());
    }

    @Override
    public void addMouseListener(MouseListener mouseListener) {
        BotUI.getInstance().getContentPane().addMouseListener(mouseListener);
    }

    @Override
    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        BotUI.getInstance().getContentPane().addMouseMotionListener(mouseMotionListener);
    }

    @Override
    public void addMouseWheelListener(MouseWheelListener mouseWheelListener) {
        BotUI.getInstance().getContentPane().addMouseWheelListener(mouseWheelListener);
    }

    @Override
    public void addFocusListener(FocusListener focusListener) {
        BotUI.getInstance().getContentPane().addFocusListener(focusListener);
    }

    @Override
    public void addWindowListener(WindowListener windowListener) {
        BotUI.getInstance().addWindowListener(windowListener);
    }

    @Override
    public Graphics getGraphics() {
        // MOST IMPORTANT METHOD!
        Graphics graphics = BotUI.getInstance().getGraphics();
        graphics.translate(0, 0);
        return graphics;
    }

    @Override
    public void setMenuBar(MenuBar bar) {
        Menu parabot = new Menu("Parabot");
        MenuItem item = new MenuItem("Random");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /// u can do random shit here

            }
        });
        parabot.add(item);
        bar.add(parabot);

        super.setMenuBar(bar);
    }

    private void addRuniqueBar(){
        JMenu runique = new JMenu("Runique");
        JMenuItem mouse = new JMenuItem("Enable mouse");
        mouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Maybe have some nice actions here?
            }
        });
        runique.add(mouse);
        BotUI.getInstance().getJMenuBar().add(runique);
    }
}
