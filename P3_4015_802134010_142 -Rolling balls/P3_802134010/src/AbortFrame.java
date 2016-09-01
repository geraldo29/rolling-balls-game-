import javax.swing.JOptionPane;

/**
 * this class is to abort the game during gameplay.
 * @author geraldo
 *
 */
public class AbortFrame {
	
	AbortFrame(){

	final JOptionPane optionPane = new JOptionPane(
			"Are you sure you want to abort. This Game will NOT be saved.",
			JOptionPane.QUESTION_MESSAGE,
			JOptionPane.YES_NO_OPTION);
	
	
	}
}
