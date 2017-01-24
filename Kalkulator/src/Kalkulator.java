import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Kalkulator {
	
	Okno okno = new Okno();
	
	public static void main(String[] args) {
		new Kalkulator();
	}

	public class Okno extends JFrame {

		JTextField wyswietlacz = new JTextField("0");
		Panel panel = new Panel();
		
		public Okno() {
			super("Kalkulator");
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocation(400, 150);
			setBounds(100, 100, 365, 320);
			setBackground(new Color(255, 255, 255));
	        setResizable(false);
			
			panel.setLayout(null);
			panel.setBounds(100, 100, 400, 50);
			
			Font font = new Font("Calibri", Font.BOLD, 30);
			
			wyswietlacz.setLayout(null);
			wyswietlacz.setBounds(25, 25, 310, 50);
			wyswietlacz.setHorizontalAlignment(JTextField.RIGHT);
			wyswietlacz.setFont(font);
			
		    add(wyswietlacz);
		    add(panel);
		    
			setVisible(true);
		}
		
		public class Listener implements ActionListener {

			Double pamiec = 0.0;
			Double wartosc = 0.0;
			int operacja = 0;
			boolean kropka = false;
			boolean poKropce = false;
			String lastCommand = "";
			
			public String operacja() {
				switch (operacja) {
				case 1:
					wartosc = pamiec + wartosc;
					return wartosc.toString();
				case 2:
					wartosc = pamiec - wartosc;
					return wartosc.toString();
				case 3:
					wartosc = pamiec * wartosc;
					return wartosc.toString();
				case 4:
					if (wartosc == 0)
						return "Nie mo¿na dzieliæ przez zero";
					else {
						wartosc = pamiec / wartosc;
						return wartosc.toString();
					}
				default:
					return wartosc.toString();
				}
					
			}
			
			public String calkowite() {
				String wynik = wyswietlacz.getText();
				String zero = wynik.substring(wynik.length()-2, wynik.length());
				if (zero.equals(".0")) {
					if (kropka)
						return wynik.substring(0, wynik.length()-1);
					return wynik.substring(0, wynik.length()-2);
				}
				return wynik;
			}
			
			public void actionPerformed(ActionEvent event) {
				
				String command = event.getActionCommand();
			     switch(command) {
			          case "CE":
			        	  wyswietlacz.setText("0.0");
			        	  pamiec = 0.0;
			        	  wartosc = 0.0;
			        	  operacja = 0;
			        	  kropka = false;
			        	  poKropce = false;
			        	  break;
			          case "+":
			        	  wyswietlacz.setText(operacja());
			        	  pamiec = wartosc;
			        	  wartosc = 0.0;
			        	  operacja = 1;
			        	  kropka = false;
			        	  poKropce = false;
			        	  break;
			          case "-":
			        	  wyswietlacz.setText(operacja());
			        	  pamiec = wartosc;
			        	  wartosc = 0.0;
			        	  operacja = 2;
			        	  kropka = false;
			        	  poKropce = false;
			        	  break;
			          case "*":
			        	  wyswietlacz.setText(operacja());
			        	  pamiec = wartosc;
			        	  wartosc = 0.0;
			        	  operacja = 3;
			        	  kropka = false;
			        	  poKropce = false;
			        	  break;
			          case "/":
			        	  wyswietlacz.setText(operacja());
			        	  pamiec = wartosc;
			        	  wartosc = 0.0;
			        	  operacja = 4;
			        	  kropka = false;
			        	  poKropce = false;
			        	  break;
			          case ".":
			        	  wyswietlacz.setText(wartosc.toString());
			        	  kropka = true;
			        	  break;
			          case "=":
			        	  wyswietlacz.setText(operacja());
			        	  pamiec = 0.0;
			        	  operacja = 0;
			        	  kropka = false;
			        	  poKropce = false;
			        	  break;
			          default:
			        	  if (lastCommand.equals("="))
			        		  wartosc = 0.0;
			        	  
			        	  if (kropka) {
			        		  String wart = wartosc.toString();
			        		  if (!poKropce)
				        		  wart = wart.substring(0, wart.length()-1);
			        		  wart = wart + command;
			        		  wartosc = Double.parseDouble(wart);
			        		  poKropce = true;
			        	  }
			        	  else
			        		  wartosc = 10 * wartosc + Double.parseDouble(command);
			        	  
			        	  wyswietlacz.setText(wartosc.toString()); 
			        	  break;
			     }
			     lastCommand = command;
			     wyswietlacz.setText(calkowite());
			}
		}
		
		public class Panel extends JPanel {
			
			public Panel() {
				super();
				
				JButton button1 = new JButton("1");
				JButton button2 = new JButton("2");
				JButton button3 = new JButton("3");
				JButton button4 = new JButton("4");
				JButton button5 = new JButton("5");
				JButton button6 = new JButton("6");
				JButton button7 = new JButton("7");
				JButton button8 = new JButton("8");
				JButton button9 = new JButton("9");
				JButton button0 = new JButton("0");
				JButton kropka = new JButton(".");
				JButton rownanie = new JButton("=");
				JButton dodawanie = new JButton("+");
				JButton odejmowanie = new JButton("-");
				JButton mnozenie = new JButton("*");
				JButton dzielenie = new JButton("/");
				JButton kasowanie = new JButton("CE");
				
				button7.setBounds(25, 100, 50, 30);
			    button8.setBounds(90, 100, 50, 30);
			    button9.setBounds(155, 100, 50, 30); 
			    dzielenie.setBounds(220, 100, 50, 30);
			    kasowanie.setBounds(285, 100, 50, 75);
			    button4.setBounds(25, 145, 50, 30);
			    button5.setBounds(90, 145, 50, 30);
			    button6.setBounds(155, 145, 50, 30); 
			    mnozenie.setBounds(220, 145, 50, 30);
			    button1.setBounds(25, 190, 50, 30);
			    button2.setBounds(90, 190, 50, 30);
			    button3.setBounds(155, 190, 50, 30); 
			    odejmowanie.setBounds(220, 190, 50, 30);
			    rownanie.setBounds(285, 190, 50, 75);
			    button0.setBounds(25, 235, 115, 30);
			    kropka.setBounds(155, 235, 50, 30); 
			    dodawanie.setBounds(220, 235, 50, 30);
			    
			    setLayout(null);
			    
			    add(button1);
			    add(button2);
			    add(button3);
			    add(button4);
			    add(button5);
			    add(button6);
			    add(button7);
			    add(button8);
			    add(button9);
			    add(button0);
			    add(kropka);
			    add(rownanie);
			    add(dodawanie);
			    add(odejmowanie);
			    add(mnozenie);
			    add(dzielenie);
			    add(kasowanie);
			    
			    Listener listener = new Listener();
			    
			    button1.addActionListener(listener);
			    button2.addActionListener(listener);
			    button3.addActionListener(listener);   
			    button4.addActionListener(listener);
			    button5.addActionListener(listener);
			    button6.addActionListener(listener);
			    button7.addActionListener(listener);
			    button8.addActionListener(listener);
			    button9.addActionListener(listener);
			    button0.addActionListener(listener);
			    kropka.addActionListener(listener);
			    rownanie.addActionListener(listener);
			    dodawanie.addActionListener(listener);
			    odejmowanie.addActionListener(listener);   
			    mnozenie.addActionListener(listener);
			    dzielenie.addActionListener(listener);
			    kasowanie.addActionListener(listener);
			
			}
		}
	}
}
