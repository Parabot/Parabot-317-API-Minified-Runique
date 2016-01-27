package org.rev317.min.runique;

import org.parabot.core.Context;
import org.parabot.core.reflect.RefClass;
import org.parabot.core.ui.BotDialog;
import org.parabot.core.ui.BotUI;
import org.parabot.core.ui.components.GamePanel;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.input.Mouse;
import org.rev317.min.Loader;
import org.rev317.min.ui.BotMenu;

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
        final Object object = refClass.getField("m").asObject();
        Context.getInstance().setClientInstance(object);

        super.setTitle("Parabot - Runique");

        BotUI.getInstance().remove(GamePanel.getInstance());
        GamePanel.getInstance().removeAll();
        GamePanel.getInstance().removeComponents();

        BotUI.getInstance().setSize(new Dimension(BotUI.getInstance().getInsets().left + 769, BotUI.getInstance().getInsets().top + 525));

        final Context context = Context.getInstance();
        final Mouse mouse = new Mouse(BotUI.getInstance());
        BotUI.getInstance().addMouseListener(mouse);
        BotUI.getInstance().addMouseMotionListener(mouse);
        context.setMouse(mouse);

        Keyboard keyboard = new Keyboard(BotUI.getInstance());
        BotUI.getInstance().addKeyListener(keyboard);
        context.setKeyboard(keyboard);

        BotDialog.getInstance().validate();

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.toBack();
        this.dispose();

        Context.getInstance().getServerProvider().addMenuItems(BotUI.getInstance().getJMenuBar());
    }

    @Override
    public void addMouseListener(MouseListener mouseListener) {
        BotUI.getInstance().addMouseListener(mouseListener);
    }

    @Override
    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        BotUI.getInstance().addMouseMotionListener(mouseMotionListener);
    }

    @Override
    public void addMouseWheelListener(MouseWheelListener mouseWheelListener) {
        BotUI.getInstance().addMouseWheelListener(mouseWheelListener);
    }

    @Override
    public void addFocusListener(FocusListener focusListener) {
        BotUI.getInstance().addFocusListener(focusListener);
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
}
