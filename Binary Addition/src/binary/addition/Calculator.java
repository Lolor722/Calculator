package binary.addition;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator extends javax.swing.JFrame {
    private boolean operatorTyped = false;
    private boolean decimalAdded = false; 
    private boolean operate = false;
    
    public Calculator() {
        initComponents();
        Cal.setSelected(true);
       
    }
    
    public void calculate(){
      String expression = panelCalculator.getText().replaceAll("\\s", ""); // Remove whitespace

        try {
            double result = evaluateExpression(expression);
            String formattedResult;

            if (result == (int) result) {
                formattedResult = String.format("%d", (int) result);
                decimalAdded = false;
            } else {
                formattedResult = String.format("%.2f", result);
                decimalAdded = true;
            }

            panelCalculator.setText(formattedResult);
        } catch (Exception ex) {
            panelCalculator.setText("");
        }
        operate = false;
 }
     
  
 public void binaryAddition() {
    String input = panelCalculator.getText().replaceAll("\\s", ""); // Remove whitespace

    try {
        String[] parts = input.split("\\+");

        if (parts.length == 2) {
            String binary1 = convertDecimalToBinary(parts[0].trim());
            String binary2 = convertDecimalToBinary(parts[1].trim());

            if (isValidBinary(binary1) && isValidBinary(binary2)) {
                String resultBinary = addBinary(binary1, binary2);
                panelCalculator.setText(resultBinary);
            } else {
                panelCalculator.setText("Invalid binary input.");
            }
        } else {
            panelCalculator.setText("Invalid input format. Please use 'binary1 + binary2' format.");
        }
    } catch (NumberFormatException ex) {
        panelCalculator.setText("Invalid binary input.");
    }
}

    private boolean isValidBinary(String input) {
        return input.matches("[01]+(\\.[01]+)?");
    }

    private String convertDecimalToBinary(String decimal) {
        if (decimal.contains(".")) {
            String[] parts = decimal.split("\\.");
            int integerPart = Integer.parseInt(parts[0]);
            BigDecimal fractionalPart = new BigDecimal("0." + parts[1]);

            String binaryIntegerPart = Integer.toBinaryString(integerPart);
            String binaryFractionalPart = convertFractionalToBinary(fractionalPart);

            return binaryIntegerPart + "." + binaryFractionalPart;
        } else {
            return Integer.toBinaryString(Integer.parseInt(decimal));
        }
    }

    private String convertFractionalToBinary(BigDecimal fractional) {
        StringBuilder binaryFractional = new StringBuilder();
        int maxFractionalPlaces = 8; // You can adjust this value based on your requirements

        for (int i = 0; i < maxFractionalPlaces; i++) {
            fractional = fractional.multiply(BigDecimal.valueOf(2));
            int bit = fractional.intValue();
            binaryFractional.append(bit);
            fractional = fractional.subtract(BigDecimal.valueOf(bit));
        }
        return binaryFractional.toString();
    }

    private String addBinary(String binary1, String binary2) {
        String[] binary1Parts = binary1.split("\\.");
        String[] binary2Parts = binary2.split("\\.");

        StringBuilder resultBinary = new StringBuilder();
        String integerResult = addBinaryIntegers(binary1Parts[0], binary2Parts[0]);
        resultBinary.append(integerResult);

        String fractionalResult = addBinaryFractions(
                binary1Parts.length > 1 ? binary1Parts[1] : "",
                binary2Parts.length > 1 ? binary2Parts[1] : "");
        if (!fractionalResult.isEmpty()) {
            resultBinary.append(".").append(fractionalResult);
        }

        return resultBinary.toString();
    }

    private String addBinaryFractions(String binaryFraction1, String binaryFraction2) {
        int maxLength = Math.max(binaryFraction1.length(), binaryFraction2.length());
        StringBuilder resultFraction = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int bit1 = i < binaryFraction1.length() ? Character.getNumericValue(binaryFraction1.charAt(i)) : 0;
            int bit2 = i < binaryFraction2.length() ? Character.getNumericValue(binaryFraction2.charAt(i)) : 0;

            int sum = bit1 + bit2 + carry;
            resultFraction.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            resultFraction.append(carry);
        }

        return resultFraction.toString();
    }

    private String addBinaryIntegers(String binaryInteger1, String binaryInteger2) {
        int maxLength = Math.max(binaryInteger1.length(), binaryInteger2.length());
        StringBuilder resultInteger = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int bit1 = i < binaryInteger1.length() ? Character.getNumericValue(binaryInteger1.charAt(binaryInteger1.length() - 1 - i)) : 0;
            int bit2 = i < binaryInteger2.length() ? Character.getNumericValue(binaryInteger2.charAt(binaryInteger2.length() - 1 - i)) : 0;

            int sum = bit1 + bit2 + carry;
            resultInteger.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            resultInteger.insert(0, carry);
        }

        return resultInteger.toString();
    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Calculator = new javax.swing.JPanel();
        panelCalculator = new javax.swing.JTextField();
        delete1 = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        times = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        negate = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        dot = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        plus = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();
        one = new javax.swing.JButton();
        equal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Base = new javax.swing.JRadioButton();
        Cal = new javax.swing.JRadioButton();
        secret = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Calculator.setBackground(new java.awt.Color(255, 102, 153));
        Calculator.setLayout(null);

        panelCalculator.setBackground(new java.awt.Color(255, 204, 255));
        panelCalculator.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        panelCalculator.setForeground(new java.awt.Color(0, 0, 0));
        panelCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelCalculatorActionPerformed(evt);
            }
        });
        Calculator.add(panelCalculator);
        panelCalculator.setBounds(40, 60, 300, 70);

        delete1.setBackground(new java.awt.Color(153, 0, 102));
        delete1.setForeground(new java.awt.Color(255, 255, 255));
        delete1.setText("DLT");
        delete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        Calculator.add(delete1);
        delete1.setBounds(40, 280, 60, 100);

        minus.setBackground(new java.awt.Color(153, 0, 102));
        minus.setForeground(new java.awt.Color(255, 255, 255));
        minus.setText("-");
        minus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });
        Calculator.add(minus);
        minus.setBounds(160, 180, 60, 50);

        times.setBackground(new java.awt.Color(153, 0, 102));
        times.setForeground(new java.awt.Color(255, 255, 255));
        times.setText("X");
        times.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timesActionPerformed(evt);
            }
        });
        Calculator.add(times);
        times.setBounds(220, 180, 60, 50);

        divide.setBackground(new java.awt.Color(153, 0, 102));
        divide.setForeground(new java.awt.Color(255, 255, 255));
        divide.setText("/");
        divide.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divideActionPerformed(evt);
            }
        });
        Calculator.add(divide);
        divide.setBounds(280, 180, 60, 50);

        seven.setBackground(new java.awt.Color(153, 0, 102));
        seven.setForeground(new java.awt.Color(255, 255, 255));
        seven.setText("7");
        seven.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });
        Calculator.add(seven);
        seven.setBounds(100, 230, 60, 50);

        eight.setBackground(new java.awt.Color(153, 0, 102));
        eight.setForeground(new java.awt.Color(255, 255, 255));
        eight.setText("8");
        eight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });
        Calculator.add(eight);
        eight.setBounds(160, 230, 60, 50);

        nine.setBackground(new java.awt.Color(153, 0, 102));
        nine.setForeground(new java.awt.Color(255, 255, 255));
        nine.setText("9");
        nine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineActionPerformed(evt);
            }
        });
        Calculator.add(nine);
        nine.setBounds(220, 230, 60, 50);

        negate.setBackground(new java.awt.Color(153, 0, 102));
        negate.setForeground(new java.awt.Color(255, 255, 255));
        negate.setText("+/-");
        negate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        negate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negateActionPerformed(evt);
            }
        });
        Calculator.add(negate);
        negate.setBounds(280, 230, 60, 50);

        four.setBackground(new java.awt.Color(153, 0, 102));
        four.setForeground(new java.awt.Color(255, 255, 255));
        four.setText("4");
        four.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });
        Calculator.add(four);
        four.setBounds(100, 280, 60, 50);

        five.setBackground(new java.awt.Color(153, 0, 102));
        five.setForeground(new java.awt.Color(255, 255, 255));
        five.setText("5");
        five.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });
        Calculator.add(five);
        five.setBounds(160, 280, 60, 50);

        six.setBackground(new java.awt.Color(153, 0, 102));
        six.setForeground(new java.awt.Color(255, 255, 255));
        six.setText("6");
        six.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixActionPerformed(evt);
            }
        });
        Calculator.add(six);
        six.setBounds(220, 280, 60, 50);

        dot.setBackground(new java.awt.Color(153, 0, 102));
        dot.setForeground(new java.awt.Color(255, 255, 255));
        dot.setText(".");
        dot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        dot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dotActionPerformed(evt);
            }
        });
        Calculator.add(dot);
        dot.setBounds(280, 280, 60, 50);

        two.setBackground(new java.awt.Color(153, 0, 102));
        two.setForeground(new java.awt.Color(255, 255, 255));
        two.setText("2");
        two.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });
        Calculator.add(two);
        two.setBounds(160, 330, 60, 50);

        three.setBackground(new java.awt.Color(153, 0, 102));
        three.setForeground(new java.awt.Color(255, 255, 255));
        three.setText("3");
        three.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });
        Calculator.add(three);
        three.setBounds(220, 330, 60, 50);

        zero.setBackground(new java.awt.Color(153, 0, 102));
        zero.setForeground(new java.awt.Color(255, 255, 255));
        zero.setText("0");
        zero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });
        Calculator.add(zero);
        zero.setBounds(280, 330, 60, 50);

        plus.setBackground(new java.awt.Color(153, 0, 102));
        plus.setForeground(new java.awt.Color(255, 255, 255));
        plus.setText("+");
        plus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusActionPerformed(evt);
            }
        });
        Calculator.add(plus);
        plus.setBounds(100, 180, 60, 50);

        clear1.setBackground(new java.awt.Color(153, 0, 102));
        clear1.setForeground(new java.awt.Color(255, 255, 255));
        clear1.setText("CLR");
        clear1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });
        Calculator.add(clear1);
        clear1.setBounds(40, 180, 60, 100);

        one.setBackground(new java.awt.Color(153, 0, 102));
        one.setForeground(new java.awt.Color(255, 255, 255));
        one.setText("1");
        one.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });
        Calculator.add(one);
        one.setBounds(100, 330, 60, 50);

        equal.setBackground(new java.awt.Color(153, 0, 102));
        equal.setForeground(new java.awt.Color(255, 255, 255));
        equal.setText("=");
        equal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 153)));
        equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalActionPerformed(evt);
            }
        });
        Calculator.add(equal);
        equal.setBounds(40, 380, 300, 50);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Calculator");
        Calculator.add(jLabel1);
        jLabel1.setBounds(40, 30, 80, 17);

        Base.setBackground(new java.awt.Color(255, 102, 153));
        Base.setText("Base N");
        Base.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaseActionPerformed(evt);
            }
        });
        Calculator.add(Base);
        Base.setBounds(40, 130, 70, 21);

        Cal.setBackground(new java.awt.Color(255, 102, 153));
        Cal.setText("Basic Calculator");
        Cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalActionPerformed(evt);
            }
        });
        Calculator.add(Cal);
        Cal.setBounds(40, 150, 120, 21);

        secret.setText("jLabel2");
        Calculator.add(secret);
        secret.setBounds(280, 140, 10, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Calculator, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Calculator, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        int length = panelCalculator.getText().length();
        int num = panelCalculator.getText().length()-1;
        String store;
        if (length >0){
            StringBuilder back = new StringBuilder (panelCalculator.getText());
            back.deleteCharAt(num);
            store = back.toString();
            panelCalculator.setText(store);
        }
         decimalAdded = false;
         operate = false;
    }//GEN-LAST:event_delete1ActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        panelCalculator.setText(""); 
        decimalAdded = false;
        operate = false;
    }//GEN-LAST:event_clear1ActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"1");
         secret.setText(secret.getText()+"1");
          operate = false;
    }//GEN-LAST:event_oneActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"2");
         secret.setText(secret.getText()+"2");
          operate = false;
    }//GEN-LAST:event_twoActionPerformed

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"3");
         secret.setText(secret.getText()+"3");
          operate = false;
    }//GEN-LAST:event_threeActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
       panelCalculator.setText(panelCalculator.getText()+"4");
         secret.setText(secret.getText()+"4");
          operate = false;
    }//GEN-LAST:event_fourActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"5");
         secret.setText(secret.getText()+"5");
          operate = false;
    }//GEN-LAST:event_fiveActionPerformed

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"6");
         secret.setText(secret.getText()+"6");
          operate = false;
    }//GEN-LAST:event_sixActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"7");
         secret.setText(secret.getText()+"7");
          operate = false;
    }//GEN-LAST:event_sevenActionPerformed

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"8");
         secret.setText(secret.getText()+"8");
          operate = false;
    }//GEN-LAST:event_eightActionPerformed

    private void nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"9");
         secret.setText(secret.getText()+"9");
          operate = false;
    }//GEN-LAST:event_nineActionPerformed

    private void dotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dotActionPerformed
        if (!decimalAdded) {
            panelCalculator.setText(panelCalculator.getText() + ".");
            decimalAdded = true;
        }
    }//GEN-LAST:event_dotActionPerformed

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        panelCalculator.setText(panelCalculator.getText()+"0");
         secret.setText(secret.getText()+"0");
          operate = false;
    }//GEN-LAST:event_zeroActionPerformed

    private void negateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negateActionPerformed
        try {
    String input = panelCalculator.getText();
        int lastIndex = -1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '÷') {
                lastIndex = i;
            }
        }
        if (lastIndex != -1) {
            String beforeOperator = input.substring(0, lastIndex + 1);
            String afterOperator = input.substring(lastIndex + 1);
            if (afterOperator.contains(".")) {
                double number = Double.parseDouble(afterOperator);
                number = -number;
                afterOperator = String.valueOf(number);
            } else {
                int number = Integer.parseInt(afterOperator);
                number = -number;
                afterOperator = String.valueOf(number);
            }
            String updatedInput = beforeOperator + afterOperator;
            panelCalculator.setText(updatedInput.replaceAll("--", ""));
        } else { 
            if (input.startsWith("-")) { 
                panelCalculator.setText(input.substring(1));
            } else { 
                panelCalculator.setText("-" + input);
            }
        }
    } catch (NumberFormatException ex) { // Handle NumberFormatException
    }
    }//GEN-LAST:event_negateActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed
        if (!operate) {
            panelCalculator.setText(panelCalculator.getText() + "+");
            operate = true;
        }
       decimalAdded = false;
    }//GEN-LAST:event_plusActionPerformed

    private void timesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timesActionPerformed
        if (!operate) {
        if(panelCalculator.getText().equals("")){
           operate = false; 
        }else{
        panelCalculator.setText(panelCalculator.getText() + "*");
        operate = true;
        }
    }
        decimalAdded = false;
        
    }//GEN-LAST:event_timesActionPerformed

    private void divideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divideActionPerformed
        if (!operate) {
        if(panelCalculator.getText().equals("")){
           operate = false; 
        }else{
        panelCalculator.setText(panelCalculator.getText() + "/");
        operate = true;
        }
    }
        decimalAdded = false;
        
    }//GEN-LAST:event_divideActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
        if (!operate) {
        panelCalculator.setText(panelCalculator.getText() + "-");
        operate = true;
    }
        decimalAdded = false;
    }//GEN-LAST:event_minusActionPerformed

    private void equalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalActionPerformed
        if(Cal.isSelected()){
           calculate();
        }else if (Base.isSelected()){
           binaryAddition();
        }else{
            
        }  
    }//GEN-LAST:event_equalActionPerformed

    private void panelCalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelCalculatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelCalculatorActionPerformed

    private void BaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaseActionPerformed
        Cal.setSelected(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
        divide.setEnabled(false);
        times.setEnabled(false);
        minus.setEnabled(false);
        negate.setEnabled(false);
        panelCalculator.setText("");
    }//GEN-LAST:event_BaseActionPerformed

    private void CalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalActionPerformed
        Base.setSelected(false);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);
        divide.setEnabled(true);
        times.setEnabled(true);
        minus.setEnabled(true);
        negate.setEnabled(true);
        panelCalculator.setText("");
    }//GEN-LAST:event_CalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Base;
    private javax.swing.JRadioButton Cal;
    private javax.swing.JPanel Calculator;
    private javax.swing.JButton clear1;
    private javax.swing.JButton delete1;
    private javax.swing.JButton divide;
    private javax.swing.JButton dot;
    private javax.swing.JButton eight;
    private javax.swing.JButton equal;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton minus;
    private javax.swing.JButton negate;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JTextField panelCalculator;
    private javax.swing.JButton plus;
    private javax.swing.JLabel secret;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton three;
    private javax.swing.JButton times;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables

    private static double evaluateExpression(String expression) {
        try {
            return new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (Character.isWhitespace(ch)) nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                    return x;
                }

                double parseExpression() {
                    double x = parseTerm();
                    for (; ; ) {
                        if (eat('+')) x += parseTerm(); // addition
                        else if (eat('-')) x -= parseTerm(); // subtraction
                        else return x;
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    for (; ; ) {
                        if (eat('*')) x *= parseFactor(); // multiplication
                        else if (eat('÷')) x /= parseFactor(); // division
                        else return x;
                    }
                }

                double parseFactor() {
                    if (eat('+')) return parseFactor(); // unary plus
                    if (eat('-')) return -parseFactor(); // unary minus

                    double x;
                    int startPos = this.pos;
                    if (eat('(')) { // parentheses
                        x = parseExpression();
                        eat(')');
                    } else if (Character.isDigit(ch) || ch == '.') { // numbers
                        while (Character.isDigit(ch) || ch == '.') nextChar();
                        x = Double.parseDouble(expression.substring(startPos, this.pos));
                    } else {
                        throw new RuntimeException("Unexpected: " + (char) ch);
                    }

                    return x;
                }
            }.parse();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
    }
}
