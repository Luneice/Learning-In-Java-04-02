import java.awt.*;
import javax.swing.*;

public class CalendarFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel labelDay[] = new JLabel[42];// 42������
	JLabel labelYear;// ����ݵı�ǩ
	JButton titleName[] = new JButton[7];// �����ڼ�
	JButton nextMonth, previousMonth;// �ŷ�ҳ��ť
	JLabel showMessage;// ��������ʾ��Ϣ
	JTextField inputYear;// �������ڿ�
	CalendarBean calendar;
	String name[] = { "��", "һ", "��", "��", "��", "��", "��" };
	int year = 2013, month = 1;
	String days[];
	public CalendarFrame() {
		calendar = new CalendarBean();
		calendar.setYear(year);
		calendar.setMonth(month);
		days = calendar.getCalendar();
		JScrollPane scrollPane = new JScrollPane(getCenterPanel());
		this.add(scrollPane, BorderLayout.CENTER);
		// �������scrollPane����������
		this.add(getNorthPanel(), BorderLayout.NORTH);
		// �������pNorth �ڱ�������
		this.add(getSouthPanel(), BorderLayout.SOUTH);
		// �������pSouth ��������
	}

	private JPanel getNorthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		inputYear = new JTextField(8);
		previousMonth = new JButton("��һ����");
		nextMonth = new JButton("��һ����");

		panel.add(new JLabel("���������"));
		panel.add(inputYear);
		panel.add(previousMonth);
		panel.add(nextMonth);
		return panel;
	}

	private JPanel getCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7));
		// ��panel�Ĳ�������Ϊ7��7�е�GridLayout����
		for (int i = 0; i < 7; i++) {
			titleName[i] = new JButton(name[i]);
			// panel������titleName[i]��
			panel.add(titleName[i]);
		}
		for (int i = 0; i < 42; i++) {
			labelDay[i] = new JLabel(days[i],JLabel.CENTER);
			// panel������labelDay[i]��
			panel.add(labelDay[i]);
		}
		return panel;
	}

	private JPanel getSouthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		showMessage = new JLabel("����");
		panel.add(showMessage);
		return panel;
	}
}
