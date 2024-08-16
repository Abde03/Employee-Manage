package employee.productivity.system;

import java.awt.Image;

import javax.swing. *;

public class Splash extends JFrame{
    
    Splash() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1170, 650);
        add(l1);


        setSize( 1170 , 650);
        setLocation(100, 50);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            this.setVisible(false);
            new Login();
            
        } catch (Exception e) {
            e.printStackTrace();
    }
}

    public static void main(String[] args) {
        new Splash();
    }
}