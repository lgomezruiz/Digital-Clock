
package digitalclock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat; //class for formatting and parsing the time
    SimpleDateFormat dayFormat; //class for formatting and parsing the day of the week
    SimpleDateFormat dateFormat; //class for formatting and parsing date
    JLabel timeLabel; //Visual container for time
    JLabel dayLabel; //Visual container for day of the week
    JLabel dateLabel; //Visual container for date
    String time, day, date; //Variable for our local time, day and date
        
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit the application using the System exit method
        this.setTitle("My Digital Clock");
        this.setLayout(new FlowLayout()); //"Administrador de diseño" in spanish. Determines the orientation of the components
        this.setSize(350, 200); //weigth px, heigth px
        this.setResizable(false); //Size can not change
        
        //Formatting the time and date
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        
        //Settings of time Label
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x40E0D0));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        
        //Settings of day of the week Label
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        dayLabel.setForeground(new Color(0x40E0D0));
        dayLabel.setBackground(Color.BLACK);
        dayLabel.setOpaque(true);
        
        //Settings of day of date
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        dateLabel.setForeground(new Color(0x40E0D0));
        dateLabel.setBackground(Color.BLACK);
        dateLabel.setOpaque(true);
        
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true); //True because we want to see this windows
        
        setTime();
    }
    
    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            
            try {
                Thread.sleep(100); //0.1 second update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
      
}
