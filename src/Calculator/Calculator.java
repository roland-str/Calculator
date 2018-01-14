/**
 * Created by evgen on 27.06.2017.
 * Калькулятор на Java.
 * Выполняет деление числа A на число B и выводит результат C.
 */

package Calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {
    Calculator(){

        setTitle("Calculator"); //заголовок окна
        setBounds(300, 300, 500, 200); //размеры окна
        setResizable(false); //запрещаем изменение размера окна

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //при закрытии окна процесс будет завершаться

        //Определяем поля для ввода данных, кнопку для результата деления и поле для вывода частного
        JTextField delimoeA = new JTextField();
        JTextField delitelB = new JTextField();
        JButton button = new JButton("=");
        JLabel chastnoe = new JLabel();
        delimoeA.setPreferredSize(new Dimension(30,20));
        delitelB.setPreferredSize(new Dimension(30,20));
        button.setPreferredSize(new Dimension(30,20));
        chastnoe.setPreferredSize(new Dimension(30,20));

        //определяем метки для полей ввода данных
        JLabel label = new JLabel("Делимое A",SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(30,20));
        JLabel label1 = new JLabel("Делитель B", SwingConstants.CENTER);
        label1.setPreferredSize(new Dimension(30,20));
        JLabel label3 = new JLabel("", SwingConstants.CENTER);
        label3.setPreferredSize(new Dimension(30,20));
        JLabel label2 = new JLabel("Частное C", SwingConstants.CENTER);
        label2.setPreferredSize(new Dimension(30,20));

        //используем панель с сеточной компоновкой
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        //панель для пояснения работы
        JLabel label4 = new JLabel("Введите числа A и B. Нажмите кнопку '=', чтобы получить результат деления C.");
        JPanel panel1 = new JPanel();

        //добавляем данные в панели
        panel1.add(label4);
        panel.add(label);
        panel.add(delimoeA);
        panel.add(label1);
        panel.add(delitelB);
        panel.add(label3);
        panel.add(button);
        panel.add(label2);
        panel.add(chastnoe);

        //добавляем панели в наше окно
        add(panel1,BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);

        //вычисление частного и обработка ошибок
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueA = delimoeA.getText();
                String valueB = delitelB.getText();
                chastnoe.setText(null);

                if (!symbolCheck(valueA) && !symbolCheck(valueB)){
                    delimoeA.setText(null);
                    JOptionPane.showMessageDialog(null, "Значения А и B не соответствуют условиям ввода!");
                }

                else if (!symbolCheck(valueA)){
                    delimoeA.setText(null);
                    JOptionPane.showMessageDialog(null, "Значение А не соответствует условиям ввода!");
                }
                else if (!symbolCheck(valueB)){
                    delitelB.setText(null);
                    JOptionPane.showMessageDialog(null, "Значение B не соответствует условиям ввода!");
                }
                else {
                    double A = Double.valueOf(valueA);
                    double B = Double.valueOf(valueB);
                    if (!checkZero(B)){
                        delitelB.setText(null);
                        JOptionPane.showMessageDialog(null, "Делитель B не должен быть равен нулю!");
                    }
                    else {
                        double C = (A/B);
                        chastnoe.setText(C + "");
                    }
                }
            }
        });
        setVisible(true);//видимость окна и полей
    }

    /**
     * Проверки на правильный ввод данных
     */

    public static Boolean symbolCheck(String symbols) {
        return symbols.matches("([-+])?\\d*\\.??\\d+");
}

    public static Boolean checkZero(Double number){
        return number != 0;
    }

    public static void main(String[] args) throws Exception{
        Calculator calculator = new Calculator();
    }
}
