import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Automat.Machine;

public class MyGui {
    private Machine machine = new Machine();
    private int[] stateOfSpinners = new int[6];
    private JPanel MyPanel;
    private JButton anulujButton;
    private JButton a100zlButton;
    private JButton a200zlButton;
    private JButton a500zlButton;
    private JButton a1000zlButton;
    private JButton a2000zlButton;
    private JButton a5000zlButton;
    private JButton a001zlButton;
    private JButton a002zlButton;
    private JButton a005zlButton;
    private JButton a010zlButton;
    private JButton a020zlButton;
    private JButton a050zlButton;
    private JSpinner spinner_N_60;
    private JSpinner spinner_U_60;
    private JSpinner spinner_N_20;
    private JSpinner spinner_U_20;
    private JSpinner spinner_N_40;
    private JSpinner spinner_U_40;
    private JTextArea TextArea;

    public MyGui() {
        TextArea.setVisible(true);
        spinner_N_20.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer value = (Integer) spinner_N_20.getValue();
                if (value > 9) {
                    spinner_N_20.setValue(9);
                } else if (value < 0) {
                    spinner_N_20.setValue(0);
                } else {
                    if (value > stateOfSpinners[3]) {
                        machine.addTicket(3);
                    } else if (value < stateOfSpinners[3]) {
                        if (machine.deleteTicket(3)) {
                            machine.giveBackMoney();
                            resetSpinners();
                            setText();
                            value = (Integer) spinner_N_20.getValue();
                        }
                    }
                    stateOfSpinners[3] = value;
                    setText();
                }
            }
        });
        spinner_N_40.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer value = (Integer) spinner_N_40.getValue();
                if (value > 9) {
                    spinner_N_40.setValue(9);
                } else if (value < 0) {
                    spinner_N_40.setValue(0);
                } else {
                    if (value > stateOfSpinners[4]) {
                        machine.addTicket(4);
                    } else if (value < stateOfSpinners[4]) {
                        if (machine.deleteTicket(4)) {
                            machine.giveBackMoney();
                            resetSpinners();
                            setText();
                            value = (Integer) spinner_N_40.getValue();
                        }
                    }
                    stateOfSpinners[4] = value;
                    setText();
                }
            }
        });
        spinner_N_60.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer value = (Integer) spinner_N_60.getValue();
                if (value > 9) {
                    spinner_N_60.setValue(9);
                } else if (value < 0) {
                    spinner_N_60.setValue(0);
                } else {
                    if (value > stateOfSpinners[5]) {
                        machine.addTicket(5);
                    } else if (value < stateOfSpinners[5]) {
                        if (machine.deleteTicket(5)) {
                            machine.giveBackMoney();
                            resetSpinners();
                            setText();
                            value = (Integer) spinner_N_60.getValue();
                        }
                    }
                    stateOfSpinners[5] = value;
                    setText();
                }
            }
        });
        spinner_U_20.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer value = (Integer) spinner_U_20.getValue();
                if (value > 9) {
                    spinner_U_20.setValue(9);
                } else if (value < 0) {
                    spinner_U_20.setValue(0);
                } else {
                    if (value > stateOfSpinners[0]) {
                        machine.addTicket(0);
                    } else if (value < stateOfSpinners[0]) {
                        if (machine.deleteTicket(0)) {
                            machine.giveBackMoney();
                            resetSpinners();
                            setText();
                            value = (Integer) spinner_U_20.getValue();
                        }
                    }
                    stateOfSpinners[0] = value;
                    setText();
                }
            }
        });
        spinner_U_40.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer value = (Integer) spinner_U_40.getValue();
                if (value > 9) {
                    spinner_U_40.setValue(9);
                } else if (value < 0) {
                    spinner_U_40.setValue(0);
                } else {
                    if (value > stateOfSpinners[1]) {
                        machine.addTicket(1);
                    } else if (value < stateOfSpinners[1]) {
                        if (machine.deleteTicket(1)) {
                            machine.giveBackMoney();
                            resetSpinners();
                            setText();
                            value = (Integer) spinner_U_40.getValue();
                        }
                    }
                    stateOfSpinners[1] = value;
                    setText();
                }
            }
        });
        spinner_U_60.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Integer value = (Integer) spinner_U_60.getValue();
                if (value > 9) {
                    spinner_U_60.setValue(9);
                } else if (value < 0) {
                    spinner_U_60.setValue(0);
                } else {
                    if (value > stateOfSpinners[2]) {
                        machine.addTicket(2);
                    } else if (value < stateOfSpinners[2]) {
                        if (machine.deleteTicket(2)) {
                            machine.giveBackMoney();
                            resetSpinners();
                            setText();
                            value = (Integer) spinner_U_60.getValue();
                        }
                    }
                    stateOfSpinners[2] = value;
                    setText();
                }
            }
        });
        a001zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(0.01)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a002zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(0.02)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a005zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(0.05)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a010zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(0.10)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a020zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(0.20)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a050zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(0.50)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a100zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(1.00)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a200zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(2.00)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a500zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(5.00)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a1000zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(10.00)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a2000zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(20.00)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        a5000zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isHereAnyMoney()) {
                    if (machine.addMoney(50.00)) {
                        getTickets();
                        resetSpinners();
                    }
                }
                setText();
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                machine.giveBackMoney();
                resetSpinners();
                setText();
            }
        });
    }

    private void getTickets() {
        System.out.println("Wydrukowano:");
        for (int i = 0; i < 6; i++) {
            if (stateOfSpinners[i] != 0) {
                switch (i) {
                    case 0:
                        System.out.println(stateOfSpinners[i] + "bieltow normalnych 20min ");
                        break;
                    case 1:
                        System.out.println(stateOfSpinners[i] + "bieltow normalnych 50min ");
                        break;
                    case 2:
                        System.out.println(stateOfSpinners[i] + "bieltow normalnych 90min ");
                        break;
                    case 3:
                        System.out.println(stateOfSpinners[i] + "bieltow ulgowych 20min ");
                        break;
                    case 4:
                        System.out.println(stateOfSpinners[i] + "bieltow ulgowych 50min ");
                        break;
                    case 5:
                        System.out.println(stateOfSpinners[i] + "bieltow ulgowych 90min ");
                        break;
                }


            }
        }
    }

    private boolean isHereAnyMoney() {
        if (machine.getCostOfTickets() == 0) {
            System.out.println("Nie mozna dodac biletu");
            return false;
        }
        return true;
    }

    private void resetSpinners() {
        spinner_N_20.setValue(0);
        spinner_N_40.setValue(0);
        spinner_N_60.setValue(0);
        spinner_U_20.setValue(0);
        spinner_U_40.setValue(0);
        spinner_U_60.setValue(0);
        machine.setTicketsToZero();
    }

    private void setText() {
        if (machine.getCostOfTickets() == 0.0) {
            TextArea.setText(null);
        } else {
            TextArea.setText(String.valueOf(machine.getCostOfTickets()));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyGui");
        frame.setContentPane(new MyGui().MyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MyPanel = new JPanel();
        MyPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
        MyPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        anulujButton = new JButton();
        anulujButton.setText("anuluj");
        panel2.add(anulujButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a100zlButton = new JButton();
        a100zlButton.setText("1.00zl");
        panel3.add(a100zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a200zlButton = new JButton();
        a200zlButton.setText("2.00zl");
        panel3.add(a200zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a500zlButton = new JButton();
        a500zlButton.setText("5.00zl");
        panel3.add(a500zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a1000zlButton = new JButton();
        a1000zlButton.setText("10.00zl");
        panel3.add(a1000zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a2000zlButton = new JButton();
        a2000zlButton.setText("20.00zl");
        panel3.add(a2000zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a5000zlButton = new JButton();
        a5000zlButton.setText("50.00zl");
        panel3.add(a5000zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        a001zlButton = new JButton();
        a001zlButton.setText("0.01zl");
        panel4.add(a001zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a002zlButton = new JButton();
        a002zlButton.setText("0.02zl");
        panel4.add(a002zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a005zlButton = new JButton();
        a005zlButton.setText("0.05zl");
        panel4.add(a005zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a010zlButton = new JButton();
        a010zlButton.setText("0.10zl");
        panel4.add(a010zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a020zlButton = new JButton();
        a020zlButton.setText("0.20zl");
        panel4.add(a020zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a050zlButton = new JButton();
        a050zlButton.setText("0.50zl");
        panel4.add(a050zlButton, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel5, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Normalny 90min");
        panel5.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spinner_N_60 = new JSpinner();
        panel5.add(spinner_N_60, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spinner_U_60 = new JSpinner();
        panel5.add(spinner_U_60, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Ulgowy 90min");
        panel5.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel6, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Normalny 50min");
        panel6.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spinner_U_40 = new JSpinner();
        panel6.add(spinner_U_40, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spinner_N_40 = new JSpinner();
        panel6.add(spinner_N_40, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Ulgowy 50min");
        panel6.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel7, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Normalny 20min");
        panel7.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spinner_N_20 = new JSpinner();
        panel7.add(spinner_N_20, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spinner_U_20 = new JSpinner();
        panel7.add(spinner_U_20, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Ulgowy 20min");
        panel7.add(label6, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel8, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel8.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        TextArea = new JTextArea();
        TextArea.setText("");
        panel8.add(TextArea, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(75, 20), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel8.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        MyPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        MyPanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MyPanel;
    }

}
