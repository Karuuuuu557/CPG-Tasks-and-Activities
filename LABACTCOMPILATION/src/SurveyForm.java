import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class SurveyForm extends JFrame {

    public SurveyForm() {
        setTitle("Mendiola's Website Form Survey Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null);

        // ── Single vertical panel (portrait layout) ───────────────────────
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        // ── Helper to add a section divider ──────────────────────────────
        // (used inline below)

        // ─── HEADER ───────────────────────────────────────────────────────
        JLabel titleLabel = new JLabel("Tell me about my site! thanks...");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(4));

        JSeparator sep0 = new JSeparator();
        sep0.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep0.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep0);
        formPanel.add(Box.createVerticalStrut(12));

        // ─── *Name ────────────────────────────────────────────────────────
        JLabel nameLabel = new JLabel("*Name: first/second name, last name");
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        nameLabel.setForeground(new Color(180, 0, 0));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(nameField);
        formPanel.add(Box.createVerticalStrut(8));

        // ─── Gender ───────────────────────────────────────────────────────
        JPanel genderRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderRow.setBackground(Color.WHITE);
        genderRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        genderRow.add(new JLabel("Gender: "));
        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"F", "M"});
        genderCombo.setPreferredSize(new Dimension(60, 24));
        genderRow.add(genderCombo);
        formPanel.add(genderRow);
        formPanel.add(Box.createVerticalStrut(8));

        // ─── Birthdate & Age ──────────────────────────────────────────────
        JPanel bdRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bdRow.setBackground(Color.WHITE);
        bdRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel bdLabel = new JLabel("*Birthdate: ");
        bdLabel.setForeground(new Color(180, 0, 0));
        bdRow.add(bdLabel);
        JTextField bdField = new JTextField("mm-dd-yyyy", 11);
        bdField.setPreferredSize(new Dimension(110, 24));
        bdField.setForeground(Color.GRAY);
        bdField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (bdField.getText().equals("mm-dd-yyyy")) {
                    bdField.setText(""); bdField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (bdField.getText().isEmpty()) {
                    bdField.setText("mm-dd-yyyy"); bdField.setForeground(Color.GRAY);
                }
            }
        });
        bdRow.add(bdField);
        bdRow.add(new JLabel("   Age: "));
        JTextField ageField = new JTextField(5);
        ageField.setPreferredSize(new Dimension(60, 24));
        bdRow.add(ageField);
        formPanel.add(bdRow);
        formPanel.add(Box.createVerticalStrut(8));

        // ─── Country ──────────────────────────────────────────────────────
        JPanel countryRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        countryRow.setBackground(Color.WHITE);
        countryRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        countryRow.add(new JLabel("Country: "));
        JComboBox<String> countryCombo = new JComboBox<>(
            new String[]{"-select one-", "Philippines", "USA", "Japan", "Other"});
        countryCombo.setPreferredSize(new Dimension(150, 24));
        countryRow.add(countryCombo);
        formPanel.add(countryRow);
        formPanel.add(Box.createVerticalStrut(8));

        // ─── Email ────────────────────────────────────────────────────────
        JLabel emailLabel = new JLabel("*Email Address:");
        emailLabel.setForeground(new Color(180, 0, 0));
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
        emailField.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(emailField);
        formPanel.add(Box.createVerticalStrut(4));

        JLabel reqNote = new JLabel("*this field is required.");
        reqNote.setFont(new Font("SansSerif", Font.ITALIC, 10));
        reqNote.setForeground(new Color(180, 0, 0));
        reqNote.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(reqNote);

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep1 = new JSeparator();
        sep1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep1.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep1);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── How do you find my web page? ─────────────────────────────────
        JLabel webLabel = new JLabel("How do you find my web page?");
        webLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        webLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(webLabel);
        formPanel.add(Box.createVerticalStrut(8));

        // ─── Q1 ───────────────────────────────────────────────────────────
        JLabel q1 = new JLabel("1. How do you compare my web site to the others?");
        q1.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q1);
        formPanel.add(Box.createVerticalStrut(4));

        ButtonGroup q1Group = new ButtonGroup();
        for (String opt : new String[]{"Much Better", "About the same", "Much Worse", "Somewhat Better", "Somewhat Worse"}) {
            JRadioButton rb = new JRadioButton(opt);
            rb.setBackground(Color.WHITE);
            rb.setAlignmentX(Component.LEFT_ALIGNMENT);
            q1Group.add(rb);
            formPanel.add(rb);
        }

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep2 = new JSeparator();
        sep2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep2.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep2);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── Q2 ───────────────────────────────────────────────────────────
        JLabel q2 = new JLabel("2. Did you enjoy the Gallery?");
        q2.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q2);
        formPanel.add(Box.createVerticalStrut(4));

        ButtonGroup q2Group = new ButtonGroup();
        for (String opt : new String[]{"Yes", "No"}) {
            JRadioButton rb = new JRadioButton(opt);
            rb.setBackground(Color.WHITE);
            rb.setAlignmentX(Component.LEFT_ALIGNMENT);
            q2Group.add(rb);
            formPanel.add(rb);
        }

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep3 = new JSeparator();
        sep3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep3.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep3);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── Q3 ───────────────────────────────────────────────────────────
        JLabel q3 = new JLabel("3. How easy did you find it to navigate and find information?");
        q3.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q3);
        formPanel.add(Box.createVerticalStrut(6));

        String[] diffCols = {"", "Very Easy", "Easy", "Average", "Hard", "Very Hard"};
        String[] diffRows  = {"To navigate the site:", "To find needed information:"};

        JPanel tablePanel = new JPanel(new GridBagLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(new LineBorder(new Color(180, 180, 180), 1));
        tablePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        tablePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(3, 6, 3, 6);

        // Header row
        for (int c = 0; c < diffCols.length; c++) {
            g.gridy = 0; g.gridx = c;
            JLabel h = new JLabel(diffCols[c], SwingConstants.CENTER);
            h.setFont(new Font("SansSerif", Font.BOLD, 10));
            tablePanel.add(h, g);
        }

        // Data rows
        ButtonGroup[] rowGroups = new ButtonGroup[diffRows.length];
        for (int r = 0; r < diffRows.length; r++) {
            rowGroups[r] = new ButtonGroup();
            g.gridy = r + 1; g.gridx = 0;
            JLabel rl = new JLabel(diffRows[r]);
            rl.setFont(new Font("SansSerif", Font.PLAIN, 11));
            tablePanel.add(rl, g);
            for (int c = 1; c < diffCols.length; c++) {
                g.gridx = c;
                JRadioButton rb = new JRadioButton();
                rb.setBackground(Color.WHITE);
                rowGroups[r].add(rb);
                tablePanel.add(rb, g);
            }
        }
        formPanel.add(tablePanel);

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep4 = new JSeparator();
        sep4.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep4.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep4);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── Q4 ───────────────────────────────────────────────────────────
        JLabel q4 = new JLabel("4. Overall, how would you rate the graphics and look of the site?");
        q4.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q4);
        formPanel.add(Box.createVerticalStrut(4));

        ButtonGroup q4Group = new ButtonGroup();
        for (String opt : new String[]{"Excellent", "Good", "Poor", "Very Good", "Fair"}) {
            JRadioButton rb = new JRadioButton(opt);
            rb.setBackground(Color.WHITE);
            rb.setAlignmentX(Component.LEFT_ALIGNMENT);
            q4Group.add(rb);
            formPanel.add(rb);
        }

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep5 = new JSeparator();
        sep5.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep5.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep5);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── Q5 ───────────────────────────────────────────────────────────
        JLabel q5 = new JLabel("5. How likely would you be to return to my site?");
        q5.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q5);
        formPanel.add(Box.createVerticalStrut(4));

        ButtonGroup q5Group = new ButtonGroup();
        for (String opt : new String[]{"Definitely", "Not Sure", "Definitely Not", "Probably"}) {
            JRadioButton rb = new JRadioButton(opt);
            rb.setBackground(Color.WHITE);
            rb.setAlignmentX(Component.LEFT_ALIGNMENT);
            q5Group.add(rb);
            formPanel.add(rb);
        }

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep6 = new JSeparator();
        sep6.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep6.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep6);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── Q6 ───────────────────────────────────────────────────────────
        JLabel q6 = new JLabel("6. What did you like about the site?");
        q6.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q6);
        formPanel.add(Box.createVerticalStrut(4));

        JTextArea likeArea = new JTextArea(4, 20);
        likeArea.setBorder(new LineBorder(new Color(180, 180, 180)));
        likeArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        likeArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(likeArea);

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep7 = new JSeparator();
        sep7.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep7.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep7);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── Q7 ───────────────────────────────────────────────────────────
        JLabel q7 = new JLabel("7. What did you dislike about the site?");
        q7.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q7);
        formPanel.add(Box.createVerticalStrut(4));

        JTextArea dislikeArea = new JTextArea(4, 20);
        dislikeArea.setBorder(new LineBorder(new Color(180, 180, 180)));
        dislikeArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        dislikeArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(dislikeArea);

        formPanel.add(Box.createVerticalStrut(14));
        JSeparator sep8 = new JSeparator();
        sep8.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep8.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(sep8);
        formPanel.add(Box.createVerticalStrut(10));

        // ─── Q8 ───────────────────────────────────────────────────────────
        JLabel q8 = new JLabel("8. Your contact information. (optional)");
        q8.setFont(new Font("SansSerif", Font.BOLD, 12));
        q8.setAlignmentX(Component.LEFT_ALIGNMENT);
        formPanel.add(q8);
        formPanel.add(Box.createVerticalStrut(8));

        JPanel contactEmail = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        contactEmail.setBackground(Color.WHITE);
        contactEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        contactEmail.add(new JLabel("Email Address: "));
        JTextField contactEmailField = new JTextField(20);
        contactEmailField.setPreferredSize(new Dimension(200, 24));
        contactEmail.add(contactEmailField);
        formPanel.add(contactEmail);
        formPanel.add(Box.createVerticalStrut(6));

        JPanel mobileRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        mobileRow.setBackground(Color.WHITE);
        mobileRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        mobileRow.add(new JLabel("Mobile Number: "));
        JTextField mobileField = new JTextField(15);
        mobileField.setPreferredSize(new Dimension(170, 24));
        mobileRow.add(mobileField);
        formPanel.add(mobileRow);
        formPanel.add(Box.createVerticalStrut(14));

        // ─── Submit Button ─────────────────────────────────────────────────
        JButton submitBtn = new JButton("Submit");
        submitBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitBtn.setPreferredSize(new Dimension(100, 30));
        submitBtn.setMaximumSize(new Dimension(100, 30));
        submitBtn.setFont(new Font("SansSerif", Font.PLAIN, 12));
        submitBtn.addActionListener(e -> JOptionPane.showMessageDialog(
            SurveyForm.this,
            "Form submitted successfully!",
            "Success",
            JOptionPane.INFORMATION_MESSAGE));
        formPanel.add(submitBtn);
        formPanel.add(Box.createVerticalStrut(20));

        // ─── Wrap in a single scroll pane ─────────────────────────────────
        JScrollPane scroll = new JScrollPane(formPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(null);

        add(scroll);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new SurveyForm();
        });
    }
}