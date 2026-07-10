import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pang extends JFrame {
    // กำหนดตัวแปรส่วนประกอบของ GUI
    private JTextField txtCollected, txtMidterm, txtFinal, txtTotal, txtGrade;
    private JButton btnCalculate, btnClear;

    public pang() {
        // ตั้งค่าหน้าต่างโปรแกรม
        setTitle("โปรแกรมคำนวณเกรด");
        setSize(320, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // ส่วนหัวโปรแกรม (Header)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(175, 238, 207)); // สีเขียวอ่อนตามภาพ
        headerPanel.setBounds(0, 0, 320, 45);
        headerPanel.setLayout(new GridBagLayout());
        
        JLabel lblHeader = new JLabel("โปรแกรมคำนวณเกรด");
        lblHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
        headerPanel.add(lblHeader);
        add(headerPanel);

        Font labelFont = new Font("Tahoma", Font.PLAIN, 13);

        // คะแนนเก็บ
        JLabel lblCollected = new JLabel("คะแนนเก็บ");
        lblCollected.setFont(labelFont);
        lblCollected.setBounds(20, 65, 120, 30);
        add(lblCollected);

        txtCollected = new JTextField("30"); // ใส่ค่าเริ่มต้นตามภาพ
        txtCollected.setBounds(140, 65, 140, 30);
        add(txtCollected);

        // คะแนนกลางภาค
        JLabel lblMidterm = new JLabel("คะแนนกลางภาค");
        lblMidterm.setFont(labelFont);
        lblMidterm.setBounds(20, 110, 120, 30);
        add(lblMidterm);

        txtMidterm = new JTextField("30"); // ใส่ค่าเริ่มต้นตามภาพ
        txtMidterm.setBounds(140, 110, 140, 30);
        add(txtMidterm);

        // คะแนนปลายภาค
        JLabel lblFinal = new JLabel("คะแนนปลายภาค");
        lblFinal.setFont(labelFont);
        lblFinal.setBounds(20, 155, 120, 30);
        add(lblFinal);

        txtFinal = new JTextField("40"); // ใส่ค่าเริ่มต้นตามภาพ
        txtFinal.setBounds(140, 155, 140, 30);
        add(txtFinal);

        // ปุ่มคำนวณเกรด
        btnCalculate = new JButton("คำนวณเกรด");
        btnCalculate.setFont(labelFont);
        btnCalculate.setBackground(new Color(0, 153, 76)); // สีเขียวเข้ม
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setBounds(20, 200, 115, 35);
        add(btnCalculate);

        // ปุ่มล้างข้อมูล
        btnClear = new JButton("ล้างข้อมูล");
        btnClear.setFont(labelFont);
        btnClear.setBackground(new Color(220, 220, 220)); // สีเทา
        btnClear.setBounds(145, 200, 135, 35);
        add(btnClear);

        // คะแนนรวม
        JLabel lblTotal = new JLabel("คะแนนรวม");
        lblTotal.setFont(labelFont);
        lblTotal.setBounds(20, 250, 120, 30);
        add(lblTotal);

        txtTotal = new JTextField("100 / 100"); // แสดงผลตามภาพ
        txtTotal.setBounds(140, 250, 140, 30);
        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(JTextField.CENTER);
        txtTotal.setForeground(Color.BLUE);
        txtTotal.setBackground(new Color(240, 245, 255));
        add(txtTotal);

        // เกรดที่ได้
        JLabel lblGrade = new JLabel("เกรดที่ได้");
        lblGrade.setFont(labelFont);
        lblGrade.setBounds(20, 295, 120, 30);
        add(lblGrade);

        txtGrade = new JTextField("A"); // แสดงผลตามภาพ
        txtGrade.setBounds(140, 295, 140, 30);
        txtGrade.setEditable(false);
        txtGrade.setHorizontalAlignment(JTextField.CENTER);
        txtGrade.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtGrade.setForeground(new Color(0, 102, 0));
        txtGrade.setBackground(new Color(245, 250, 245));
        add(txtGrade);

        // การทำงานของปุ่มคำนวณเกรด
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double collected = Double.parseDouble(txtCollected.getText());
                    double midterm = Double.parseDouble(txtMidterm.getText());
                    double finalScore = Double.parseDouble(txtFinal.getText());

                    double total = collected + midterm + finalScore;

                    if (total > 100 || total < 0) {
                        JOptionPane.showMessageDialog(null, "คะแนนรวมต้องอยู่ระหว่าง 0 - 100 คะแนน", "ข้อผิดพลาด", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // แสดงคะแนนรวม
                    txtTotal.setText(String.format("%.0f / 100", total));

                    // เงื่อนไขการตัดเกรด
                    String grade;
                    if (total >= 80) grade = "A";
                    else if (total >= 75) grade = "B+";
                    else if (total >= 70) grade = "B";
                    else if (total >= 65) grade = "C+";
                    else if (total >= 60) grade = "C";
                    else if (total >= 55) grade = "D+";
                    else if (total >= 50) grade = "D";
                    else grade = "F";

                    txtGrade.setText(grade);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลเป็นตัวเลขให้ครบถ้วน", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // การทำงานของปุ่มล้างข้อมูล
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCollected.setText("");
                txtMidterm.setText("");
                txtFinal.setText("");
                txtTotal.setText("");
                txtGrade.setText("");
            }
        });
    }

    public static void main(String[] args) {
        // รันโปรแกรม
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new pang().setVisible(true);
            }
        });
    }
}