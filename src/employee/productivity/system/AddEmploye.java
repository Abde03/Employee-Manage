package employee.productivity.system;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmploye extends  JFrame implements ActionListener{


    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname , tcin , tadress , tphone , temail , tsalary ;
    JDateChooser tdate;
    JLabel tempid;
    JComboBox tposte , tstatut , tcontrat;

    JButton add,back;

    
    
    AddEmploye() {

        getContentPane().setBackground(new Color(169, 150, 250));

        JLabel titre = new JLabel("Ajouter un employe");
        titre.setBounds(350, 30, 500, 50);
        titre.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(titre);

        JLabel name = new JLabel("Nom complet");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(169, 250, 190));
        add(tname);

        JLabel phone = new JLabel("N° de telephone");
        phone.setBounds(400, 150, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 150, 150, 30);
        tphone.setBackground(new Color(169, 250, 190));
        add(tphone);

        JLabel cin = new JLabel("N° CIN");
        cin.setBounds(50, 200, 150, 30);
        cin.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(cin);

        tcin = new JTextField();
        tcin.setBounds(200, 200, 150, 30);
        tcin.setBackground(new Color(169, 250, 190));
        add(tcin);

        JLabel date = new JLabel("Date de naissance");
        date.setBounds(400, 200, 150, 30);
        date.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(date);

        tdate = new JDateChooser();
        tdate.setBounds(600, 200, 150, 30);
        tdate.setBackground(new Color(169, 250, 190));
        add(tdate);

        JLabel adress = new JLabel("Adresse");
        adress.setBounds(50, 250, 150, 30);
        adress.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(adress);

        tadress = new JTextField();
        tadress.setBounds(200, 250, 150, 30);
        tadress.setBackground(new Color(169, 250, 190));
        add(tadress);

        JLabel email = new JLabel("Email");
        email.setBounds(400, 250, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(600, 250, 150, 30);
        temail.setBackground(new Color(169, 250, 190));
        add(temail);

        JLabel salary = new JLabel("Salaire");
        salary.setBounds(50, 300, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(200, 300, 150, 30);
        tsalary.setBackground(new Color(169, 250, 190));
        add(tsalary);

        JLabel poste = new JLabel("Poste");
        poste.setBounds(400, 300, 150, 30);
        poste.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(poste);

        String items[] = {"Manager", "Adminstration", "Security", "Professeur", "Femme de menage", "Autre"};

        tposte = new JComboBox(items);
        tposte.setBounds(600, 300, 150, 30);
        tposte.setBackground(new Color(169, 250, 190));
        add(tposte);

        JLabel statut = new JLabel("Statut");
        statut.setBounds(50, 350, 150, 30);
        statut.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(statut);

        String statutList[] = {"En cours", "Conger", "Arrêt", "Chômage"};

        tstatut = new JComboBox(statutList);
        tstatut.setBounds(200, 350, 150, 30);
        tstatut.setBackground(new Color(169, 250, 190));
        add(tstatut);

        JLabel contrat = new JLabel("Contrat ");
        contrat.setBounds(400,350,150,30);
        contrat.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(contrat);

        String contratList[] = {"CDI", "CDD", "Stage", "Alternance"};
        tcontrat= new JComboBox(contratList);
        tcontrat.setBounds(600,350,150,30);
        tcontrat.setBackground(new Color(169, 250, 190));
        add(tcontrat);


        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        add = new JButton("Ajouter");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Annuler");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String phone = tphone.getText();
            String cin = tcin.getText();
            String date = tdate.getDate().toString();
            String adress = tadress.getText();
            String email = temail.getText();
            String salary = tsalary.getText();
            String poste = (String) tposte.getSelectedItem();
            String statut = (String) tstatut.getSelectedItem();
            String contrat = (String) tcontrat.getSelectedItem();
            String empid = tempid.getText();

            try {
                conn c1 = new conn();
                String query = "insert into employee values('" + name + "','" + phone + "','" + cin + "','" + date + "','" + adress + "','" + email + "','" + salary + "','" + poste + "','" + statut + "','" + contrat + "' , '" + empid +"')";
                c1.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employe ajouté");
                setVisible(false);
                new Main_class();
            } catch (Exception e1) {
                e1.printStackTrace();
            
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmploye(); 
    }

}
