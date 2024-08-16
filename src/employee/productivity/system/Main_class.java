package employee.productivity.system;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Main_class extends JFrame implements ActionListener{

    Main_class(){


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sup.png"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1120, 630);
        add(l1);
        
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        l1.add(heading);

        JButton add = new JButton("Ajoyter un employe");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddEmploye().setVisible(true);
        }
        });
        l1.add(add);

        JButton view = new JButton("Voir les employes");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmploye().setVisible(true);
            }
        });
        l1.add(view);

        JButton rem = new JButton("Suprimer un employe");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemovEmploye().setVisible(true);
            }
        });
        l1.add(rem);


        setSize(1120, 630);
        setLocation(100, 50);
        setLayout(null);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        new Main_class();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}


