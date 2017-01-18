package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StatusWindow extends JPanel

{
    private static final long serialVersionUID = 3136350037469268319L;
    List<ProgressPanel> progressPanels;
    private JPanel panelOfPanels;
    private JTextArea message;
    //JLabel label;
    public void initialise()
    {
        //label = new JLabel("0%");
        //add(label);
        progressPanels = new ArrayList<ProgressPanel>();
        panelOfPanels = new JPanel();
        message = new JTextArea();
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        add(panelOfPanels);
        add(new JScrollPane(message));
    }

    public StatusWindow()
    {
        initialise();
    }

    public void addMessage (String m)
    {
    	message.append(m);
    }

    public ProgressPanel addNew(String name)
    {
        if(name.trim().equals("")) return null;
        ProgressPanel pp = new ProgressPanel(name);
        progressPanels.add(pp);
        panelOfPanels.add(pp.getPanel());
        revalidate();
        repaint();
        return pp;
    }

    public ProgressPanel getPanel(String name)
    {
        for(ProgressPanel pp : progressPanels)
        {
            if(pp.getName().equals(name))
            {
                return pp;
            }
        }
        return null;
    }

    public void addProgress(String name, int progress)
    {
        ProgressPanel pp = getPanel(name);
        pp.addProgress(progress);
    }


}
