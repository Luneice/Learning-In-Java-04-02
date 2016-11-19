import java.awt.*;
import javax.swing.*;

public class CalendarFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel labelDay[] = new JLabel[42];// 42天日期
	JLabel labelYear;// 放年份的标签
	JButton titleName[] = new JButton[7];// 放星期几
	JButton nextMonth, previousMonth;// 放翻页按钮
	JLabel showMessage;// 最下面显示信息
	JTextField inputYear;// 输入日期框
	CalendarBean calendar;
	String name[] = { "日", "一", "二", "三", "四", "五", "六" };
	int year = 2013, month = 1;
	String days[];
	public CalendarFrame() {
		calendar = new CalendarBean();
		calendar.setYear(year);
		calendar.setMonth(month);
		days = calendar.getCalendar();
		JScrollPane scrollPane = new JScrollPane(getCenterPanel());
		this.add(scrollPane, BorderLayout.CENTER);
		// 窗口添加scrollPane在中心区域
		this.add(getNorthPanel(), BorderLayout.NORTH);
		// 窗口添加pNorth 在北面区域
		this.add(getSouthPanel(), BorderLayout.SOUTH);
		// 窗口添加pSouth 在南区域。
	}

	private JPanel getNorthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		inputYear = new JTextField(8);
		previousMonth = new JButton("上一个月");
		nextMonth = new JButton("下一个月");

		panel.add(new JLabel("请输入年份"));
		panel.add(inputYear);
		panel.add(previousMonth);
		panel.add(nextMonth);
		return panel;
	}

	private JPanel getCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7));
		// 将panel的布局设置为7行7列的GridLayout布局
		for (int i = 0; i < 7; i++) {
			titleName[i] = new JButton(name[i]);
			// panel添加组件titleName[i]。
			panel.add(titleName[i]);
		}
		for (int i = 0; i < 42; i++) {
			labelDay[i] = new JLabel(days[i],JLabel.CENTER);
			// panel添加组件labelDay[i]。
			panel.add(labelDay[i]);
		}
		return panel;
	}

	private JPanel getSouthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		showMessage = new JLabel("日历");
		panel.add(showMessage);
		return panel;
	}
}
