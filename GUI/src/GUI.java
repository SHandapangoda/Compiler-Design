import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

class UsingSwingClass extends JFrame {

    /**
     * Implementinng the input dialog box and show message
     *+box
     * Something to check on the showMessage dialog box
     * JOption.PLAIN_MESSAGE is the one without any icon
     */

    public UsingSwingClass(){
        setLocation(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea ta = new JTextArea(20,40);
        getContentPane().add(new JScrollPane(ta));
        pack();
        try{ta.read(new FileReader("C:/Users/Input.txt"),null);}catch(IOException ioe){}
    }

    public static void main(String[] args) {
        String input;
        String filepath;

        new UsingSwingClass().setVisible(true);
        input = JOptionPane.showInputDialog("input file path ");
        filepath = input;
        lexer lexer = new lexer(filepath);

        System.out.println("Lexical Analysis");
        System.out.println("-----------------");
        while (!lexer.isExhausted()) {
            System.out.printf("%-18s :  %s \n",lexer.currentLexeme() , lexer.currentToken());
            JOptionPane.showMessageDialog(null, "Lexemes : " + lexer.currentLexeme() , "Results", JOptionPane.PLAIN_MESSAGE );
            JOptionPane.showMessageDialog(null, "Tokens : " + lexer.currentToken() , "Results", JOptionPane.PLAIN_MESSAGE );
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
            JOptionPane.showMessageDialog(null, "OK!  : "  , "Results", JOptionPane.PLAIN_MESSAGE );
        } else {
            System.out.println(lexer.errorMessage());
            JOptionPane.showMessageDialog(null, "found an error : " + lexer.errorMessage() , "Results", JOptionPane.PLAIN_MESSAGE );
        }




        System.exit(0);

    }
}

// num2 = JOptionPane.showInputDialog("num2");
//        number2 = Integer.parseInt(num2);
//
//        sum = number1 + number2;
//
//        JOptionPane.showMessageDialog(null, "the sum is : " + sum , "Results", JOptionPane.PLAIN_MESSAGE );