package employee.productivity.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;


import com.toedter.calendar.JDateChooser;

public class UpdatEmploye extends JFrame implements ActionListener{
    
    JTextField tname , tcin , tadress , tphone , temail , tsalary , tstatut , tposte , tcontrat;
    JDateChooser tdate;
    JLabel tempid;
    JButton add,back;
    String number;

    UpdatEmploye(String number) {
        
        this.number = number;

        getContentPane().setBackground(new Color(163,255,188));

        JLabel titre = new JLabel("Modifier un employe");
        titre.setBounds(350, 30, 500, 50);
        titre.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(titre);

        JLabel name = new JLabel("Nom complet");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
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

        JLabel tdate = new JLabel();
        tdate.setBounds(600, 200, 150, 30);
        tdate.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
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

        tposte = new JTextField();
        tposte.setBounds(600, 300, 150, 30);
        tposte.setBackground(new Color(169, 250, 190));
        add(tposte);

        JLabel statut = new JLabel("Statut");
        statut.setBounds(50, 350, 150, 30);
        statut.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(statut);

        tstatut = new JTextField();
        tstatut.setBounds(200, 350, 150, 30);
        tstatut.setBackground(new Color(169, 250, 190));
        add(tstatut);

        JLabel contrat = new JLabel("Contrat ");
        contrat.setBounds(400,350,150,30);
        contrat.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(contrat);

        tcontrat= new JTextField();
        tcontrat.setBounds(600,350,150,30);
        tcontrat.setBackground(new Color(169, 250, 190));
        add(tcontrat);


        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(empid);

        tempid= new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        try {
            conn c = new conn();
            String query = "select * from employee where empId = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                tempid.setText(resultSet.getString("empId"));
                tcin.setText(resultSet.getString("cin"));
                tadress.setText(resultSet.getString("adress"));
                tposte.setText(resultSet.getString("poste"));
                tstatut.setText(resultSet.getString("statut"));
                tcontrat.setText(resultSet.getString("contrat"));
                tdate.setText(resultSet.getDate("datN") + "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        add = new JButton("MODIFIER");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("ANNULER");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdatEmploye("1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String phone = tphone.getText();
            String cin = tcin.getText();
            String adress = tadress.getText();
            String email = temail.getText();
            String salary = tsalary.getText();
            String poste = tposte.getText();
            String statut = tstatut.getText();
            String contrat = tcontrat.getText();
            try {
                conn c1 = new conn();
                String query = "update employee set phone = '"+phone+"', cin = '"+cin+"', adress = '"+adress+"', email = '"+email+"', salary = '"+salary+"', poste = '"+poste+"', statut = '"+statut+"', contrat = '"+contrat+"' where empId = '"+number+"'";
                c1.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employe modifié");
                setVisible(false);
                new Main_class();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }else if (e.getSource() == back){
            setVisible(false);
            new ViewEmploye();
        }
    }
}
